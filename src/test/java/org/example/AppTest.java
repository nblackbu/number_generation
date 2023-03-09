package org.example;

import com.example.numbergenerator.service.GeneratorNumberService;
import com.example.numbergenerator.service.NumberService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;

public class AppTest {

    GeneratorNumberService carNumberListGeneratorService = new GeneratorNumberService();

    List<String> ordinalList = carNumberListGeneratorService.returnAutoMobileNumberInOrder();
    List<String> randomList = carNumberListGeneratorService.returnAutoMobileNumberRandom();

    NumberService numberService = new NumberService(carNumberListGeneratorService.returnAutoMobileNumberRandom(),carNumberListGeneratorService.returnAutoMobileNumberInOrder());


    @Test
    public void orderCheck () {

        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AA 116 RUS"));
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A001AA 116 RUS"));
    }
    @Test
    public void sizeCheck () {
        Assert.assertThat(ordinalList, hasSize(1728000));
        Assert.assertThat(randomList, hasSize(1728000));
    }

    @Test
    public void boundaryTest () {
        numberService.setCountInOrder(1727999);
        System.out.println(numberService.getNextCarNumberInOrder());
    }
}
