package sorting;

public class Main {

    public static void main(String[] args) {

        Sorting sorting = new Sorting();
        sorting.setFiles("transport.json");
//        sorting.setFiles("src/main/resources.transport.json");

        try {
            sorting.readFile();
            sorting.writeResult();

        }
        catch (Exception e) {
            System.out.println("Error encountered");
        }
    }
}
