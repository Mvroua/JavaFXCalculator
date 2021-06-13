package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField result;

    String op="";
    long number1;
    long number2;

    public void Number(ActionEvent ae) {

        String num = ((Button)ae.getSource()).getText();
        result.setText(result.getText() + num);
    }

    public void Operation(ActionEvent ae) {
        String operation = ((Button)ae.getSource()).getText();

        if (!operation.equals("=")) {

            if (!op.equals("")) {
                return;
            }

            op = operation;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        }
        else {
            if (op.equals("")) {
                return;
            }
            number2 = Long.parseLong(result.getText());
            Calculate(number1, number2, op);
            op = "";
        }
    }

        public void Calculate(long n1, long n2, String op){

            switch(op){
                case "+" : result.setText(n1+n2+"");break;
                case "-" : result.setText(n1-n2+"");break;
                case "x" : result.setText(n1*n2+"");break;
                case "÷" :
                    if(n2==0){
                        result.setText("0");break;
                    }
                    result.setText(n1/n2+"");break;
            }
        }

    public void Erase(ActionEvent ae){
        String c = ((Button)ae.getSource()).getText();
        result.setText("");
        op="";
        number1=number2=0;

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }}

