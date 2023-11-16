package christmas.repository.menu;

public enum Appetizer {
    MUSHROOM_SOUP("양송이수프", 6_000L),
    TAPAS("타파스", 5_500L),
    CAESAR_SALAD("시저샐러드", 8_000L);

    private final String name;
    private final Long price;

    private Appetizer(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }
}
