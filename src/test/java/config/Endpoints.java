package config;

public enum Endpoints {
    USERS("users"),
    REGISTER("user/register/"),
    LOGIN("auth/token/login/");

    private String path;

    Endpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
