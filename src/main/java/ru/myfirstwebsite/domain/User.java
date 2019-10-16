package ru.myfirstwebsite.domain;

public class User {

    private Long id;
    private String userName;
    private String email;
    private String login;
    private String pass;

    public User() {
    }

    public User(Long id, String userName, String email, String login, String pass) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.login = login;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
