package christmas.dto;

public class OrderDTO {

    private final String menuNmae;
    private final Integer count;

    public OrderDTO(String menuNmae, Integer count) {
        this.menuNmae = menuNmae;
        this.count = count;
    }

    public String getMenuNmae() {
        return menuNmae;
    }

    public Integer getCount() {
        return count;
    }
}
