package com.lab2.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Driver extends Application
{
    @Override
    public void start(Stage stage) throws IOException {
        try
        {
            ApplicationController controller = new ApplicationController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/application.fxml"));
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }


//    public static void main(String[] args)
//    {
//        Product product1 = new Product(0, "A Item", 1.99f);
//        Product product2 = new Product(1, "B Item", 2.99f);
//        Product product3 = new Product(10, "C Item", 4.99f);
//        Product product4 = new Product(3, "D Item", 0.99f);
//        Product product5 = new Product(4, "E Item", 3.99f);
//
//        List<Product> products = new ArrayList<>();
//
//        products.add(product3);
//        products.add(product5);
//        products.add(product1);
//        products.add(product2);
//        products.add(product4);
//
//        System.out.println(products);
//        SortingUtility sortingUtility = new SortingUtility();
//        products = new ArrayList<>(sortingUtility.sortProducts(products, 0));
//        System.out.println(products);
//    }
}
