public class Main {
    public static void main(String[] args) {

        DataFileWriter writer = new DataFileWriter();
        DataFileReader reader = new DataFileReader();

        writer.writeData("data.txt", 100);

        reader.readData("data.txt");

        System.out.println("Data from file:");
        reader.printData();

        System.out.println("Total rows: "
                + reader.getRowCount());
    }
    if (reader.getRowCount() != 100) {
        System.out.println("Row count mismatch!");
    }
}
