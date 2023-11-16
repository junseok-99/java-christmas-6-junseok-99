package christmas.repository.menu;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Desert {

    CHOCOLATE_CAKE("초코케이크", 15_000L),
    ICE_CREAM("아이스크림", 5_000L);

    private final String name;
    private final Long price;

    private Desert(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public static boolean contains(String menuName) {
        Set<String> desertSet = Stream.of(Desert.values())
                .map(Desert::getName)
                .collect(Collectors.toSet());
        return desertSet.contains(menuName);
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
