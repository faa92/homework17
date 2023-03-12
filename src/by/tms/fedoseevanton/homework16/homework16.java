package by.tms.fedoseevanton.homework16;

import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

public class homework16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter limit time post (seconds) : ");
        Duration duration = Duration.ofSeconds(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter a post limit: ");
        int postLimit = scanner.nextInt();
        ChatService service = new ChatService(postLimit, duration);

        System.out.println("""
                1. Chat
                2. History
                0. Exit""");
        System.out.print("Your choice: ");
        int task = scanner.nextInt();
        switch (task) {
            case 1 -> {
                do {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Enter nickname: ");
                    User user = new User(scanner1.nextLine());
                    System.out.print("Enter message: ");
                    String message = scanner1.nextLine();
                    if (service.addNewPost(user, message)) {
                        System.out.println("New post add!" + "\n");
                    } else {
                        System.out.println("FLOOD !!!" + "\n");
                    }
                } while (true);
            }
            case 2 -> {
                System.out.println("Chat history: ");
                System.out.println(Arrays.toString(service.getPostHistory()));
            }
            case 0 -> {
                System.exit(0);
            }
        }


    }
}
