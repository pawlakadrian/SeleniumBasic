package Helpers;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class GetRandomNumber {
    public static int getRandomValue(List<WebElement> availableOptions) {
        Random rnd = new Random();
        int searchingNumber = rnd.nextInt(availableOptions.size());
        return searchingNumber;
    }

    public static int getRandomNumber(int maxValue) {
        Random rnd = new Random();
        int searchingNumber = rnd.nextInt(maxValue);
        return searchingNumber;
    }
}
