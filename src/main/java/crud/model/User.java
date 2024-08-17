package crud.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Введите имя")
    @Size(min = 2, max = 30, message = "Имя должно быть длинной от 2 до 30 символов")
    @Column
    private String name;

    @NotEmpty(message = "Введите фамилию")
    @Size(min = 2, max = 30, message = "Фамилия должно быть длинной от 2 до 30 символов")
    @Column
    private String surname;

    @Min(value = 1, message = "Возраст должен быть больше чем 0")
    @Column
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age);
    }
}
