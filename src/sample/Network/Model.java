package sample;

public class Model {

    public static double compute(double num1, double num2, String op){
        switch (op){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                try{
                    return num1 / num2;
                } catch (ArithmeticException  e){
                    System.out.println(e.toString());
                }
            case "%":
                try{
                    return num1 % num2;
                } catch (ArithmeticException  e){
                    System.out.println(e.toString());
                }
            default:
                return 0;
        }
    }
}
