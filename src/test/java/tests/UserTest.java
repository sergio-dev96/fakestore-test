package tests;

import config.BaseTest;
import config.Endpoints;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.User;
import model.UserInvalidResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.StringContains.containsStringIgnoringCase;

public class UserTest extends BaseTest {

    @Test
    @Feature("Registro")
    @Story("Usuario no registrado por falta de datos")
    @Epic("Registro de usuario")
    public void registerUserWithEmptyData() {
        UserInvalidResponse userResponse = given()
                .body(factory.UserFactory.missingAllInformation())
                .post(Endpoints.REGISTER.getPath())
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .as(UserInvalidResponse.class);

        var matcher = hasItem(containsStringIgnoringCase("may not be blank"));

        assertThat(userResponse.getUsername(),matcher);
        assertThat(userResponse.getFirstName(),matcher);
        assertThat(userResponse.getLastName(),matcher);
        assertThat(userResponse.getEmail(),matcher);
        assertThat(userResponse.getPassword(),matcher);
    }
}
