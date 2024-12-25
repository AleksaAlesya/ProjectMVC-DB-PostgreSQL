package by.aleksabrakor.springcourse.models;

import jakarta.validation.constraints.*;

public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @NotNull(message = "Age should not empty")
    @Min(value = 0, message = "Age should be greater than 0")
    @Max(value = 100, message = "WOW!!!")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    //Адрес должен быть в формате: Страна, Город, 6 зн.индекс
    //Беларусь, Гомель, 246005
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = " Address should be in this format: Country, City, index(6 digits)")
    private String address;

    public Person(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
