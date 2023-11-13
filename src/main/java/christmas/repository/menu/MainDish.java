package christmas.repository.menu;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MainDish {

    T_BON_STEAK("티본스테이크", 55_000L),
    BARBECUE_RIBS("바비큐립", 54_000L),
    SEAFOOD_PASTA("해산물파스타", 35_000L),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000L);

    private final String name;
    private final Long price;

    private MainDish(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public static boolean contains(String menuName) {
        Set<String> mainDishSet = Stream.of(MainDish.values())
                .map(MainDish::getName)
                .collect(Collectors.toSet());
        return mainDishSet.contains(menuName);
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
