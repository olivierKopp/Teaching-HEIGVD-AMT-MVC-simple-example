package ch.heigvd.amt.mvcsimple.model;

public class Profile {
    private String username;
    private String password;
    private String mail;

    public Profile(String username, String password, String mail){
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }
}
