**vite** (is French for "Quick")

## About
* Vite provides APIs on big data loaded in [Elastic Search](https://www.elastic.co/products/elasticsearch) indices.
* These APIs can be consumed by UI Client to provide custom search options. 

## Technology
* Java 8
* Spring-boot - 1.5.19.RELEASE
* Elastic Search - 6.4.0 
* springfox-swagger2 – 2.9.4
* springfox-swagger-ui — 2.9.4


## Installation
* [Download Elastic Search](https://www.elastic.co/downloads/past-releases/elasticsearch-6-4-0) 
* Access indices at url: http://127.0.0.1:9200/_cat/indices?v
* [Load sample data into Elastic Search](https://www.elastic.co/guide/en/kibana/6.4/tutorial-load-dataset.html)
* Create new database with name vite_db using script schema.sql under resources.

## build

```
mvn clean install
```

```
mvn spring-boot:run
```

APIs can be accessed at :
```
http://localhost:8000/vite/swagger-ui.html
```
