
# Bookstore

Simple Bookstore application for add, del, update and read books. 

## API Reference

#### Base URL

```http
http://localhost:8080/bookstore
```

| uri | http method     | description                | required
| :-------- | :------- | :------------------------- | -------- |
| `/categories` | `GET` | list all categories | 
| `/categories/{id}` | `GET` | add a category, |**id**  |
| `/categories` | `POST` | add a category, |**body**  |
| `/categories` | `PUT` | update a category|**body**  |
| `/categories` | `DELETE` | add a category |


## Tech Stack

**Client:** Angular

**Server:** Spring Boot, Heroku

