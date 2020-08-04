import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Scanner;


public class javaCalculator {

    String displayedNumber = "", operator = "", btnText = "", resultString = "";
    double num1 = 0, num2 = 0, result = 0;

    JPanel JavaCalculator;
    JTextField calculatorDisplay;

    JButton Btn0, Btn1, Btn2, Btn3, Btn4, Btn5, Btn6, Btn7, Btn8, Btn9, BtnPoint, BtnEqual;
    JButton btnDel, BtnAC;
    JButton BtnAdd, BtnSub, BtnDivide, BtnMultiply;

    private void numberBtnFunction(ActionEvent e) {
        btnText = calculatorDisplay.getText() + e.getActionCommand(); ;
        calculatorDisplay.setText(btnText);
    }
    public void operationBtn(ActionEvent e){
        displayedNumber = calculatorDisplay.getText();
        operator = e.getActionCommand();
        if (!displayedNumber.contains(operator)) {
            if ((displayedNumber.contains("+") || displayedNumber.contains("-") || displayedNumber.contains("*") || displayedNumber.contains("/")) && !displayedNumber.contains(operator)){
                if (Character.isDigit(displayedNumber.charAt(displayedNumber.length() - 1))) {
                    displayedNumber = calculate();
                } else {
                    displayedNumber = displayedNumber.substring(0, displayedNumber.length()-3);
                }
            }
            calculatorDisplay.setText(displayedNumber + " " + operator + " ");
        } else {
            resultString = calculate();
            calculatorDisplay.setText(resultString + " " + operator + " ");
        }
    }
    private void pointBtnFunction(ActionEvent e){
        if (calculatorDisplay.getText().contains(".")) {
            return;
        } else {
            numberBtnFunction(e);
        }
    }

    public String calculate(){
        displayedNumber = calculatorDisplay.getText();
        Scanner myScanner = new Scanner(displayedNumber).useLocale(Locale.ENGLISH);
        Double num1 = myScanner.nextDouble();
        String operator = myScanner.next();
        Double num2 = myScanner.nextDouble();
        myScanner.close();

        if (operator.equals("+")) {
            result = num1 + num2;
            resultString = checkResult(result);
        } else if (operator.equals("-")) {
            result = num1 - num2;
            resultString = checkResult(result);
        } else if (operator.equals("*")) {
            result = num1 * num2;
            resultString = checkResult(result);
        } else if (operator.equals("/")) {
            result = num1 / num2;
            resultString = checkResult(result);
        }
        return resultString;
    }
    private void equal(){
        resultString = calculate();
        calculatorDisplay.setText(resultString);
    }
    public String checkResult(double result) {
        String resultString = Double.toString(result);
        if (resultString.contains(".0")) {
            int resultInt = (int) result;
            resultString = Integer.toString(resultInt);
        }
        return resultString;
    }

    public void delBtn () {
        displayedNumber = calculatorDisplay.getText();
        int lastChar = displayedNumber.lastIndexOf("");
        calculatorDisplay.setText(displayedNumber.substring(0, lastChar - 1));
    }
    public void checkOperator(ActionEvent e){
        operator = e.getActionCommand();
        displayedNumber = calculatorDisplay.getText().substring(0, displayedNumber.indexOf(" ") - 1);
        if (!displayedNumber.equals(operator)){
            calculatorDisplay.setText(displayedNumber + " " + operator);
        }
    }

    public javaCalculator() {

        Btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });
        Btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBtnFunction(e);
            }
        });

        BtnPoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pointBtnFunction(e);
            }
        });

        BtnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               equal();
            }
        });
        BtnAC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculatorDisplay.setText("");
            }
        });
        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delBtn();
            }
        });

        BtnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operationBtn(e);
            }
        });
        BtnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operationBtn(e);
            }
        });
        BtnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operationBtn(e);
            }
        });
        BtnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operationBtn(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("javaCalculator");
        frame.setContentPane(new javaCalculator().JavaCalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
