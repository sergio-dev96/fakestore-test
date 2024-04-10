package builder;

import model.UserLogin;

public class UserLoginBuilder {
    private String password;
    private String username;

    public UserLoginBuilder password(String password){
        this.password = password;
        return this;
    }

    public UserLoginBuilder username(String username){
        this.username = username;
        return this;
    }

    public UserLogin build(){
        return new UserLogin(password, username);
    }
}
