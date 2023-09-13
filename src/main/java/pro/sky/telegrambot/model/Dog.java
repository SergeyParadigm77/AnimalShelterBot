package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String breed;
    private int age;
    private String note;

    public Dog() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(id, dog.id) && Objects.equals(nickname, dog.nickname) && Objects.equals(breed, dog.breed) && Objects.equals(note, dog.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, breed, age, note);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", note='" + note + '\'' +
                '}';
    }
}
