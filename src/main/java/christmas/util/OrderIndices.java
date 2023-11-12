package christmas.util;

public enum OrderIndices {
    MENU(0),
    COUNT(1);

    private final Integer index;

    private OrderIndices(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }
}
