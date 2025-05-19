//package com.wiser.figures.TestingPatterns.Flyweight;
//
//import java.util.*;
//
//public class BookStoreFLYWEIGHT {
//    public static final int BOOK_TYPES = 2;
//    private static final int BOOKS_TO_INSERT = 10_000_000;
//    private static final String[] types = {"Fiction", "Science"};
//    private static final String[] distributors = {"Penguin", "HarperCollins"};
//    private static final String[] otherDataSamples = {"Huge data string 1", "Huge data string 2"};
//
//    public static void main(String[] args){
//        Store store = new Store();
//        for (int i = 0; i < BOOKS_TO_INSERT; i++) {
//            String name = getRandomName();
//            double price = getRandomPrice();
//            String type = getRandomType();
//            String distributor = getRandomDistributor();
//            String otherData = getRandomOtherData();
//
//            BookType bookType = BookTypeFactory.getBookType(type, distributor, otherData);
//            store.storeBook(name, price, bookType);
//        }
//
//        Runtime runtime = Runtime.getRuntime();
//        runtime.gc(); // Suggest garbage collection to get a cleaner reading
//
//        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
//        System.out.println("Used memory in MB: " + usedMemory / (1024 * 1024));
//
//        System.out.println("Finished inserting books.");
////        store.displayBooks();
//    }
//
//
//    private static String getRandomName() {
//        return "Book_" + new Random().nextInt(1000);
//    }
//
//    private static double getRandomPrice() {
//        return 10 + (100 - 10) * new Random().nextDouble();
//    }
//
//    private static String getRandomType() {
//        return types[new Random().nextInt(types.length)];
//    }
//
//    private static String getRandomDistributor() {
//        return distributors[new Random().nextInt(distributors.length)];
//    }
//
//    private static String getRandomOtherData() {
//        return otherDataSamples[new Random().nextInt(otherDataSamples.length)];
//    }
//}
//
//class Book {
//    private final String name;
//    private final double price;
//    private final BookType bookType;
//
//    Book(String name, double price, BookType bookType) {
//        this.name = name;
//        this.price = price;
//        this.bookType = bookType;
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "name='" + name + '\'' +
//                ", price=" + price +
//                bookType.toString() +
//                '}';
//    }
//}
//
//class BookType{
//    private final String type;
//    private final String distributor;
//    private final String otherData;
//
//    BookType(String type, String distributor, String otherData) {
//        this.type = type;
//        this.distributor = distributor;
//        this.otherData = otherData;
//    }
//
//    @Override
//    public String toString() {
//        return "BookType{" +
//                "type='" + type + '\'' +
//                ", distributor='" + distributor + '\'' +
//                ", otherData='" + otherData + '\'' +
//                '}';
//    }
//}
//
//class BookTypeFactory {
//    private static final Map<String, BookType> bookTypes = new HashMap<>();
//
//    public static BookType getBookType(String type, String distributor, String otherData) {
//        BookType result = bookTypes.get(type);
//        if (result == null) {
//            result = new BookType(type, distributor, otherData);
//            bookTypes.put(type, result);
//        }
//        return bookTypes.get(type);
//    }
//}
//
//class Store {
//    private final List<Book> books = new ArrayList<>();
//
//    public void storeBook(String name, double price, BookType booktype) {
//        books.add(new Book(name, price, booktype));
//    }
//
//    public void displayBooks() {
//        for (Book book : books) {
//            System.out.println(book);
//        }
//    }
//}
