package com.example.Test.TestingPatterns.Flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//this version takes ~ 1.5 gb of ram
public class BookStore {
    public static final int BOOK_TYPES = 2;
    private static final int BOOKS_TO_INSERT = 10000_000;
    private static final String[] types = {"Fiction", "Science"};
    private static final String[] distributors = {"Penguin", "HarperCollins"};
    private static final String[] otherDataSamples = {"Huge data string 1", "Huge data string 2"};

    public static void main(String[] args){
        Store store = new Store();
        for (int i = 0; i < BOOKS_TO_INSERT; i++) {
            String name = getRandomName();
            double price = getRandomPrice();
            String type = getRandomType();
            String distributor = getRandomDistributor();
            String otherData = getRandomOtherData();

            store.storeBook(name, price, type, distributor, otherData);
        }
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Suggest garbage collection to get a cleaner reading

        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory in MB: " + usedMemory / (1024 * 1024));


        System.out.println("Finished inserting books.");
//        store.displayBooks();
    }

    private static String getRandomName() {
        return "Book_" + new Random().nextInt(1000);
    }

    private static double getRandomPrice() {
        return 10 + (100 - 10) * new Random().nextDouble();
    }

    private static String getRandomType() {
        return types[new Random().nextInt(types.length)];
    }

    private static String getRandomDistributor() {
        return distributors[new Random().nextInt(distributors.length)];
    }

    private static String getRandomOtherData() {
        return otherDataSamples[new Random().nextInt(otherDataSamples.length)];
    }
}

class Book {
    private final String name;
    private final double price;
    private final String type;
    private final String distributor;
    private final String otherData;

    Book(String name, double price, String type, String distributor, String otherData) {
        this.name = new String(name);
        this.price = price;
        this.type = new String(type);
        this.distributor = new String(distributor);
        this.otherData = new String(otherData);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", distributor='" + distributor + '\'' +
                ", otherData='" + otherData + '\'' +
                '}';
    }
}

class Store {
    private final List<Book> books = new ArrayList<>();

    public void storeBook(String name, double price, String type, String distributor, String otherData) {
        books.add(new Book(name, price, type, distributor, otherData));
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
