# API Testing Specification

## GET Request Testing
Tags: get, api

* Set base URI to "https://httpbin.org"
* Send GET request to "/get" with parameters:
  |parameter|value|
  |---------|-----|
  |name     |test |
  |age      |25   |
* Verify response status code is "200"
* Verify response contains parameter "name" with value "test"
* Verify response contains parameter "age" with value "25"

## POST Request Testing
Tags: post, api

* Set base URI to "https://httpbin.org"
* Send POST request to "/post" with JSON body:
  |key      |value |
  |---------|------|
  |username |admin |
  |password |123456|
* Verify response status code is "200"
* Verify response contains JSON field "json.username" with value "admin"
* Verify response contains JSON field "json.password" with value "123456"