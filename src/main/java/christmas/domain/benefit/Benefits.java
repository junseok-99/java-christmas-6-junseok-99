package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.List;

public class Benefits extends Benefit {

    private List<String> presentationHistoryList;

    public Benefits() {
        this.presentationHistoryList = new ArrayList<>();
    }

    public String getPresentationHistoryNames() {
        if (presentationHistoryList.isEmpty()) {
            return NONE_BENEFIT;
        }
        return String.join(LINE_BREAKING, presentationHistoryList);
    }

    public void addPresentationHistory(String presentationHistory) {
        presentationHistoryList.add(presentationHistory);
    }
}
