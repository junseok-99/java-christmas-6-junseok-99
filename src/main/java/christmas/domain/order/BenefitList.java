package christmas.domain.order;

import java.util.ArrayList;
import java.util.List;

public class BenefitList {

    private List<Long> benefitList;

    public BenefitList() {
        this.benefitList = new ArrayList<>();
    }

    public void add(Long benefit) {
        benefitList.add(benefit);
    }
}
