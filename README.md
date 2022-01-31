
[![CircleCI](https://circleci.com/gh/devprathamesh/spring-boot-actuator-demo/tree/main.svg?style=svg)](https://circleci.com/gh/devprathamesh/spring-boot-actuator-demo/tree/main)
# Spring Boot Actuator Demo

A Sample Application demoing Spring Boot Actuator

Spring Actuator documentation available at [Documentation Link](https://docs.spring.io/spring-boot/docs/2.5.6/reference/html/actuator.html "Documentation")

Out of the box actuator endpoints:
```java
{
    "_links": {
        "self": {
            "href": "http://127.0.0.1:8080/actuator",
            "templated": false
        },
        "health": {
            "href": "http://127.0.0.1:8080/actuator/health",
            "templated": false
        },
        "health-path": {
            "href": "http://127.0.0.1:8080/actuator/health/{*path}",
            "templated": true
        }
    }
}
```

To enable additional actuator endpoints we need add below configuration
```java
management.endpoints.web.exposure.include=*
```
which will result in

```java
{
    "_links": {
        "self": {
            "href": "http://127.0.0.1:8080/actuator",
            "templated": false
        },
        "beans": {
            "href": "http://127.0.0.1:8080/actuator/beans",
            "templated": false
        },
        "caches-cache": {
            "href": "http://127.0.0.1:8080/actuator/caches/{cache}",
            "templated": true
        },
        "caches": {
            "href": "http://127.0.0.1:8080/actuator/caches",
            "templated": false
        },
        "health": {
            "href": "http://127.0.0.1:8080/actuator/health",
            "templated": false
        },
        "health-path": {
            "href": "http://127.0.0.1:8080/actuator/health/{*path}",
            "templated": true
        },
        "info": {
            "href": "http://127.0.0.1:8080/actuator/info",
            "templated": false
        },
        "conditions": {
            "href": "http://127.0.0.1:8080/actuator/conditions",
            "templated": false
        },
        "configprops": {
            "href": "http://127.0.0.1:8080/actuator/configprops",
            "templated": false
        },
        "configprops-prefix": {
            "href": "http://127.0.0.1:8080/actuator/configprops/{prefix}",
            "templated": true
        },
        "env": {
            "href": "http://127.0.0.1:8080/actuator/env",
            "templated": false
        },
        "env-toMatch": {
            "href": "http://127.0.0.1:8080/actuator/env/{toMatch}",
            "templated": true
        },
        "loggers": {
            "href": "http://127.0.0.1:8080/actuator/loggers",
            "templated": false
        },
        "loggers-name": {
            "href": "http://127.0.0.1:8080/actuator/loggers/{name}",
            "templated": true
        },
        "heapdump": {
            "href": "http://127.0.0.1:8080/actuator/heapdump",
            "templated": false
        },
        "threaddump": {
            "href": "http://127.0.0.1:8080/actuator/threaddump",
            "templated": false
        },
        "metrics": {
            "href": "http://127.0.0.1:8080/actuator/metrics",
            "templated": false
        },
        "metrics-requiredMetricName": {
            "href": "http://127.0.0.1:8080/actuator/metrics/{requiredMetricName}",
            "templated": true
        },
        "scheduledtasks": {
            "href": "http://127.0.0.1:8080/actuator/scheduledtasks",
            "templated": false
        },
        "mappings": {
            "href": "http://127.0.0.1:8080/actuator/mappings",
            "templated": false
        }
    }
} 
```

We can enhance /info endpoint to display customized dynamic information of the application.
Such as active user count, status of the application connected to it.
```java
{
    "application": {
        "name": "spring-boot-actuator-demo",
        "description": "Demo Project for Spring Boot Actuator",
        "version": "0.0.1-SNAPSHOT"
    },
    "productCountByStatus": {
        "inactive": 1,
        "active": 2
    }
}
```
This can be achieved by implementing a custom InfoContributor bean.