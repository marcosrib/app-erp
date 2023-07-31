package br.com.somar.app.application.domain;

public class Auth {
    private String email;

    private String password;

    public Auth(String email, String password) {
        this.email = email;
        this.password = password;
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
}
