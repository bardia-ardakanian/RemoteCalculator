package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;

public class Controller {

    @FXML
    private TextField textField;
    private Double number1 = 0.0;
    private String operator = "";
    private boolean compute = false;

    @FXML
    public void proccessNumbers(javafx.event.ActionEvent actionEvent){
        if (compute){
            textField.setText("");
            compute = false;
        }

        String value = ((Button) actionEvent.getSource()).getText();
        textField.setText(textField.getText() + value);
    }

    @FXML
    public void proccessOperators(javafx.event.ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();

        if (!value.equals("=")){
            if (!operator.isBlank()) return;

            operator = value;
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else {
            if (operator.isBlank()) return;

            Double number2 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Model.compute(number1, number2, operator)));

            //reset
            operator = "";
            compute = true;
        }
    }
}
