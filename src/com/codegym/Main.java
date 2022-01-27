package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Product> readFile() {
        List<Product> products1 = new ArrayList<>();
        try {
            InputStream is = new FileInputStream("product.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            products1 = (List<Product>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return products1;
    }

    private static void writeFile(List<Product> products) {
        try {
            OutputStream os = new FileOutputStream("product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(products);
            os.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Iphone 13 pro max", "Apple", 31000000, "new"));
        products.add(new Product("2", "Iphone 13 pro", "Apple", 25000000, "new"));
        products.add(new Product("3", "Iphone 13", "Apple", 20000000, "new"));
        writeFile(products);
        List<Product> products1 = readFile();
        for (Product product : products1) {
            System.out.println(product);
        }
    }
}