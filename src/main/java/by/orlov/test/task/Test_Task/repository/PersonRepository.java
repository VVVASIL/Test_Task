package by.orlov.test.task.Test_Task.repository;

import by.orlov.test.task.Test_Task.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByLoginAndId (String login, Integer id);
    Optional<Person> findFirstByLoginAndId (String login, Integer id);
}
