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

    // Проверка на повторы и размер списка
    @Test
    public void sizeAndRepeatCheck () {
        Assert.assertThat(ordinalList, hasSize(1728000));
        Assert.assertThat(randomList, hasSize(1728000));

        //проверка при помощи set на повтор элементов в списке
        Assert.assertThat(setOrdinal, hasSize(1728000));
        Assert.assertThat(setRandom, hasSize(1728000));
    }

    // Проверка исчерпания списка: после исчерпания, счетчик обнуляется и значения выдаются начинаются с начала списка
    @Test
    public void boundaryTest () {
        numberService.setCountInOrder(1727999);
        System.out.println(numberService.getNextCarNumberInOrder());

        numberService.setCountInOrder(1728000);
        System.out.println(numberService.getNextCarNumberInOrder());
        System.out.println(numberService.getNextCarNumberInOrder());
        System.out.println(numberService.getNextCarNumberInOrder());
    }

    // Проверка перехода между 0 и 1 в первом регистре
    @Test
    public void boundaryTest12 () {
        numberService.setCountInOrder(0);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AA 116 RUS"));
        numberService.setCountInOrder(1);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A001AA 116 RUS"));
    }

    // Проверка перехода между 99 и 100 в первом регистре
    @Test
    public void boundaryTest100 () {
        numberService.setCountInOrder(100);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A100AA 116 RUS"));
    }

    // Переход между 999 и 1000. Происходит переход к след.букве в третьем буквенном регистре (т.е по алфавиту)
    @Test
    public void boundaryTest1000 () {
        numberService.setCountInOrder(999);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A999AA 116 RUS"));
        numberService.setCountInOrder(1000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AВ 116 RUS"));
    }

    // Переход букв в третьем регистре по алфавиту
    @Test
    public void boundaryTestThirdRegister () {
        numberService.setCountInOrder(1000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AВ 116 RUS"));
        numberService.setCountInOrder(2000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AЕ 116 RUS"));
        numberService.setCountInOrder(3000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AК 116 RUS"));
        numberService.setCountInOrder(4000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AМ 116 RUS"));
        numberService.setCountInOrder(5000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AН 116 RUS"));
        numberService.setCountInOrder(6000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AО 116 RUS"));
        numberService.setCountInOrder(7000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AР 116 RUS"));
        numberService.setCountInOrder(8000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AС 116 RUS"));
        numberService.setCountInOrder(9000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AТ 116 RUS"));
        numberService.setCountInOrder(10000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AУ 116 RUS"));
        numberService.setCountInOrder(11000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AХ 116 RUS"));
    }


    // Переход букв во втором регистре по алфавиту
    @Test
    public void boundaryTestSecondRegister () {
        numberService.setCountInOrder(12000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000ВA 116 RUS"));
        numberService.setCountInOrder(24000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000ЕA 116 RUS"));
        numberService.setCountInOrder(36000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000КA 116 RUS"));
        numberService.setCountInOrder(48000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000МA 116 RUS"));
        numberService.setCountInOrder(60000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000НA 116 RUS"));
        numberService.setCountInOrder(72000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000ОA 116 RUS"));
        numberService.setCountInOrder(84000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000РA 116 RUS"));
        numberService.setCountInOrder(96000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000СA 116 RUS"));
        numberService.setCountInOrder(108000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000ТA 116 RUS"));
        numberService.setCountInOrder(120000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000УA 116 RUS"));
        numberService.setCountInOrder(132000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000ХA 116 RUS"));
    }

    // Переход букв в первом регистре по алфавиту
    @Test
    public void boundaryTestFirstRegister () {
        numberService.setCountInOrder(0);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("A000AA 116 RUS"));
        numberService.setCountInOrder(144000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("В000AA 116 RUS"));
        numberService.setCountInOrder(288000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("Е000AA 116 RUS"));
        numberService.setCountInOrder(432000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("К000AA 116 RUS"));
        numberService.setCountInOrder(576000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("М000AA 116 RUS"));
        numberService.setCountInOrder(720000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("Н000AA 116 RUS"));
        numberService.setCountInOrder(864000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("О000AA 116 RUS"));
        numberService.setCountInOrder(1008000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("Р000AA 116 RUS"));
        numberService.setCountInOrder(1152000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("С000AA 116 RUS"));
        numberService.setCountInOrder(1296000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("Т000AA 116 RUS"));
        numberService.setCountInOrder(1440000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("У000AA 116 RUS"));
        numberService.setCountInOrder(1584000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("Х000AA 116 RUS"));
    }

    // Проверка на ФР и ОР, указанного ТЗ
    @Test
    public void boundaryTestFromTZ () {
        numberService.setCountInOrder(1164399);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("С399ВA 116 RUS"));
        numberService.setCountInOrder(1164400);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("С400ВA 116 RUS"));

        numberService.setCountInOrder(1164999);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("С999ВA 116 RUS"));
        numberService.setCountInOrder(1165000);
        Assert.assertTrue(numberService.getNextCarNumberInOrder().equals("С000ВВ 116 RUS"));
    }
}
