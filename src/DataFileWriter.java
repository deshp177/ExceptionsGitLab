import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class DataFileWriter {

    public void writeData(String filename, int rows) {
        Random random = new Random();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(filename))) {

            for (int i = 0; i < rows; i++) {
                int a = random.nextInt(100);
                int b = random.nextInt(100);
                int c = random.nextInt(21) - 10;
                int d = random.nextInt(100);

                double e = random.nextDouble() * 110;
                double f = random.nextDouble() * 110;

                writer.write(String.format(Locale.US,
                        "%d %d %d %d %.2f %.3f",
                        a, b, c, d, e, f));

                writer.newLine();
            }

            System.out.println("Wrote " + rows + " rows.");

        } catch (IOException ex) {
            System.out.println("File writing error: "
                    + ex.getMessage());
        }
    }
}
