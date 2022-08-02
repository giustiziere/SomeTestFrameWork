package dp;

import dto.UserDTO;
import org.testng.annotations.DataProvider;

public class UsersDataProviders {

    @DataProvider(name = "newUser")
    public static Object[][] getNewUser() {
        return new Object[][]{
                {
                    UserDTO.builder()
                            .name("morpheus")
                            .job("leader")
                            .build()
                }
        };
    }
}
