
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DataFileReader {

    private final ArrayList<double[]> data = new ArrayList<>();

    public void readData(String filename) {
        data.clear();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.trim().split("\\s+");

                if (parts.length != 6) {
                    System.out.println("Skipping invalid row.");
                    continue;
                }

                try {
                    double[] row = new double[6];

                    for (int i = 0; i < 4; i++) {
                        row[i] = Integer.parseInt(parts[i]);
                    }

                    row[4] = Double.parseDouble(parts[4]);
                    row[5] = Double.parseDouble(parts[5]);

                    data.add(row);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number: "
                            + e.getMessage());
                }
            }

            System.out.println("Read " + data.size() + " rows.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);

        } catch (IOException e) {
            System.out.println("Reading error: " + e.getMessage());
        }
    }

    public void printData() {
        for (double[] row : data) {
            System.out.printf(java.util.Locale.US,
                    "%d %d %d %d %.2f %.3f%n",
                    (int) row[0], (int) row[1],
                    (int) row[2], (int) row[3],
                    row[4], row[5]);
        }
    }

    public int getRowCount() {
        return data.size();
    }
}
