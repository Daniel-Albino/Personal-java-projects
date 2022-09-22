package projetos.calculator.ui.gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import projetos.calculator.model.Calculator;

public class UiGui extends Application{
    Calculator model;
    @Override
    public void init() throws Exception {
        super.init();
        model = new Calculator();
    }

    @Override
    public void start(Stage stage) throws Exception {
        RootPane root = new RootPane(model);
        Scene scene = new Scene(root,325,550);
        stage.setMinHeight(500);
        stage.setMinWidth(300);
        stage.setScene(scene);
        stage.setTitle("Calculadora");
        stage.getIcons().add(new Image("images/icon.png"));
        stage.show();
    }
}
