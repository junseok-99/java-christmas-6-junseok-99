package christmas.view;

import christmas.domain.order.DayOfVisit;

public class OutputView {

    public static void outputIntro() {
        System.out.println(OutputMessages.INTRO.getMessage());
    }

    public static void outputPreview(DayOfVisit dayOfVisit) {
        String previewMessage = String.format(OutputMessages.PREVIEW.getMessage(), dayOfVisit.toString());
        System.out.println(previewMessage);
    }
}
