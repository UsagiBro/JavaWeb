package entity;

import java.util.Objects;

public class User {

    private String name;

    private String surname;

    private String password;

    private String email;

    private boolean news;

    private boolean newProducts;

    public User() {
    }

    public User(String name, String surname, String password, String email, boolean news, boolean newProducts) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.newProducts = newProducts;
        this.news = news;
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

    public boolean isNews() {
        return news;
    }

    public void setNews(boolean news) {
        this.news = news;
    }

    public boolean isNewProducts() {
        return newProducts;
    }

    public void setNewProducts(boolean newProducts) {
        this.newProducts = newProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, password, email);
    }
}
