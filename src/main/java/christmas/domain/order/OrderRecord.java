package christmas.domain.order;

public record OrderRecord(String menuName, Integer count) {

    private static final String SPACE = " ";
    private static final String NUMBER = "개";

    @Override
    public String toString() {
        return menuName + SPACE + count + NUMBER;
    }
}
