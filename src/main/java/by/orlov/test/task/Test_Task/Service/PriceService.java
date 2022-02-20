package by.orlov.test.task.Test_Task.Service;
import by.orlov.test.task.Test_Task.Entity.Price;
import by.orlov.test.task.Test_Task.Repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public void updatePrice (int symbolIdFromJ, Double priceFromJ){
        Price price = priceRepository.findById(symbolIdFromJ).get();
        price.setPrice_usd(priceFromJ);
        priceRepository.save(price);
    }
}
