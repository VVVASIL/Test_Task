package by.orlov.test.task.Test_Task.service;

import by.orlov.test.task.Test_Task.entity.Person;
import by.orlov.test.task.Test_Task.repository.PersonRepository;
import by.orlov.test.task.Test_Task.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PersonRepository personRepository;

    public Person registerUser (Integer id, String login){
        if (login == null || id == null) {
            return null;
        } else {
            if (personRepository.findFirstByLoginAndId (login, id).isPresent()){
                System.out.println("duplicate account");
                return null;
            }
            Person person = new Person();
            person.setLogin(login);
            person.setId(id);
            person.setChangePrice(false);
            if (person.getId() == 90){
                person.setPriceWhenRegistration(priceRepository.findById(1).get().getPrice_usd());
                return personRepository.save(person);
            }else if (person.getId() == 80){
                person.setPriceWhenRegistration(priceRepository.findById(2).get().getPrice_usd());
                return personRepository.save(person);
            }else if (person.getId() == 48543){
                person.setPriceWhenRegistration(priceRepository.findById(3).get().getPrice_usd());
                return personRepository.save(person);
            }
            return null;
        }
    }
}
