package spring_demo_annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

@Component
public class DatabaseFortuneService implements FortuneServices {

    private final String filename = "src\\main\\java\\spring_demo_annotations\\fortunes.txt";
    private final String[] randomQuotes = readLines();

    private int countLines() {
        try (FileReader fileReader = new FileReader(filename); Scanner sc = new Scanner(fileReader)) {
            int counter = 0;
            while (sc.hasNextLine()) {
                sc.nextLine();
                ++counter;
            }
            return counter;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @PostConstruct
    private String[] readLines() {
        System.out.println(" \n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> >>>>>>>>>>>>>> >>>>>>>>>> >>>>>>>>>> >>>>>>>>>>> >>>>>>>>>>> >>>>>>>>>>>\n");
        try (FileReader fileReader = new FileReader(filename); Scanner sc = new Scanner(fileReader)) {
            int size = countLines();
            String[] lines = new String[size];

            for (int i = 0; i < size; i++) {
                lines[i] = sc.nextLine();
            }
            return lines;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String getFortune() {
        Random rnd = new Random();
        int index = rnd.nextInt(randomQuotes.length);
        return randomQuotes[index];
    }
}
