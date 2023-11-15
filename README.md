
# VkiCalculetion

Bu projede vücut kitle indexsi hesaplanması veritabanı işlemlerinin vapılması mevcuttur.
FrontEnd:
Kullanıcılar gerekli bilgileri girerek girilen verilerin database e kayıt edilmesi ,güncellenmesi, listelenmesi, silinmesi  gibi işlemlerin yapıldığı arayüz bölümdür
BackEnd:
Kullanıcıların girdikleri verileri REST Api  ile aktarıldığı servisler aracılığı ile kaydetme,silme,güncelleme,silme (CRUD) gibi  işlemlerinin yapıldığı   bölümdür.

## FrontEnd
### Kullanılan teknolojiler;
-Html 5
-Css3
-Bootstrap 5
-JavaScript
-Rest Api
-React Router
-React

### Run FrontEnd=>
- npm install
- npm start

## BackEnd:
### Kullanılan teknolojiler;
-java Spring Boot
-Spring Data
-Spiring Api
-Lombok
-H2DB

## Servisler hakkında

bu servi vki servisidir. dataları tutmak içi *H2* kullanılmaktadır. port **3737** kullanmaktadır. servisler de kayıt, güncelleme, listeleme, silme gibi işlemler yapılmaktadır.

### Api ler hakında bilgiler .

```
http://localhost:3737/api/speed-data/{id} => girilen sayı kadar otomatik veri üretir
http://localhost:3737/api/delete/all => Tüm veriyi siler
http://localhost:3737/api/find/{id} => id ye göre arama yapar
http://localhost:3737/api/search => gelen isime göre arama yapar
http://localhost:3737/api/create => Veriyi kayeder
http://localhost:3737/api/list => tüm veriyi listeler
http://localhost:3737/api/update/{id} => id ye göre veriyi günceller
http://localhost:3737/api/delete/{id} => id ye göre siler
http://localhost:3737/api/referenceVki => vki değerlerini tutar

```

### Kaydet

```
POST /api/create
Accept: application/json
Content-Type: application/json
{
"uname" : "Ali Çetin",
"ukilo" : "1",
"uheight" : "1",
}
RESPONSE: HTTP 200
Location header: http://localhost:3737/api/create
```

### Tüm liste

```GET /Api/list
Response: HTTP 200
http://localhost:3737/api/list
```
### id liste

```GET /find/{id}
Response: HTTP 200
http://localhost:3737/api/find/1
```
### Güncelleme
```
PUT /api/update/id,registerDto
Accept: application/json
Content-Type: application/json
{
"uname" : "Ali Çetin",
"ukilo" : "2",
"uheight" : "2"
}
RESPONSE: HTTP 200
http://localhost:3737/api/update/1

```
### Delete id
```DELETE /delete/1
Response: HTTP 200
http://localhost:3737/api/delete/1

```
# Spring Boot Hakkında

Spring Boot da Spring Data, Spring Api, Lombok ,H2DB kullanıldı.

**/business** Kulanıcıdan gelen verilerin değişken olarak tanımlanması ve servis işlemleri

**/controller** Rest Api islemleri

**/data** database değişkenlerinin oluşturlması ve sorgular

**/exception** istisna durumları

### Database olarak H2 kullanımı
Kayıt edilen verileri görmek için  http://localhost:3737/h2-console.
Kullanıcı adı:sa
şifre:yok

###Run BackEnd=>
Kullanıdığınız IDE ile dosyayı açıp çalıştırabilirisiniz.

# Sorular ve Yorumlar: Alimcetin37@gmail.com

#VkiCalculetion

This project includes body mass index calculation and database operations.
FrontEnd:
This is the interface section where users enter the necessary information and perform operations such as recording, updating, listing and deleting the entered data in the database.
BackEnd:
This is the section where operations such as saving, deleting, updating, deleting (CRUD) are performed through services where the data entered by users is transferred via REST API.

## FrontEnd
### Used technologies;

-Html 5
-Css3
-Bootstrap 5
-JavaScript
-Rest Api
-React Router
-React

### Run FrontEnd=>
- npm install
- npm start

## BackEnd:
### Used technologies;
-java Spring Boot
-Spring Data
-Spiring Api
-Lombok
-H2DB

## About services

This service is the vki service. *H2* is used to store data. It uses port **3737**. Services such as recording, updating, listing and deleting are performed.

### Information about APIs.
```
http://localhost:3737/api/speed-data/{id} => automatically generates data as the entered number
http://localhost:3737/api/delete/all => Deletes all data
http://localhost:3737/api/find/{id} => searches by id
http://localhost:3737/api/search => searches based on the incoming name
http://localhost:3737/api/create => Saves data
http://localhost:3737/api/list => lists all data
http://localhost:3737/api/update/{id} => updates data according to id
http://localhost:3737/api/delete/{id} => deletes by id
http://localhost:3737/api/referenceVki => holds vki values

```

### Kaydet

```
POST /api/create
Accept: application/json
Content-Type: application/json
{
"uname" : "Ali Çetin",
"ukilo" : "1",
"uheight" : "1",
}
RESPONSE: HTTP 200
Location header: http://localhost:3737/api/create
```

### Tüm liste

```GET /Api/list
Response: HTTP 200
http://localhost:3737/api/list
```
### id liste

```GET /find/{id}
Response: HTTP 200
http://localhost:3737/api/find/1
```
### Güncelleme
```
PUT /api/update/id,registerDto
Accept: application/json
Content-Type: application/json
{
"uname" : "Ali Çetin",
"ukilo" : "2",
"uheight" : "2"
}
RESPONSE: HTTP 200
http://localhost:3737/api/update/1

```
### Delete id
```DELETE /delete/1
Response: HTTP 200
http://localhost:3737/api/delete/1

```
# About Spring Boot

Spring Data, Spring Api, Lombok, H2DB were used in Spring Boot.

**/business** Defining user data as variables and service operations

**/controller** Rest Api operations

**/data** creation of database variables and queries

**/exception** exception cases

### Using H2 as database
To see recorded data: http://localhost:3737/h2-console.
Username:sa
password: none

###Run BackEnd=>
You can open and run the file with the IDE you use.

# Questions and Comments: Alimcetin37@gmail.com
