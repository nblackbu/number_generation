package org.example;

import com.example.numbergenerator.service.GeneratorNumberService;
import com.example.numbergenerator.service.NumberService;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class AppTest {

    GeneratorNumberService carNumberListGeneratorService = new GeneratorNumberService();
    List<String> ordinalList = carNumberListGeneratorService.returnAutoMobileNumberInOrder();
    List<String> randomList = carNumberListGeneratorService.returnAutoMobileNumberRandom();

    Set<String> setOrdinal = new HashSet(ordinalList);
    Set<String> setRandom = new HashSet(randomList);
    NumberService numberService = new NumberService(carNumberListGeneratorService.returnAutoMobileNumberRandom(),carNumberListGeneratorService.returnAutoMobileNumberInOrder());

    @Test
    public void orderCheck () {
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AA 116 RUS"));
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A001AA 116 RUS"));
    }

    @Test
    public void sizeAndRepeatCheck () {
        Assert.assertThat(ordinalList, hasSize(1728000));
        Assert.assertThat(randomList, hasSize(1728000));

        //проверка при помощи set на повтор элементов в списке
        Assert.assertThat(setOrdinal, hasSize(1728000));
        Assert.assertThat(setRandom, hasSize(1728000));
    }

    @Test
    public void boundaryTest () {
        numberService.setCountInOrder(1727999);
        System.out.println(numberService.getNextCarNumberInOrder());

        //проверка на исчерпание списка.
        //После исчерпания, счетчик обнуляется и значения выдаются начинаются с начала списка
        numberService.setCountInOrder(1728000);
        System.out.println(numberService.getNextCarNumberInOrder());
        System.out.println(numberService.getNextCarNumberInOrder());
        System.out.println(numberService.getNextCarNumberInOrder());
    }
}
