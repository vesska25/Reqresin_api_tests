package com.vesska.tests;

import com.vesska.models.UserBody;
import com.vesska.models.RegistrationUserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static com.vesska.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTests {

    @Test
    @DisplayName("Registration test with valid data")
    void registrationTest() {
        UserBody data = new UserBody();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("pistol");

        RegistrationUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post("/register")
                .then()
                .spec(registrationResponseSpec)
                .extract().as(RegistrationUserResponse.class);
            assertEquals(response.getToken(), "QpwL5tke4Pnpja7X4");
            assertEquals(response.getId(), "4");
    }

    @Test
    @DisplayName("Registration test without password")
    void registrationTestWithoutPassword() {
        UserBody data = new UserBody();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("");

        given(requestSpec)
                .body(data)
                .when()
                .post("/register")
                .then()
                .spec(unsuccessfulRegistrationResponseSpec)
                .body("error", is("Missing password"));
    }

    @Test
    @DisplayName("Registration test without email")
    void registrationTestWithoutEmail() {
        UserBody data = new UserBody();
        data.setEmail("");
        data.setPassword("pistol");

        given(requestSpec)
                .body(data)
                .when()
                .post("/register")
                .then()
                .spec(unsuccessfulRegistrationResponseSpec)
                .body("error", is("Missing email or username"));

    }


}
