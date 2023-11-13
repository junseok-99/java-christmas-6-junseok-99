package christmas.repository;

import java.util.HashMap;
import java.util.Map;

public class MenuRepository {

    private static final Map<String, Integer> menuRepository = new HashMap<>();

    private MenuRepository() {

    }

    public static void initRepository() {
        MenuInitializer.init(menuRepository);
    }

    public static void print() {
        System.out.println(menuRepository);
    }
}
