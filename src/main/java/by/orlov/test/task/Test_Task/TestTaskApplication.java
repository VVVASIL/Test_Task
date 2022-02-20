package by.orlov.test.task.Test_Task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class TestTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestTaskApplication.class, args);
	}
}
