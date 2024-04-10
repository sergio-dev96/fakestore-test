package factory;

import builder.UserBuilder;
import com.github.javafaker.Faker;
import model.User;
import org.apache.commons.lang3.StringUtils;

public class UserFactory {

    private static final Faker faker = new Faker();
    public static User validUser() {
        return newUserRequest();
    }

    public static User missingAllInformation() {
        return new UserBuilder()
                .password(StringUtils.EMPTY)
                .lastName(StringUtils.EMPTY)
                .firstName(StringUtils.EMPTY)
                .email(StringUtils.EMPTY)
                .username(StringUtils.EMPTY)
                .build();
    }

    private static User newUserRequest() {
        return new UserBuilder()
                .password(faker.internet().password(8,20))
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .build();
    }

    private static User newUserWithInvalidEmail() {
        return new UserBuilder()
                .password(faker.internet().password(8,20))
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .email(faker.internet().domainName())
                .username(faker.name().username())
                .build();
    }

    private static User newUserWithShortPassword() {
        return new UserBuilder()
                .password(faker.internet().password(1,2))
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .build();
    }
}
