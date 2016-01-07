package app.dao;

import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Script;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.jdbc.Result;

import app.DomaConfig;
import app.entity.Person;

@Dao(config = DomaConfig.class)
public interface PersonDao {

    @Select
    Optional<Person> select(Integer id);

    @Insert
    Result<Person> insert(Person entity);

    @Update
    Result<Person> update(Person entity);

    @Script
    void createTable();
}
