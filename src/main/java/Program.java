import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Program {
    public static void main(String[] args) throws IOException {
        Toy[] toys = new Toy[3];
        toys[0] = new Toy("1", "конструктор", 2);
        toys[1] = new Toy("2", "робот", 2);
        toys[2] = new Toy("3", "кукла", 6);

        PriorityQueue<Toy> queue = new PriorityQueue<>(Comparator.comparingInt(Toy::getFrequency));
        queue.addAll(Arrays.asList(toys));


        File file = new File("output.txt");
        FileWriter writer = new FileWriter(file);

        for (int i = 0; i < 10; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 11);
            if (randomNum <= 2) {
                writer.write(queue.poll().getId() + "\n");
            } else if (randomNum <= 4) {
                writer.write(queue.peek().getId() + "\n");
            } else {
                writer.write(toys[2].getId() + "\n");
            }
        }

        writer.close();
    }
}

