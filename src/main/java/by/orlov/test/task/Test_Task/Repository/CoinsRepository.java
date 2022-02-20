package by.orlov.test.task.Test_Task.Repository;

import by.orlov.test.task.Test_Task.Entity.CoinsAll;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoinsRepository extends JpaRepository<CoinsAll, Integer> {
}
