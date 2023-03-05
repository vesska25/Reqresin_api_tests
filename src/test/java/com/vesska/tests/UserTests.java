package com.vesska.tests;

import com.vesska.models.CreateUser;
import com.vesska.models.CreateUserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.vesska.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    @Test
    @DisplayName("New user creation test")
    void createUserTest() {
        CreateUser data = new CreateUser();
        data.setName("morpheus");
        data.setJob("leader");

        CreateUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post("/users")
                .then()
                .spec(createUserResponseSpec)
                .extract().as(CreateUserResponse.class);
        assertEquals(response.getName(), "morpheus");
        assertEquals(response.getJob(), "leader");
    }
    @Test
    void updateUserJobTest() {

        CreateUser data = new CreateUser();
        data.setName("morpheus");
        data.setJob("zion resident");

        given()
                .spec(requestSpec)
                .when()
                .body(data)
                .put("/users/2")
                .then()
                .spec(response200)
                .extract().as(CreateUser.class);
        assertEquals(data.getName(), "morpheus");
        assertEquals( data.getJob(), "zion resident");
    }
}
