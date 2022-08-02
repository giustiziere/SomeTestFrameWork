package steps;

import dto.UserDTO;
import dto.UsersListDTO;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Slf4j
public class RestSteps {

    @Step
    public UsersListDTO getUserListResponse() {
        var response = when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .extract().as(UsersListDTO.class);
        log.info("Response:\n" + response.toString());
        return response;
    }

    @Step
    public void checkUserList(UsersListDTO response) {
        assertTrue(isClassFieldValuesNotNull(response));
        response.getData().forEach(user -> assertTrue(isClassFieldValuesNotNull(user)));
        assertTrue(isClassFieldValuesNotNull(response.getSupport()));
    }

    @Step
    public UserDTO postNewUser(UserDTO user) {
        log.info("Posting:\n" + user.toString());
        var response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .extract().as(UserDTO.class);
        log.info("Response:\n" + response.toString());
        return response;
    }

    @Step
    public void checkPostNewUser(UserDTO user, UserDTO response) {
        assertTrue(isClassFieldValuesNotNull(response));
        assertEquals(response.getName(), user.getName());
        assertEquals(response.getJob(), user.getJob());
    }

    private boolean isClassFieldValuesNotNull(Object obj) {
        return Arrays.stream(obj.getClass().getDeclaredFields()).allMatch(field -> {
            try {
                field.setAccessible(true);
                return field.get(obj) != null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return false;
        });
    }
}
