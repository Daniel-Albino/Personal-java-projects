package projetos.calculator.model;

import java.util.Arrays;

public class Calculator {
    private String strCount;
    private String strNumber;
    private String count1;
    private double lastNumber,tempNumber;
    private boolean newNumber, firstNumber,equal;
    double result;

    public Calculator() {
        strCount = "";
        strNumber = "0";
        lastNumber = 0;
        tempNumber = 0;
        newNumber = true;
        firstNumber = true;
        equal = false;
        count1 = "";
        result = 0;
    }

    public boolean addNewCount(String str){
        if(str.isBlank() || str.length()<1)
            return false;

        if(equal){
            strCount = String.valueOf(result);
            equal = false;
        }
        if(str.equals("Pi")){
            if(newNumber) {
                strCount += setPi();
                newNumber = false;
            }else
                return false;
            return true;
        }

        if(strCount.isBlank())
            if(!Character.isDigit(str.charAt(0)))
                return false;

        if(Character.isDigit(str.charAt(0))){
            strCount += str;
            strNumber = str;
        }else if(!str.equals(" = ")){
            strCount += str;
            newNumber = true;
        }else {
            strCount += "";
            if(!count(strCount.split("\\s+")).equals("lenght 0")){
                strNumber = String.valueOf(result);
                strCount += " = ";

            }else {
                result = Double.parseDouble(strCount);
                strCount = "";
            }

            equal = true;
        }
        count1 = strCount;
        return true;
    }

    private String count(String[] splited) {
        String[] aux = splited;
        boolean bol = false;
        int i = 0;
        System.out.println(splited.length);
        if(splited.length == 1) {
            System.out.println("Aqui!");
            return "lenght 0";
        }
        do {
            aux = divMul(aux);
            if(Arrays.equals(aux, splited))
                break;
            if(aux.length == 0)
                return "length = 0";
            if(aux.length == 1) {
                result = converter(aux[0]);
                bol = true;
            }
        }while (!bol);
        sumSub(aux);
        return "Result";
    }

    private void sumSub(String[] aux){
        if(aux.length == 1) {
            return;
        }
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
                double num1, num2;
                int index1, index2;
                index1 = counter-1;
                index2 = counter+1;
                num1 = converter(splited[index1]);
                num2 = converter(splited[index2]);
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
                return newStrCount(counter, splited,count);
            counter++;
        }
        return splited;
    }

    private String[] newStrCount(int counter, String[] splited, double count) {
        if(splited.length == 1){
            result = converter(splited[0]);
            return new String[0];
        }

        String[] aux = new String[splited.length - 2];

        splited[counter-1] = String.valueOf(count);

        int i = 0;

        for(;i<counter;i++)
            aux[i] = splited[i];

        int j = i;
        i+=2;

        for(;i<splited.length;j++,i++)
            aux[j] = splited[i];


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
        equal = false;
        result = 0;
    }


    public String getDisplay() {
        return strNumber;
    }

    public String getSecondDisplay(){
        return count1;
    }

    public void invertSignal() {
        tempNumber *= -1;
        strNumber = ""+tempNumber;
        newNumber = true;
    }

    public String setPi() {
        tempNumber = Math.PI;
        String pi = ""+tempNumber;
        return pi;
    }

    public void perc() {
        tempNumber = tempNumber / 100 * lastNumber;
        strNumber = "" + tempNumber;
        newNumber = true;
    }

}
