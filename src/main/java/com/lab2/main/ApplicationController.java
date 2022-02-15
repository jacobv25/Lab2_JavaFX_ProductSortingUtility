package com.lab2.main;

import com.lab2.main.Product.Bag;
import com.lab2.main.Product.Book;
import com.lab2.main.Product.Product;
import com.lab2.main.Product.ShirtButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

//import java.awt.Label;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {


    @FXML private Button addProductButton;
    @FXML private TextField idTextField;
    @FXML private TextField nameTextField;
    @FXML private TextField priceTextField;

    private final String[] sortingAlgorithmTexts = {"Bubble Sort", "Quick Sort"};
    private final String[] productTexts = {"Book", "Button", "Bag"};
    private final Bag.Size[] bagSizeTexts = {Bag.Size.SMALL, Bag.Size.MEDIUM, Bag.Size.LARGE};
    @FXML private ChoiceBox<String> sortingChoiceBox = new ChoiceBox();
    @FXML private ChoiceBox<String> productChoiceBox = new ChoiceBox();
    @FXML private ListView<Product> productsListView;    // = new ListView<>();
    private static List<Product> productList;

    private static int id;
    private static float price;
    private static int sortingAlgorithm;
    private static int typeOfProduct;

    private SortingUtility sortingUtility;
    @FXML private AnchorPane productSidebarAnchorPane;
    @FXML private StackPane productSidebarStackPane;
    @FXML private HBox productFieldsHBox;
    @FXML private HBox labelsHBox;

    private Node tempProductField;
    private Node tempLable;
    private Node node;
    private TextField authorTextField = new TextField();
    private ColorPicker colorPicker;
//    private ChoiceBox colorPicker;

    private Label label;

    private ChoiceBox<Bag.Size> bagSizeChoiceBox;


    @FXML
    public void productChosen(ActionEvent event){

        String value = productChoiceBox.getValue();

        switch (value){
            case "Book":
                //SceneController.getInstance().setContent(ProductSidebar.BOOK);
                loadBookSidebar();
                break;
            case "Button":
                //SceneController.getInstance().setContent(ProductSidebar.BUTTON);
                loadShirtButtonSidebar();
                break;
            case "Bag":
                //SceneController.getInstance().setContent(ProductSidebar.BAG);
                loadBagSidebar();
                break;
        }
    }

    private void removeLastComponent()
    {
        labelsHBox.getChildren().remove(labelsHBox.getChildren().size()-1);
        productFieldsHBox.getChildren().remove(productFieldsHBox.getChildren().size()-1);
    }

    private void loadBookSidebar() {
        removeLastComponent();
        label.setText("Author");
        labelsHBox.getChildren().add(label);
        authorTextField = new TextField();
        productFieldsHBox.getChildren().add(authorTextField);
    }

    private void loadShirtButtonSidebar() {
        removeLastComponent();
        label.setText("Color");
        labelsHBox.getChildren().add(label);
        colorPicker = new ColorPicker();
        productFieldsHBox.getChildren().add(colorPicker);
    }

    private void loadBagSidebar() {
        removeLastComponent();
        label.setText("Size");
        labelsHBox.getChildren().add(label);
        productFieldsHBox.getChildren().add(bagSizeChoiceBox);
    }

    @FXML
    public void addProductButtonPushed(ActionEvent event) {
        try {
            int id = Integer.parseInt(idTextField.getText());
            float price = Float.parseFloat(priceTextField.getText());
            Product newProduct;

           if(productChoiceBox.getValue() == "Book") {
               //do something
               newProduct = new Book(id, nameTextField.getText(), price, authorTextField.getText());
           }
           else if (productChoiceBox.getValue() == "Button"){
               newProduct = new ShirtButton(id, nameTextField.getText(), price, colorPicker.getValue());
           }
           else if (productChoiceBox.getValue() == "Bag") {
               newProduct = new Bag(id, nameTextField.getText(), price, bagSizeChoiceBox.getValue());
           }
           else {
               throw new Exception("Bad Product Choice");
           }

           productsListView.getItems().add(newProduct);
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter integer (no decimal) value for ID and or a decimal value for price.");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void sortButtonPushed(ActionEvent event) {

        System.out.println("sort button pushed");

        String choice = sortingChoiceBox.getValue();

        System.out.println(productList);

        productList = sortingUtility.sortProducts(productsListView.getItems(), sortingAlgorithm);

        System.out.println(productList);

        productsListView.getItems().setAll(productList);
    }

    private void setSortingAlgorithm(ActionEvent event){
        if( sortingChoiceBox.getValue().equals("Bubble Sort")) {
            System.out.println("sorting using bubblesort");
            sortingAlgorithm = 0;
        }
        else { //quicksort
            System.out.println("sorting using quicksort");
            sortingAlgorithm = 1;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Initialize the algorithmChoiceBox
        sortingChoiceBox.getItems().addAll(sortingAlgorithmTexts);
        sortingChoiceBox.getSelectionModel().selectFirst();
        sortingChoiceBox.setOnAction(this::setSortingAlgorithm);
        //Initialize the productChoiceBox
        productChoiceBox.getItems().addAll(productTexts);
        productChoiceBox.getSelectionModel().selectFirst();
        productChoiceBox.setOnAction(this::productChosen);
        //Initialize bagsizechoicebox
        bagSizeChoiceBox = new ChoiceBox();
        bagSizeChoiceBox.getItems().addAll(bagSizeTexts);
        bagSizeChoiceBox.getSelectionModel().selectFirst();

        //Allow addProductButton to fire when pressing ENTER
        addProductButton.setDefaultButton(true);

        //misc set up
        productList = new ArrayList<>();
        sortingUtility = new SortingUtility();
        productSidebarAnchorPane = new AnchorPane();
        label = new Label();
        productFieldsHBox.getChildren().add(new TextField());
        labelsHBox.getChildren().add(new Label("Author"));

    }

}
