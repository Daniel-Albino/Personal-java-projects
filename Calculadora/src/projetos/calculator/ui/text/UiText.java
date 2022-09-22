/*package projetos.calculator.ui.text;

import projetos.calculator.model.Calculator;
import projetos.calculator.utils.PAInput;

public class UiText {
    private Calculator calculator;
    public UiText() {
        calculator = new Calculator();
    }

    public void inicializeUi() {
        boolean finish = false;
        calculator.firstNumber(PAInput.readDouble("Write a number: "));
        System.out.println("Total = "+calculator.getTotal());
        do{
            switch (PAInput.chooseOption("Choose option","Add","Subtract","Multiply","Divide","Minus or Plus","Clear All","Iqual","Exit")){
                case 1 -> calculator.add(PAInput.readDouble("Write a number: "));
                case 2 -> calculator.sub(PAInput.readDouble("Write a number: "));
                case 3 -> calculator.mul(PAInput.readDouble("Write a number: "));
                case 4 -> calculator.div(PAInput.readDouble("Write a number: "));
                case 5 -> calculator.minusOrPlus();
                case 6 -> calculator.clear();
                case 7 -> calculator.iqual();
                case 8 -> finish = true;
            }
            System.out.println("Total = "+calculator.getTotal());
            if(calculator.isFirstNumber()){
                calculator.firstNumber(PAInput.readDouble("Write a number: "));
                System.out.println("Total = "+calculator.getTotal());
            }
        }while(!finish);
    }
}*/
