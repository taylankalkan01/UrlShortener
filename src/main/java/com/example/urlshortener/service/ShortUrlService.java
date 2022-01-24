package com.example.urlshortener.service;

import com.example.urlshortener.exception.CodeAlreadyExists;
import com.example.urlshortener.exception.ShortUrlNotFoundException;
import com.example.urlshortener.model.ShortUrl;
import com.example.urlshortener.repository.ShortUrlRepository;
import com.example.urlshortener.util.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {

    private final ShortUrlRepository repository;
    private final RandomStringGenerator randomStringGenerator;


    public ShortUrlService(ShortUrlRepository repository,
                           RandomStringGenerator randomStringGenerator) {
        this.repository = repository;
        this.randomStringGenerator = randomStringGenerator;
    }


    public List<ShortUrl> getAllShortUrl() {
        return repository.findAll();
    }


    public ShortUrl getUrlByCode(String code) {
        return repository.findAllByCode(code).orElseThrow(
                ()-> new ShortUrlNotFoundException("this url is not found!")
        );
    }

    public ShortUrl create(ShortUrl shortUrl) {
        if(shortUrl.getCode() ==null || shortUrl.getCode().isEmpty()){
            shortUrl.setCode(generateCode());
        }
        else if(repository.findAllByCode(shortUrl.getCode()).isPresent()){
            throw new CodeAlreadyExists(" '"+shortUrl.getCode() + "' is already exists");
        }
        shortUrl.setCode(shortUrl.getCode().toUpperCase());
        return repository.save(shortUrl);
    }

    private String generateCode(){
        String code;

        do{
            code = randomStringGenerator.generateRandomString();
        }
        while (repository.findAllByCode(code).isPresent());

        return code;
    }


}
