package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestN2 {
    @Test
    void ShouldReturnDemoAccountCurrency() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                //Проверяем тело ответа
                .body("", hasSize(3))//Проверяем размер тела ответа
                //Обращаемся к полю "currency" элементов тела ответа
                .body("[0].currency", equalTo("RUB"))//Обращаемся к элементу по индексу
                .body("[1].currency", equalTo("USD"))
                .body("[2].currency", equalTo("RUB"))
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}


