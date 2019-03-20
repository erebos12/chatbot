package de.bot;

import java.util.Scanner;

public class ChatBotCommand {

    public static void main(String[] args) {
        ChatBot bot = new ChatBot();
        Scanner scanner = new Scanner(System.in);
        String your_msg = "";
        while (!your_msg.equalsIgnoreCase("bye")) {
            System.out.print("you: ");
            your_msg = scanner.nextLine();
            String response = bot.getReply(your_msg);
            System.out.println("bot: " + response);
        }
    }
}
