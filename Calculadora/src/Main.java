import javafx.application.Application;
import javafx.stage.Stage;
import projetos.calculator.ui.gui.UiGui;
//import projetos.calculator.ui.text.UiText;

public class Main{
    public static void main(String[] args){
        /*UiText uiText = new UiText();
        uiText.inicializeUi();*/
        Application.launch(UiGui.class,args);
    }
}
