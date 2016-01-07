package app.entity;

import java.util.Objects;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity(immutable = true)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final Integer id;

    public final String name;

    public final Integer age;

    //id を受け取るコンストラクタ。
    //これが無いとDomaちゃんに怒られる。
    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s: %s(%s)", Objects.toString(id, "*"), name,
                age);
    }
}
