package org.example.demo;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        //Left node
        ListView<String> FruitsList = new ListView<>();
        ObservableList<String> Fruits = FXCollections.observableArrayList();
        Fruits.add("Apples");
        Fruits.add("Banana");
        Fruits.add("Orange");
        FruitsList.setItems(Fruits);
        //Top Node
        Label topLabel = new Label("FruitsList Apllication");
        topLabel.setPadding(new Insets(10, 10, 10, 10));
        //Bottom node
        Label bottomLabel = new Label("Recently added fruit: None");
        bottomLabel.setPadding(new Insets(10, 10, 10, 10));
        //Right node
        Label rightLabel = new Label("Total number of fruit types: "
        + FruitsList.getItems().size());
        rightLabel.setRotate(90);
        rightLabel.setPadding(new Insets(10, 10, 10, 10));
        //Center node
        TextField field = new TextField();
        Button button = new Button("Add");
        HBox centerContainer = new HBox();
        centerContainer.getChildren().addAll(field, button);
        //Setting BorderPane Regions
        borderPane.setTop(topLabel);
        borderPane.setBottom(bottomLabel);
        borderPane.setLeft(FruitsList);
        borderPane.setRight(rightLabel);
        borderPane.setCenter(centerContainer);
        //Register Event Handler
        button.setOnMouseClicked(mouseEvent ->
        {
            String fruit = field.getText();
            FruitsList.getItems().add(fruit);
            bottomLabel.setText("Recently added fruit: " + fruit);
            rightLabel.setText("Total number of fruit types: " + FruitsList.getItems().size());
            field.clear();
        });
        Scene scene = new Scene(borderPane, 1024, 620);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fruits Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
