package christmas.repository;

import christmas.repository.menu.Appetizer;
import christmas.repository.menu.Beverage;
import christmas.repository.menu.Desert;
import christmas.repository.menu.MainDish;

import java.util.Map;

public class MenuInitializer {

    public static void init(Map<String, Long> menuRepository) {
        initAppetizer(menuRepository);
        initMainDish(menuRepository);
        initDesert(menuRepository);
        initBeverage(menuRepository);
    }

    private static void initAppetizer(Map<String, Long> menuRepository) {
        for (Appetizer appetizer : Appetizer.values()) {
            String name = appetizer.getName();
            Long price = appetizer.getPrice();
            menuRepository.put(name, price);
        }
    }

    private static void initMainDish(Map<String, Long> menuRepository) {
        for (MainDish mainDish : MainDish.values()) {
            String name = mainDish.getName();
            Long price = mainDish.getPrice();
            menuRepository.put(name, price);
        }
    }

    private static void initDesert(Map<String, Long> menuRepository) {
        for (Desert desert : Desert.values()) {
            String name = desert.getName();
            Long price = desert.getPrice();
            menuRepository.put(name, price);
        }
    }

    private static void initBeverage(Map<String, Long> menuRepository) {
        for (Beverage beverage : Beverage.values()) {
            String name = beverage.getName();
            Long price = beverage.getPrice();
            menuRepository.put(name, price);
        }
    }
}
