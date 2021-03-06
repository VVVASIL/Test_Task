package by.orlov.test.task.Test_Task.repository;

import by.orlov.test.task.Test_Task.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    Optional<Price> findById(Integer integer);

}
