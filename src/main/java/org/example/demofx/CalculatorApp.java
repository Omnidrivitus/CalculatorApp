package org.example.demofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        Label label = new Label("Result: ");

        Button add = new javafx.scene.control.Button("+");
        Button subtract = new javafx.scene.control.Button("-");
        Button multiply = new javafx.scene.control.Button("*");
        Button divide = new javafx.scene.control.Button("/");


        add.setOnAction(e-> calculate(textField, textField2, label, "+") );
        subtract.setOnAction(e-> calculate(textField, textField2, label, "-"));
        multiply.setOnAction(e-> calculate(textField, textField2, label, "*") );
        divide.setOnAction(e-> calculate(textField, textField2, label, "/") );


        HBox input = new HBox(10, new Label("num1"), textField, new Label("num2"),textField2);
        HBox button = new HBox(10, add, subtract, multiply, divide);


        VBox root = new VBox(15,input,button,label);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 700, 600);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(TextField textField, TextField textField2, Label label, String Operation) {
        try {
            double num1 = Double.parseDouble(textField.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result;

            switch (Operation){
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        label.setText("Error: Undefined Operand");
                    }
                        result = num1 / num2;
                }
                default -> throw new IllegalArgumentException("Illegal Operation");
            }

            label.setText("Result: " + result);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        launch();
    }
}
