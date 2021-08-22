package com.example.demo;

import com.example.demo.model.Calculator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private ListView<String> listView;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Label sumLabel;
    @FXML
    private TextField aField;
    @FXML
    private TextField bField;

    Calculator calculator = new Calculator();

    public void initialize() {
        comboBox.setItems(FXCollections.observableArrayList("+", "-", "*", "/", "%"));
        listView.setItems(FXCollections.observableArrayList("+", "-", "*", "/", "%"));
    }

    public void sayHello(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Hello from JavaFX");
        alert.setTitle("Hello alert");
        if (actionEvent.getSource().getClass() == Button.class) {
            alert.setHeaderText("from button");
        } else {
            alert.setHeaderText("from menu");
        }
        alert.show();
    }

    public void addNumbers() {
        try {
            int a = Integer.parseInt(aField.getText());
            int b = Integer.parseInt(bField.getText());
            int sum;
            switch (comboBox.getValue()) {
                case "+": sum = calculator.sum(a, b); break;
                case "-": sum = calculator.minus(a, b); break;
                case "*": sum = calculator.mult(a, b); break;
                case "/": sum = calculator.div(a, b); break;
                case "%": sum = calculator.mod(a, b); break;
                default: sum = 0;
            }

            sumLabel.setText("Sum = " + sum);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong number format " + e.getMessage().toLowerCase());
            alert.setHeaderText(null);
            alert.show();
        }
    }

}