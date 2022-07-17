package by.orlov.test.task.Test_Task;

import by.orlov.test.task.Test_Task.controller.MainController;
import by.orlov.test.task.Test_Task.entity.CoinsInformation;
import by.orlov.test.task.Test_Task.entity.Person;
import by.orlov.test.task.Test_Task.repository.CoinsRepository;
import by.orlov.test.task.Test_Task.repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TaskApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private MainController controller;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private CoinsRepository coinsRepository;
	//  Tests view
	@Test
	void mainPageTest() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Добро пожаловать")));
	}
	@Test
	void loginPageTest() throws Exception{
		this.mockMvc.perform(get("/register"))
				.andDo(print())
				.andExpect(status().is2xxSuccessful());
	}
	// Tests DB
	@Test
	void getCoinsInformationTest(){
		CoinsInformation coinsInformation = coinsRepository.findById(2).get();
		Assertions.assertThat(coinsInformation.getId()).isEqualTo(2);
	}
	@Test
	void personCreateTest(){
		Person person = new Person(44, "kda", 43422.0);
		personRepository.save(person);
	}
	@Test
	void personPriceUpdateTest(){
		Person personPrice = personRepository.findById(6).get();
		personPrice.setPriceWhenRegistration(2333.44);
		personRepository.save(personPrice);
	}
}
