package by.tms.fedoseevanton.homework16;

import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

public class homework16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter limit time post (seconds) : ");
        Duration duration = Duration.ofSeconds(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter a post limit: ");
        int postLimit = scanner.nextInt();
        ChatService service = new ChatService(postLimit, duration);

        System.out.println("""
                1. Chat
                2. History
                0. Exit""");
        System.out.print("Choose task: ");
        int task = scanner.nextInt();
        switch (task) {

            case 1 -> {


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
