package by.orlov.test.task.Test_Task.service;

import by.orlov.test.task.Test_Task.entity.Person;
import by.orlov.test.task.Test_Task.repository.PersonRepository;
import by.orlov.test.task.Test_Task.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class ChangeLogService {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PersonRepository personRepository;

    private final Logger logger = Logger.getLogger(ChangeLogService.class.getName());

    @Scheduled(fixedRate = 1000)
    public void compareAfterRegistration(){
        List<Person> personList = personRepository.findAll();
        for (Person p:
                personList) {
            if ((priceRepository.findById(1).get().getPrice_usd() -
                    p.getPriceWhenRegistration())/
                    p.getPriceWhenRegistration() * 100 < -1 && p.getId() == 90 && !p.changePrice ||
                    (priceRepository.findById(1).
                    get().getPrice_usd() - p.getPriceWhenRegistration() )/
                    p.getPriceWhenRegistration() * 100 > 1 && p.getId() == 90 && !p.changePrice){
                logger.warning("Цена изменилась на 1% у пользователя: " + p.getLogin() +
                        ". Код валюты: " + p.getId() +
                        ". Процент изменения цены: " +
                        (priceRepository.findById(1).get().getPrice_usd() -
                        p.getPriceWhenRegistration() )/
                        p.getPriceWhenRegistration() * 100);
                p.setChangePrice(true);
                personRepository.save(p);
            }else if ((priceRepository.findById(2).get().getPrice_usd() -
                    p.getPriceWhenRegistration())/
                    p.getPriceWhenRegistration() * 100 < -1 && p.getId() == 80 && !p.changePrice||
                    (priceRepository.findById(2).
                    get().getPrice_usd() - p.getPriceWhenRegistration() )/
                    p.getPriceWhenRegistration() * 100 > 1 && p.getId() == 80 && !p.changePrice) {
                logger.warning("Цена изменилась на 1% у пользователя: " + p.getLogin() +
                        ". Код валюты: " + p.getId() +
                        ". Процент изменения цены: " + (priceRepository.findById(2).
                        get().getPrice_usd() - p.getPriceWhenRegistration() )/
                        p.getPriceWhenRegistration() * 100);
                p.setChangePrice(true);
                personRepository.save(p);
            }else if ((priceRepository.findById(3).get().getPrice_usd() -
                    p.getPriceWhenRegistration())/
                    p.getPriceWhenRegistration() * 100 < -1 && p.getId() == 48543 && !p.isChangePrice()||
                    (priceRepository.findById(3).
                    get().getPrice_usd() - p.getPriceWhenRegistration() )/
                    p.getPriceWhenRegistration() * 100 > 1 && p.getId() == 48543 && !p.isChangePrice()) {
                logger.warning("Цена изменилась на 1% у пользователя: " + p.getLogin() +
                        ". Код валюты: " + p.getId() +
                        ". Процент изменения цены: " + (priceRepository.findById(3).
                        get().getPrice_usd() - p.getPriceWhenRegistration() )/
                        p.getPriceWhenRegistration() * 100);
                p.setChangePrice(true);
                personRepository.save(p);
            }
        }
    }
}
