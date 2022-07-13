package by.orlov.test.task.Test_Task.service;

import by.orlov.test.task.Test_Task.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduleService {
    static final String URL_COINS_JSON = "https://api.coinlore.net/api/ticker/?id=90";
    static final String URL_COINS_JSON2 = "https://api.coinlore.net/api/ticker/?id=80";
    static final String URL_COINS_JSON3 = "https://api.coinlore.net/api/ticker/?id=48543";
    @Autowired
    private PriceService priceService;

    @Scheduled(fixedRate = 60000)
    public void updateBySchedule() {
        RestTemplate restTemplate = new RestTemplate();
        Price[] arrayCoins = restTemplate.getForObject(URL_COINS_JSON, Price[].class);
        Price[] arrayCoins2 = restTemplate.getForObject(URL_COINS_JSON2, Price[].class);
        Price[] arrayCoins3 = restTemplate.getForObject(URL_COINS_JSON3, Price[].class);
        if (arrayCoins != null) {
            for (Price c :
                    arrayCoins) {
                priceService.updatePrice(1, c.getPrice_usd());
            }
        }
        if (arrayCoins2 != null) {
            for (Price c :
                    arrayCoins2) {
                priceService.updatePrice(2, c.getPrice_usd());
            }
        }
        if (arrayCoins3 != null) {
                for (Price c :
                        arrayCoins3) {
                    priceService.updatePrice(3, c.getPrice_usd());}
        }
    }
}