# README #

## О репозитории ##

#### Простая реализация REST API для заметок с помощью: ####
* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Jersey 2.22.2](https://jersey.github.io/)
* [Maven 3.5.2](https://maven.apache.org/download.cgi)

#### Запросы на сервер передаются в формате JSON: ####
```json
{ "message": "Hello world!" }
```

## Быстрый старт ##

* `cd rest-notes/`
* `mvn exec:java`

## Отправка запроса ##

#### Отправка запросов на сервер будет осуществляться при помощи [curl](https://curl.haxx.se/) ####

> Далее идут примеры доступных запросов. **request.json** - файл, содержащий нужный запрос формата json.

### GET ###
`curl -H "Content-Type: application/json" http://localhost:8080/`

### POST ###
*Синтаксис:*
```json
{
	"title": "Текст заголовка",
	"text": "Текст заметки"
}
```
`curl -H "Content-Type: application/json" -X POST -d @request.json  http://localhost:8080/`

### PUT ###
*Синтаксис:*
```json
{
	"id": "10dcdccb-8876-4245-ac53-92900c6509bd",
	"title": "Текст заголовка",
	"text": "Текст заметки"
}
```
`curl -H "Content-Type: application/json" -X PUT -d @request.json http://localhost:8080/`

### DELETE ###
*Синтаксис:*
```json
{ "id": "10dcdccb-8876-4245-ac53-92900c6509bd" }
```
`curl -H "Content-Type: application/json" -X DELETE -d @request.json  http://localhost:8080/`

## Автор ##

* *Vadim Metnyov*