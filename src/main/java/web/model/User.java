package web.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name")
    @Pattern(regexp = "[A-Za-z]{2,15}", message = "Uncorrect name")
    private String name;

    @Column(name = "surname")
    @Pattern(regexp = "[A-Za-z]{2,15}", message = "Uncorrect surname")
    private String surname;

    @Column(name = "age")
    @Min(value = 0, message = "Age >= 0")
    @Max(value = 127, message = "Age < 128")
    private byte age;

    @Column(name = "email")
    @Pattern(regexp = "[A-Za-z]{2,15}"+"@"+"[A-Za-z]{2,15}", message = "Uncorrect email")
    private String email;

    public User() {
    }

    public User(String name, String surname, byte age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}