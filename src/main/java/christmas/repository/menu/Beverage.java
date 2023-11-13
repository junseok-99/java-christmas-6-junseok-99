package christmas.repository.menu;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Beverage {

    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final Integer price;

    private Beverage(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static boolean contains(String menuName) {
        Set<String> beverageSet = Stream.of(Beverage.values())
                .map(Beverage::getName)
                .collect(Collectors.toSet());
        return beverageSet.contains(menuName);
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
