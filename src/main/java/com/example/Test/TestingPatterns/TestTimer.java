package com.example.Test.TestingPatterns;

import java.io.IOException;
import java.util.Scanner;

public class TestTimer {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have 5 seconds to type something...");

        long endTime = System.currentTimeMillis() + 5000; // 5 seconds from now

        String input = "";
        while (System.currentTimeMillis() < endTime) {
            if (System.in.available() > 0) {  // Check if user typed something
                input = scanner.nextLine();
                break;
            }
            try {
                Thread.sleep(100); // Check every 100ms to reduce CPU usage
            } catch (InterruptedException e) {
                break;
            }
        }
        if (input.isEmpty()) {
            System.out.println("\nToo slow! Moving on...");
        } else {
            System.out.println("You entered: " + input);
        }
    }
}
