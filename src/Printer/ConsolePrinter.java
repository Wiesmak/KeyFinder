package Printer;

import java.util.List;

public class ConsolePrinter implements Printer {
    @Override
    public void print(List<String> keys) {
        keys.forEach(System.out::println);
    }
}
