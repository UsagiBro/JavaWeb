package entity;

/**
 * Used data transfer object
 */
public class UserBean {

    private String name;
    private String surname;
    private String password;
    private String email;
    private String passwordRepeat;
    private boolean news;
    private boolean newProducts;

    public UserBean(String name, String surname, String password, String email,
                    String passwordRepeat, boolean news, boolean newProducts) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.passwordRepeat = passwordRepeat;
        this.news = news;
        this.newProducts = newProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public boolean getNews() {
        return news;
    }

    public void setNews(boolean news) {
        this.news = news;
    }

    public boolean getNewProducts() {
        return newProducts;
    }

    public void setNewProducts(boolean newProducts) {
        this.newProducts = newProducts;
    }
}
