package projetos.calculator.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private String strCount;
    private String strNumber;
    private double lastNumber,tempNumber;
    private boolean newNumber, firstNumber;
    private Operator op;

    double result;

    public Calculator() {
        strCount = "";
        strNumber = "0";
        lastNumber = 0;
        tempNumber = 0;
        newNumber = true;
        firstNumber = true;
        result = 0;
        op = Operator.none;
    }

    public boolean addNewCount(String str){
        if(str.isBlank() || str.length()<1)
            return false;
        if(newNumber){
            if(!Character.isDigit(str.charAt(0)))
                return false;
        }
        if(Character.isDigit(str.charAt(0))){
            System.out.println("Str : " + str);
            strCount += str;
            System.out.println("StrCount: " + strCount);
            newNumber = false;
        }else if(!str.equals(" = ")){
            System.out.println("Str : " + str);
            strCount += str;
            System.out.println("StrCount: " + strCount);
            newNumber = true;
        }else {
            count(strCount.split("\\s+"));
            strNumber = String.valueOf(result);
            reset();
            //alterar o valor final e dar reset!
        }
        return true;
    }

    private void count(String[] splited) {
        String aux[] = splited;
        boolean bol = false;
        do {
            aux = divMul(splited);
            if(aux.length == 0)
                return;
            if(!find(aux))
                bol = true;
        }while (!bol);
        sumSub(aux);
    }

    private boolean find(String[] aux) {

        for(String s : aux){
            System.out.println("Aux: " + s);
            if(s.equals("/") || s.equals("*")){
                return true;
            }
        }
        return false;
    }

    private void sumSub(String[] aux){
        for(int i = 0;i<aux.length; i++) {
            if (firstNumber) {
                result += converter(aux[i]);
                firstNumber = false;
            }else if(aux[i].equals("+") || aux[i].equals("-")){
                double num1;
                int index1;
                index1 = i+1;
                num1 = converter(aux[index1]);
                switch (aux[i]){
                    case "+" ->{
                        result = sum(result,num1);
                    }
                    case "-" ->{
                        result = sub(result,num1);
                    }
                }
            }
        }
    }

    private double sum(double num1, double num2){
        return num1+num2;
    }

    private double sub(double num1, double num2){
        return num1-num2;
    }

    private String[] divMul(String[] splited){
        int counter = 0;
        double count = 0;
        boolean finish = false;

        for(String s : splited){
            if(s.equals("/") || s.equals("*")){
                //System.out.println("Counter" + counter);
                double num1, num2;
                int index1, index2;
                index1 = counter-1;
                index2 = counter+1;
                //System.out.println("counter " + counter + " index1 " + index1 + " index2 " + index2);
                num1 = converter(splited[index1]);
                num2 = converter(splited[index2]);
                //System.out.println(num1 + " " + num2);
                switch (s) {
                    case "/" -> {
                        count = div(num1,num2);
                        finish = true;
                    }
                    case "*" -> {
                        count = mul(num1,num2);
                        finish = true;
                    }
                }
            }
            if(finish)
                break;
            counter++;
        }
        return newStrCount(counter, splited,count);
    }

    private String[] newStrCount(int counter, String[] splited, double count) {
        if(splited.length == 1){
            result = converter(splited[0]);
            return new String[0];
        }

        String[] aux = new String[splited.length - 2];
        int remainingElements = splited.length - ( counter + 2 );

        splited[counter-1] = String.valueOf(count);

        for(int i = 0;i< counter; i++){
            aux[i] = splited[i];
        }

        for(int i = counter, j = counter+1;(i < remainingElements && j < splited.length);  i++,j++){
            aux[i] = splited[j];
        }

        //Ver ciclos ou arranjar uma maneira de resolver isto


        return aux;
    }


    private double converter(String str){
        double num = 0;
        try{
            num = Double.parseDouble(str);
        }catch (Exception e){
            System.err.println("Error to convert -> " + str);
            return -1;
        }
        return num;
    }

    //private Map<Integer,Double> countDivMul = new HashMap<>();

    private double div(double num1, double num2){
        return num1/num2;
    }
    private double mul(double num1, double num2){
        return num1*num2;
    }

    public void reset() {
        strCount = "";
        lastNumber = 0;
        tempNumber = 0;
        newNumber = true;
        firstNumber = true;
        result = 0;
        op = Operator.none;
    }


    public String getDisplay() {
        return strNumber;
    }

    public void invertSignal() {
        tempNumber *= -1;
        strNumber = ""+tempNumber;
        newNumber = true;
    }

    public void setPi() {
        tempNumber = Math.PI;
        strNumber = ""+tempNumber;
        newNumber = true;
    }

    public void perc() {
        tempNumber = tempNumber / 100 * lastNumber;
        strNumber = "" + tempNumber;
        newNumber = true;
    }

}
