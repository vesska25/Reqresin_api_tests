package com.vesska.tests;

import com.vesska.models.RegistrationUserError;
import com.vesska.models.RegistrationUserResponse;
import com.vesska.models.UserBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.vesska.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests {

    @Test
    @DisplayName("Login test with valid data")
    void loginTest() {
        UserBody data = new UserBody();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");

        RegistrationUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(successfulLoginResponseSpec)
                .extract().as(RegistrationUserResponse.class);

        assertEquals(response.getToken(), "QpwL5tke4Pnpja7X4");
    }


    @Test
    @DisplayName("Login test without password")
    void loginTestWithoutPassword() {
        UserBody data = new UserBody();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("");

        RegistrationUserError response = given(requestSpec)
                .body(data)
                .when()
                .post("/login")
                .then()
                .spec(unsuccessfulRegistrationResponseSpec)
                .extract().as(RegistrationUserError.class);
        assertEquals(response.getError(), "Missing password");
    }
}
