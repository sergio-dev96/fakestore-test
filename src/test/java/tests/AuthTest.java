package tests;

import config.BaseTest;
import config.Endpoints;
import config.Utils;
import factory.UserLoginFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import model.UserLoginResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.text.IsEmptyString.emptyString;

public class AuthTest extends BaseTest {

    @Test
    @Feature("Login")
    @Epic("Autenticacion")
    @Story("Usuario logueado correctamente")
    public void testLogin() {
        UserLoginResponse userLoginResponse = given()
                .filter(new AllureRestAssured())
            .body(UserLoginFactory.validUser())
            .post(Endpoints.LOGIN.getPath())
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(UserLoginResponse.class);

        assertThat(userLoginResponse.getAccess(),notNullValue());
        assertThat(userLoginResponse.getAccess(), CoreMatchers.not(emptyString()));

        Utils.token = userLoginResponse.getAccess();
    }
}
