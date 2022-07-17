package by.orlov.test.task.Test_Task.repository;

import by.orlov.test.task.Test_Task.entity.CoinsInformation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoinsRepository extends JpaRepository<CoinsInformation, Integer> {
}
