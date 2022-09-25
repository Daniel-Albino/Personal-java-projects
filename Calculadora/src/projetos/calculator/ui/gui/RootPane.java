package projetos.calculator.ui.gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import projetos.calculator.model.Calculator;


public class RootPane extends BorderPane {
    Calculator model;
    Text result,lastResult;
    Button btnAC, btnPer, btnPlusMinus, btnDivide, btnSeven, btnEight, btnNine, btnFour, btnFive, btnSix, btnOne, btnTwo,
            btnThree, btnMultiply, btnPlus, btnMinus, btnEquals, btnZero, btnPi, btnPoint;

    String total,auxT;

    public RootPane(Calculator calculator){
        model = calculator;
        auxT = "";
        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        setStyle("-fx-background-color: #1F1F1F");
        result = new Text(model.getDisplay());
        lastResult = new Text(auxT);
        result.setFont(Font.font("Arial", FontWeight.BOLD,40));
        result.setFill(Color.WHITE);
        lastResult.setFont(Font.font("Arial",15));
        lastResult.setFill(Color.WHITE);

        VBox vBoxResult = new VBox(lastResult,result);
        setMargin(vBoxResult,new Insets(25,25,25,25));
        vBoxResult.setPadding(new Insets(20,20,20,20));
        vBoxResult.setSpacing(10);
        vBoxResult.setAlignment(Pos.CENTER_RIGHT);

        setTop(vBoxResult);

        btnConfig();




        HBox hBox1 = new HBox(btnAC,btnPer,btnPlusMinus,btnDivide);
        hBox1.setSpacing(3);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setHgrow(btnAC,Priority.ALWAYS);
        hBox1.setHgrow(btnPer,Priority.ALWAYS);
        hBox1.setHgrow(btnPlusMinus,Priority.ALWAYS);
        hBox1.setHgrow(btnDivide,Priority.ALWAYS);

        HBox hBox2 = new HBox(btnSeven,btnEight,btnNine,btnMultiply);
        hBox2.setSpacing(3);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setHgrow(btnSeven,Priority.ALWAYS);
        hBox2.setHgrow(btnEight,Priority.ALWAYS);
        hBox2.setHgrow(btnNine,Priority.ALWAYS);
        hBox2.setHgrow(btnMultiply,Priority.ALWAYS);

        HBox hBox3 = new HBox(btnFour,btnFive,btnSix,btnMinus);
        hBox3.setSpacing(3);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setHgrow(btnFour,Priority.ALWAYS);
        hBox3.setHgrow(btnFive,Priority.ALWAYS);
        hBox3.setHgrow(btnSix,Priority.ALWAYS);
        hBox3.setHgrow(btnMinus,Priority.ALWAYS);

        HBox hBox4 = new HBox(btnOne,btnTwo,btnThree,btnPlus);
        hBox4.setSpacing(3);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setHgrow(btnOne,Priority.ALWAYS);
        hBox4.setHgrow(btnTwo,Priority.ALWAYS);
        hBox4.setHgrow(btnThree,Priority.ALWAYS);
        hBox4.setHgrow(btnPlus,Priority.ALWAYS);

        HBox hBox5 = new HBox(btnPi,btnZero,btnPoint,btnEquals);
        hBox5.setSpacing(3);
        hBox5.setAlignment(Pos.CENTER);
        hBox5.setHgrow(btnPi,Priority.ALWAYS);
        hBox5.setHgrow(btnZero,Priority.ALWAYS);
        hBox5.setHgrow(btnPoint,Priority.ALWAYS);
        hBox5.setHgrow(btnEquals,Priority.ALWAYS);

        VBox vBoxButton = new VBox(hBox1,hBox2,hBox3,hBox4,hBox5);
        setMargin(vBoxButton,new Insets(20,0,0,0));
        vBoxButton.setSpacing(3);
        vBoxButton.prefHeightProperty().bind(vBoxButton.heightProperty());
        vBoxButton.setVgrow(hBox1,Priority.ALWAYS);
        vBoxButton.setVgrow(hBox2,Priority.ALWAYS);
        vBoxButton.setVgrow(hBox3,Priority.ALWAYS);
        vBoxButton.setVgrow(hBox4,Priority.ALWAYS);
        vBoxButton.setVgrow(hBox5,Priority.ALWAYS);
        setCenter(vBoxButton);
    }

    private void btnConfig() {

        btnAC = new Button("AC");
        btnAC.setFont(Font.font("Arial",15));
        btnAC.setStyle("-fx-background-color: #131313;" + "-fx-background-radius: 0");
        btnAC.setTextFill(Color.WHITE);
        btnAC.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnAC.setPrefSize(80,80);
        btnAC.setMinSize(50,50);

        btnPer = new Button("%");
        btnPer.setFont(Font.font("Arial",15));
        btnPer.setStyle("-fx-background-color: #131313;" + "-fx-background-radius: 0");
        btnPer.setTextFill(Color.WHITE);
        btnPer.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnPer.setPrefSize(80,80);
        btnPer.setMinSize(50,50);


        btnPlusMinus = new Button("+/-");
        btnPlusMinus.setFont(Font.font("Arial",15));
        btnPlusMinus.setStyle("-fx-background-color: #131313;" + "-fx-background-radius: 0");
        btnPlusMinus.setTextFill(Color.WHITE);
        btnPlusMinus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnPlusMinus.setPrefSize(80,80);
        btnPlusMinus.setMinSize(50,50);


        btnDivide = new Button("/");
        btnDivide.setFont(Font.font("Arial",15));
        btnDivide.setStyle("-fx-background-color: #131313;" + "-fx-background-radius: 0");
        btnDivide.setTextFill(Color.WHITE);
        btnDivide.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnDivide.setPrefSize(80,80);
        btnDivide.setMinSize(50,50);


        btnSeven = new Button("7");
        btnSeven.setFont(Font.font("Arial",15));
        btnSeven.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnSeven.setTextFill(Color.WHITE);
        btnSeven.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnSeven.setPrefSize(80,80);
        btnSeven.setMinSize(50,50);


        btnEight = new Button("8");
        btnEight.setFont(Font.font("Arial",15));
        btnEight.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnEight.setTextFill(Color.WHITE);
        btnEight.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnEight.setPrefSize(80,80);
        btnEight.setMinSize(50,50);


        btnNine = new Button("9");
        btnNine.setFont(Font.font("Arial",15));
        btnNine.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnNine.setTextFill(Color.WHITE);
        btnNine.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnNine.setPrefSize(80,80);
        btnNine.setMinSize(50,50);


        btnMultiply = new Button("*");
        btnMultiply.setFont(Font.font("Arial",15));
        btnMultiply.setStyle("-fx-background-color: #131313;" + "-fx-background-radius: 0");
        btnMultiply.setTextFill(Color.WHITE);
        btnMultiply.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnMultiply.setPrefSize(80,80);
        btnMultiply.setMinSize(50,50);


        btnFour = new Button("4");
        btnFour.setFont(Font.font("Arial",15));
        btnFour.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnFour.setTextFill(Color.WHITE);
        btnFour.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnFour.setPrefSize(80,80);
        btnFour.setMinSize(50,50);


        btnFive = new Button("5");
        btnFive.setFont(Font.font("Arial",15));
        btnFive.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnFive.setTextFill(Color.WHITE);
        btnFive.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnFive.setPrefSize(80,80);
        btnFive.setMinSize(50,50);


        btnSix = new Button("6");
        btnSix.setFont(Font.font("Arial",15));
        btnSix.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnSix.setTextFill(Color.WHITE);
        btnSix.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnSix.setPrefSize(80,80);
        btnSix.setMinSize(50,50);


        btnMinus = new Button("-");
        btnMinus.setFont(Font.font("Arial",15));
        btnMinus.setStyle("-fx-background-color: #131313;" + "-fx-background-radius: 0");
        btnMinus.setTextFill(Color.WHITE);
        btnMinus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnMinus.setPrefSize(80,80);
        btnMinus.setMinSize(50,50);


        btnOne = new Button("1");
        btnOne.setFont(Font.font("Arial",15));
        btnOne.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnOne.setTextFill(Color.WHITE);
        btnOne.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnOne.setPrefSize(80,80);
        btnOne.setMinSize(50,50);


        btnTwo = new Button("2");
        btnTwo.setFont(Font.font("Arial",15));
        btnTwo.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnTwo.setTextFill(Color.WHITE);
        btnTwo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnTwo.setPrefSize(80,80);
        btnTwo.setMinSize(50,50);


        btnThree = new Button("3");
        btnThree.setFont(Font.font("Arial",15));
        btnThree.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnThree.setTextFill(Color.WHITE);
        btnThree.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnThree.setPrefSize(80,80);
        btnThree.setMinSize(50,50);


        btnPlus = new Button("+");
        btnPlus.setFont(Font.font("Arial",15));
        btnPlus.setStyle("-fx-background-color: #131313;" + "-fx-background-radius: 0");
        btnPlus.setTextFill(Color.WHITE);
        btnPlus.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnPlus.setPrefSize(80,80);
        btnPlus.setMinSize(50,50);


        btnPi = new Button("Pi");
        btnPi.setFont(Font.font("Arial",15));
        btnPi.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnPi.setTextFill(Color.WHITE);
        btnPi.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnPi.setPrefSize(80,80);
        btnPi.setMinSize(50,50);


        btnZero = new Button("0");
        btnZero.setFont(Font.font("Arial",15));
        btnZero.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnZero.setTextFill(Color.WHITE);
        btnZero.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnZero.setPrefSize(80,80);
        btnZero.setMinSize(50,50);


        btnPoint = new Button(",");
        btnPoint.setFont(Font.font("Arial",15));
        btnPoint.setStyle("-fx-background-color: rgb(6,6,6);" + "-fx-background-radius: 0");
        btnPoint.setTextFill(Color.WHITE);
        btnPoint.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnPoint.setPrefSize(80,80);
        btnPoint.setMinSize(50,50);


        btnEquals = new Button("=");
        btnEquals.setFont(Font.font("Arial",15));
        btnEquals.setStyle("-fx-background-color: #134369;" + "-fx-background-radius: 0");
        btnEquals.setTextFill(Color.WHITE);
        btnEquals.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //btnEquals.setPrefSize(80,80);
        btnEquals.setMinSize(50,50);


    }

    private void registerHandlers() {

        btnAC.setOnAction(event ->{
            model.reset();
            update();
        });

        btnZero.setOnAction(event -> {
            model.addNewCount("0");
            update();
        });

        btnOne.setOnAction(event -> {
            model.addNewCount("1");
            update();
        });

        btnTwo.setOnAction(event -> {
            model.addNewCount("2");
            update();
        });

        btnThree.setOnAction(event -> {
            model.addNewCount("3");
            update();
        });

        btnFour.setOnAction(event -> {
            model.addNewCount("4");
            update();
        });

        btnFive.setOnAction(event -> {
            model.addNewCount("5");
            update();
        });

        btnSix.setOnAction(event -> {
            model.addNewCount("6");
            update();
        });

        btnSeven.setOnAction(event -> {
            model.addNewCount("7");
            update();
        });

        btnEight.setOnAction(event -> {
            model.addNewCount("8");
            update();
        });

        btnNine.setOnAction(event -> {
            model.addNewCount("9");
            update();
        });

        btnPoint.setOnAction(event ->{
            model.addNewCount(",");
            update();
        });

        btnPlus.setOnAction(event ->{
            model.addNewCount(" + ");
            update();
        });

        btnMinus.setOnAction(event ->{
            model.addNewCount(" - ");
            update();
        });

        btnMultiply.setOnAction(event ->{
            model.addNewCount(" * ");
            update();
        });

        btnDivide.setOnAction(event ->{
            model.addNewCount(" / ");
            update();
        });

        btnEquals.setOnAction(event ->{
            model.addNewCount(" = ");
            update();
        });

        btnPi.setOnAction(event ->{
            model.addNewCount("Pi");
            update();
        });

    }

    private void update(){
        lastResult.setText(model.getSecondDisplay());
        result.setText(model.getDisplay());
    }
}
