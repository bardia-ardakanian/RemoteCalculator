package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;

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
    public void proccessOperators(javafx.event.ActionEvent actionEvent) throws IOException {
        int port = 7660;
        String value = ((Button) actionEvent.getSource()).getText();

        if (!value.equals("=")){
            if (!operator.isBlank()) return;

            operator = value;
            number1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else {
            if (operator.isBlank()) return;

            Double number2 = Double.parseDouble(textField.getText());

            //client
            Main.client.write(number1 + " " + operator + " " + number2);
            Main.server.write();
            textField.setText(Main.client.read());

            //reset
            operator = "";
            compute = true;
        }
    }
}
