package by.orlov.test.task.Test_Task.repository;

import by.orlov.test.task.Test_Task.entity.CoinsAll;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoinsRepository extends JpaRepository<CoinsAll, Integer> {
}
