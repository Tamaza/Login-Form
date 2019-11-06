
package LoginForm.model.oop;

import LoginForm.model.enums.Gender;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    
    public static final long serialVersionUID = 1L;
    public static final String path = "src/LoginForm/files/users/";
  
    public static String currentUsername;
    
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String number;
    private Gender gender;
    private Date birthdate;


    public User() {
    }

    public User(String name, String surname, String username, String password, String email, String number, Gender gender, Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.number = number;
        this.gender = gender;
        this.birthdate = birthdate;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    
    
    
    
}
