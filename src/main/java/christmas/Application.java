package christmas;

import christmas.repository.MenuRepository;

public class Application {
    public static void main(String[] args) {
        MenuRepository.initRepository();
        MenuRepository.print();
    }
}
