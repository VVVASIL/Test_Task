package by.orlov.test.task.Test_Task.controller;

import by.orlov.test.task.Test_Task.entity.CoinsAll;
import by.orlov.test.task.Test_Task.entity.Person;
import by.orlov.test.task.Test_Task.entity.Price;
import by.orlov.test.task.Test_Task.repository.CoinsRepository;
import by.orlov.test.task.Test_Task.repository.PriceRepository;
import by.orlov.test.task.Test_Task.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FirstController {
    @Autowired
    private CoinsRepository coinsRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String mainPage(){
        return "main-page";
    }
    @GetMapping ("/info")
    public String showAllCoins(Model model){
        List<CoinsAll> coinsAllList = coinsRepository.findAll();
        model.addAttribute("coinsInfo", coinsAllList);
        return "show-info";
    }
    @GetMapping("/price")
    public String pricePage(){
        return "show-price";
    }
    @GetMapping("/price/90")
    public String price90Page(Model model){
        Price price = priceRepository.findById(1).get();
        Double d = price.getPrice_usd();
        model.addAttribute("price90show", d);
        return "price90";
    }
    @GetMapping("/price/80")
    public String price80Page(Model model){
        Price price = priceRepository.findById(2).get();
        Double d = price.getPrice_usd();
        model.addAttribute("price80show", d);
        return "price80";
    }
    @GetMapping("/price/48543")
    public String price48543Page(Model model){
        Price price = priceRepository.findById(3).get();
        Double d = price.getPrice_usd();
        model.addAttribute("price48543show", d);
        return "price48543";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new Person());
        return "register_page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute Person person, Model model){
        System.out.println("register request: " + person);
        Person registeredPerson = personService.registerUser(person.getId(),
                person.getLogin());
        model.addAttribute("preg", registeredPerson);
        return registeredPerson == null ? "error_page" : "registration-ready";
    }
    @GetMapping("/registrationReady")
    public String regReadyPage(){
        return "registration-ready";
    }
}
