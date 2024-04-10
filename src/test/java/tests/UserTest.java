package tests;

import config.BaseTest;
import config.Endpoints;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.User;
import model.UserInvalidResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.StringContains.containsStringIgnoringCase;

@Tags({@Tag("regression")})
public class UserTest extends BaseTest {

    @Test
    @Epic("Administración de usuarios")
    @Feature("Registro de usuario")
    @Story("Registrar usuario con datos válidos")
    public void registerUserWithValidData() {
            given()
                .body(factory.UserFactory.validUser())
                .post(Endpoints.REGISTER.getPath())
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    @Epic("Administración de usuarios")
    @Feature("Registro de usuario")
    @Story("Validar que los datos del usuario contengan toda la información necesaria para el registro")
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
        assertThat(userResponse.getEmail(),matcher);
        assertThat(userResponse.getPassword(),matcher);
        assertThat(userResponse.getFirstName(),matcher);
        assertThat(userResponse.getLastName(),matcher);
    }

    @Test
    @Epic("Administración de usuarios")
    @Feature("Registro de usuario")
    @Story("Validar que el email del usuario sea válido")
    public void registerUserWithInvalidEmail() {
        UserInvalidResponse userResponse = given()
                .body(factory.UserFactory.newUserWithInvalidEmail())
                .post(Endpoints.REGISTER.getPath())
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .as(UserInvalidResponse.class);

        var matcher = hasItem(containsStringIgnoringCase("Enter a valid email address"));
        assertThat(userResponse.getEmail(),matcher);
    }

    @Test
    @Epic("Administración de usuarios")
    @Feature("Registro de usuario")
    @Story("Validar que la contraseña cumpla con la política de contraseñas")
    public void registerUserWithShortPassword() {
        UserInvalidResponse userResponse = given()
                .body(factory.UserFactory.newUserWithShortPassword())
                .post(Endpoints.REGISTER.getPath())
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .as(UserInvalidResponse.class);

        assertThat(userResponse.getPassword(),notNullValue());
    }
}
