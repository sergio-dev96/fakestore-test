package builder;

import model.User;

public class UserBuilder {
    private String password;
    private String lastName;
    private String firstName;
    private String email;
    private String username;

    public UserBuilder password(String password){
        this.password = password;
        return this;
    }

    public UserBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public UserBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public UserBuilder email(String email){
        this.email = email;
        return this;
    }

    public UserBuilder username(String username){
        this.username = username;
        return this;
    }

    public User build(){
        return new User(password, lastName, firstName, email, username);
    }
}
