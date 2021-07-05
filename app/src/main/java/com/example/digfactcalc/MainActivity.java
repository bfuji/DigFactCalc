package com.example.digfactcalc;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.calclogic.Calc;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView output;
    String operator, valueOne, valueTwo;
    Double numberOne, numberTwo;
    boolean decimal;
    Calc calc; //Calculation from library with dependencies in gradle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = new Calc();
        output = findViewById(R.id.output);
        input = findViewById(R.id.displayEditText);
        decimal = false;


    }


    public void zeroBTNPush(View view) {
        input.setText(input.getText() + "0");
    }

    public void oneBTNPush(View view) {
        input.setText(input.getText() + "1");
    }

    public void twoBTNPush(View view) {
        input.setText(input.getText() + "2");
    }

    public void threeBTNPush(View view) {
        input.setText(input.getText() + "3");
        ;
    }

    public void fourBTNPush(View view) {
        input.setText(input.getText() + "4");
    }

    public void fiveBTNPush(View view) {
        input.setText(input.getText() + "5");
    }

    public void sixBTNPush(View view) {
        input.setText(input.getText() + "6");
    }

    public void sevenBTNPush(View view) {
        input.setText(input.getText() + "7");
        ;
    }

    public void eightBTNPush(View view) {
        input.setText(input.getText() + "8");
        ;
    }

    public void nineBTNPush(View view) {
        input.setText(input.getText() + "9");
    }

    public void multiplyBTNPush(View view) {
        operator = "*";
        valueOne = input.getText().toString();
        input.setText(null);
        decimal = false;
    }

    public void divideBTNPush(View view) {
        operator = "/";
        valueOne = input.getText().toString();
        input.setText(null);
        decimal = false;
    }

    public void subtractBTNPush(View view) {
        operator = "-";
        valueOne = input.getText().toString();
        input.setText(null);
        decimal = false;
    }

    public void addBTNPush(View view) {
        operator = "+";
        valueOne = input.getText().toString();
        input.setText(null);
        decimal = false;
    }

    public void clearBTNPush(View view) {

        input.setText(null);
        output.setText(null);
        valueOne = null;
        valueTwo = null;
        operator = null;
        decimal = false;
    }

    public void decimalBTNPush(View view) {
        if (!decimal) {
            if (input.getText().equals("")) {

                input.setText("0.");
            } else {

                input.setText(input.getText() + ".");
            }

            decimal = true;
        }
    }

    public void trigSinBTNPush(View view) {
        operator = "sin";
        valueOne = input.getText().toString();
        input.setText(null);
        decimal = false;
    }

    public void trigCosBTNPush(View view) {
        operator = "cos";
        valueOne = input.getText().toString();
        input.setText(null);
        decimal = false;
    }

    public void trigTanBTNPush(View view) {
        operator = "tan";
        valueOne = input.getText().toString();
        input.setText(null);
        decimal = false;
    }
    public void backspaceBTNPush (View view){
        if (input.getText().equals("")) {
            input.setText(null);
        } else {
            int inputLength = input.getText().length();
            String inputString = input.getText().toString();
            if (inputString.charAt(inputLength - 1) == '.') {
                decimal = false;
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));

            } else {
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            }
        }
    }

    public void equalBTNPush(View view) {
        if (operator == null) {
            output.setText("Na");
        } else if (input.getText().equals("")) {
            output.setText("Na");
        } else if ((operator.equals("+") || operator.equals("-") || operator.equals("*")
                || operator.equals("/") || operator.equals("sin") || operator.equals("cos")
                ||operator.equals("tan"))
                && valueOne.equals("")) {
            output.setText("Na");
        } else if  ((operator.equals("sin") || operator.equals("cos")
                ||operator.equals("tan"))
                && input.equals("")) {
            output.setText("Na");
        }
        else {
            switch (operator) {
                default:
                    break;
                case "sin":
                    output.setText(calc.sine(Double.parseDouble(valueOne)));
                    //This along with other Trig calculations use the Android Library.
                    operator = null;
                    break;
                case "cos":
                    output.setText(calc.cos(Double.parseDouble(valueOne)));
                    operator = null;
                    break;
                case "tan":
                    output.setText(calc.tan(Double.parseDouble(valueOne)));
                    operator = null;
                    break;
                case "+":
                    //This case and other forms of Arithmetic go into the library.
                    valueTwo = input.getText().toString();
                    numberOne = Double.parseDouble(valueOne);
                    numberTwo = Double.parseDouble(valueTwo);
                    output.setText(calc.add(numberOne,
                            numberTwo));
                    operator = null;
                    break;
                case "-":
                    valueTwo = input.getText().toString();
                    numberOne = Double.parseDouble(valueOne);
                    numberTwo = Double.parseDouble(valueTwo);
                    output.setText(calc.subtract(numberOne,numberTwo));
                    operator = null;
                    break;
                case "*":
                    valueTwo = input.getText().toString();
                    numberOne = Double.parseDouble(valueOne);
                    numberTwo = Double.parseDouble(valueTwo);
                    output.setText(calc.multiply(numberOne,numberTwo));
                    operator = null;
                    break;
                case "/":
                    valueTwo = input.getText().toString();
                    numberOne = Double.parseDouble(valueOne);
                    numberTwo = Double.parseDouble(valueTwo);
                    output.setText(calc.divide(numberOne, numberTwo));
                    operator = null;
                    break;
            }



        }
    }
}
