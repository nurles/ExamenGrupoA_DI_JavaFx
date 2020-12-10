package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Controller {

    @FXML
    private Button boton1;

    @FXML
    private Button boton2;

    @FXML
    private Button boton3;

    @FXML
    private Button boton4;

    @FXML
    private Button boton5;

    @FXML
    private Label label;

    @FXML
    public void initialize(){
        ArrayList<Button>lista = new ArrayList<>();
        lista.add(boton1);
        lista.add(boton2);
        lista.add(boton3);
        lista.add(boton4);
        lista.add(boton5);
        //Mezcla aleatoriamente el contenido de la lista
        Collections.shuffle(lista);
        for (int i=0;i<lista.size();i++){
            lista.get(i).setText(""+(i+1));
        }
    }

    private int numeroEsperado = 1;

    @FXML
    private void bClicked(MouseEvent event){
        Button b = (Button) event.getSource();
        System.out.println(b.getText());
        if(Integer.parseInt(b.getText()) == numeroEsperado){
            numeroEsperado++;
            if(numeroEsperado>5){
                System.out.println("Abriendo Ventana");
                //Abrir nueva ventana
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
                    Stage primaryStage = new Stage();
                    primaryStage.setTitle("Hello World");
                    primaryStage.setScene(new Scene(root, 300, 275));
                    primaryStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }else{
            System.out.println("Has fallado, intentalo otra vez");
            numeroEsperado = 1;
        }
    }


}
