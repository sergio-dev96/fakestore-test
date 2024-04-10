package factory;

import builder.UserLoginBuilder;
import com.github.javafaker.Faker;
import model.UserLogin;
import org.apache.commons.lang3.StringUtils;

public class UserLoginFactory {
    private static final Faker faker = new Faker();
    private static final String DEFAULT_USERNAME = "sergiobbr";
    private static final String DEFAULT_PASSWORD = "sergiobbr";

    public static UserLogin validUser() {
        return newUserRequest();
    }

    public static UserLogin missingAllInformation() {
        return new UserLoginBuilder()
                .username(StringUtils.EMPTY)
                .password(StringUtils.EMPTY)
                .build();
    }

    private static UserLogin newUserRequest() {
        return new UserLoginBuilder()
                .username(DEFAULT_USERNAME)
                .password(DEFAULT_PASSWORD)
                .build();
    }
}
