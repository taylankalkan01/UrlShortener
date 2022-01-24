In this project I recoded FolksDev URL Shortener Project


# Url Shortener Project

This is a simple url shortener project which is using in-memory db.


### Tech Stack

---
- Java 11
- Spring Boot
- Spring Data JPA and Hibernate
- Lombok
- Exception Handling
- Validation
- H2 In memory database

### Prerequisites

---
- Maven

---

## API Reference


- #### Get all urls

```http
  GET /all
```
#### Response:
```javascript
[
    {
        "id": 1,
        "url": "https://www.google.com.tr",
        "code": "GG"
    },
    {
        "id": 2,
        "url": "https://www.youtube.com",
        "code": "YT"
    }
]
```
##

- #### Redirect

```http
  GET /{code}
```
You will be redirected to the URL of the code.

##

- #### Show Url of Code (alias)

```http
  GET /show/{code}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `code`      | `string` | **Required**. Code of url to fetch |

#### Response:
```javascript
{
    "id": 1,
    "url": "https://www.google.com.tr",
    "code": "GG"
}
```
##

- #### Create Short Url

```http
  POST /
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `url`      | `string` | **Required**. Code of url to fetch |
| `code`      | `string` | **Not Required**. If it is null or empty, it will be created automatically. |

#### Request:
```javascript
{
    "url": "https://www.google.com.tr",
    "code": "g"
}
```

#### Response:
```javascript
{
    "id": 3,
    "url": "https://www.google.com.tr",
    "code": "G"
}
```



    