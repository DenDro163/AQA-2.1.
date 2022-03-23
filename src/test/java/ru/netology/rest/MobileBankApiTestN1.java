package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class MobileBankApiTestN1 {
    @Test
    void ShouldReturnDemoAccount() {
        given()//Дано given
                //Обращаемся к методом через "."
                .baseUri("http://localhost:9999/api/v1")//Обращаемся к URI
                //Делаем что-то when
                .when()
                //Запрос идет get, поэтому вызываем метод get
                .get("/demo/accounts")
                //Получаем результат then
                .then()
                //Пишем проверки, нужен код ответа сервера 200
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}
