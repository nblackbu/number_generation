package org.example;

import com.example.numbergenerator.service.GeneratorNumberService;
import com.example.numbergenerator.service.NumberService;
import org.junit.Test;

import java.util.List;

public class AppTest {
    @Test
    public void contextLoads() {

        GeneratorNumberService carNumberListGeneratorService = new GeneratorNumberService();
        List<String> s = carNumberListGeneratorService.returnAutoMobileNumberInOrder();
        List<String> r = carNumberListGeneratorService.returnAutoMobileNumberRandom();

        NumberService numberService = new NumberService(carNumberListGeneratorService.returnAutoMobileNumberRandom(),carNumberListGeneratorService.returnAutoMobileNumberInOrder());

        int size = carNumberListGeneratorService.returnAutoMobileNumberInOrder().size() + 1;

        for (int i = 0; i < size; i++) {
            System.out.println(numberService.getNextCarNumberRandom());
        }

        for (int i = 0; i < size; i++) {
            System.out.println(numberService.getNextCarNumberInOrder());
        }
    }
}
