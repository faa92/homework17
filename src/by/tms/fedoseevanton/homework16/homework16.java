package by.tms.fedoseevanton.homework16;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class homework16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter limit time post (seconds) : ");
        Duration duration = Duration.ofSeconds(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter a post limit: ");
        int postLimit = scanner.nextInt();
        ChatService service = new ChatService(postLimit, duration);
        while (true) {
            System.out.println("""
                    1. Chat
                    2. History
                    0. Exit""");
            System.out.print("Your choice: ");
            int task = scanner.nextInt();
            switch (task) {
                case 1 -> {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Enter nickname: ");
                    User user = new User(scanner1.nextLine());
                    System.out.print("Enter message: ");
                    String message = scanner1.nextLine();
                    try {
                        service.addNewPost(user, message);
                        System.out.println("New post add!" + "\n");

                    } catch (LimitingNumberOfPublicationsException e) {
                        System.out.printf(
                                "Слишком частые запросы. Повторите через %s секунд\n",
                                Duration.between(Instant.now(), e.getTimeCanChat()).toSeconds());
                    }
                }
                case 2 -> {
                    System.out.println("Chat history: ");
                    for (Object o : service.getPostHistory()) {

                    }
                    System.out.println(service.getPostHistory() + "\n");
                }
                case 0 -> {
                    System.exit(0);
                }
            }
        }
    }
}
