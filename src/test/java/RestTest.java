import dp.UsersDataProviders;
import dto.UserDTO;
import org.testng.annotations.Test;
import steps.RestSteps;

public class RestTest {
    private final RestSteps restSteps = new RestSteps();

    @Test(description = "Get full user list and check it for nullability")
    public void getUserList() {
        var response = restSteps.getUserListResponse();
        restSteps.checkUserList(response);
    }

    @Test(description = "Post new user and check equality",
            dataProviderClass = UsersDataProviders.class, dataProvider = "newUser")
    public void postNewUser(UserDTO user) {
        var response = restSteps.postNewUser(user);
        restSteps.checkPostNewUser(user, response);
    }
}
