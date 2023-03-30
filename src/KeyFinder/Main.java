package KeyFinder;

import Printer.Printer;
import Printer.ConsolePrinter;
import Printer.FilePrinter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- KEY FINDER 1.0 ---");
        System.out.println("Enter a key with a missing character:");
        final Scanner scanner = new Scanner(System.in);
        final String key = scanner.nextLine();

        final CompleteKey k = new CompleteKey(key);
        if (k.checkKey()) {
            System.out.println("KeyFinder.Key is complete.");
        } else {
            final IncompleteKey ik = new IncompleteKey(key);
            if (ik.findIncompleteSegment()) {
                final AutoCompletingKey ak = new AutoCompletingKey(key);
                if (ak.findPossibleSegment()) {
                    Printer printer = null;
                    do {
                        System.out.println("Print to file? (y/N)");
                        final String answer = scanner.nextLine();
                        if (answer.equals("Y") || answer.equals("y") || answer.equals("")) {
                            System.out.println("enter file name:");
                            final String fileName = scanner.nextLine();
                            if (fileName.equals("")) throw new RuntimeException("No file name entered.");
                            printer = new FilePrinter(fileName);
                        } else if (answer.equals("N") || answer.equals("n")) {
                            printer = new ConsolePrinter();
                        } else {
                            System.out.println("Invalid answer.");
                        }
                    } while (printer == null);
                    printer.print(ak.getPossibleKeys());
                    System.out.println("Done.");
                } else {
                    System.out.println("No possible keys.");
                }
            } else {
                System.out.println("No incomplete segment.");
            }
        }

        scanner.close();
    }
}