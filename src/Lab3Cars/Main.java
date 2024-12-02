package Lab3Cars;

public class Main {
    public static void main(String[] args) {

        Scheduler scheduler = new Scheduler("src/Lab3Cars/queue");
        scheduler.polling(3);
        scheduler.serving(5);


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nShutting down program...");
        }));
    }
}