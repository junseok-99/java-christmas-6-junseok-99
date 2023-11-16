package christmas.domain.dayofvisit;

public class DayOfVisit {

    private Integer day;

    public DayOfVisit(Integer day) {
        this.day = day;
    }

    public Integer getDay() {
        return day;
    }

    @Override
    public String toString() {
        return Integer.toString(day);
    }
}
