package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String breed;
    private int age;
    private String note;

    public Cat() {
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
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(id, cat.id) && Objects.equals(nickname, cat.nickname) && Objects.equals(breed, cat.breed) && Objects.equals(note, cat.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, breed, age, note);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", note='" + note + '\'' +
                '}';
    }
}
