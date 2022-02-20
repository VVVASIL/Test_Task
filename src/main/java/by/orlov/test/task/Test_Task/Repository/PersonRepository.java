package by.orlov.test.task.Test_Task.Repository;

import by.orlov.test.task.Test_Task.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByLoginAndId (String login, Integer id);
    Optional<Person> findFirstByLoginAndId (String login, Integer id);
}
