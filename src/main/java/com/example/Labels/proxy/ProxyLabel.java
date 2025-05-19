package com.example.Labels.proxy;

import com.example.Labels.labels.Label;
import com.example.Labels.labels.SimpleLabel;

import java.util.Scanner;

public class ProxyLabel implements Label {
    private SimpleLabel realLabel = null;
    private int requestCount = 0;
    private final int timeoutRequests;

    public ProxyLabel(int timeoutRequests) {
        this.timeoutRequests = timeoutRequests;
    }

    @Override
    public String getText() {

        if (realLabel == null) {
            System.out.println("please enter label text:");
            try (Scanner scanner = new Scanner(System.in)) {
                String text = scanner.nextLine();
                realLabel = new SimpleLabel(text);
            }
        }


        else if (++requestCount >= timeoutRequests) {
            System.out.println("timeout reached. current text: " + realLabel.getText());
            System.out.println("do you want to change the text? (y/n)");

            try (Scanner scanner = new Scanner(System.in)) {
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("y") || response.equals("yes")) {
                    System.out.println("enter new text:");
                    String newText = scanner.nextLine();
                    realLabel = new SimpleLabel(newText);
                }
            }
            requestCount = 0;
        }

        return realLabel.getText();
    }
}
