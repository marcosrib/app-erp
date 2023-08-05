package br.com.somar.app.application.domain;

public class Auth {
    private String email;
    private String password;
    private String accessToken;
    private String refreshToken;

    public Auth() {
    }
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }


    public static Auth builder() {
        return new Auth();
    }
    public Auth email(String email) {
        this.email = email;
        return this;
    }
    public Auth password(String password) {
        this.password = password;
        return this;
    }
    public Auth accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }
    public Auth refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }
}
