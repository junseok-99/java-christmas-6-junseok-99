package christmas.domain.event.presentation;

public enum BadgeCondition {
    STAR("별", 5_000L),
    TREE("트리", 10_000L),
    SANTA("산타", 20_000L);

    private String name;
    private Long price;

    private BadgeCondition(String name, Long price) {
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
