package com.example.ex4_1fx;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Label titolo;
    @FXML
    private Button b1,b2,b3,b4,b5;
    @FXML
    private VBox rootOperation;
    @FXML
    private AnchorPane root;

    private Spettacolo spettacolo;

    @FXML
    protected void initialize(){
        creazioneSpettacolo();
    }

    @FXML
    protected void creazioneSpettacolo(){
        Label l1=new Label("Inserire titolo della rappresentazione:");
        TextField t1=new TextField();
        t1.setPromptText("La locandiera");
        t1.setStyle("-fx-background-color: #f5ebe0; -fx-background-radius: 4; -fx-textFill: #edede9; -fx-border-color: #999388; -fx-border-width: 1px; -fx-border-radius: 16;");
        Label l2=new Label("Inserire il nome della compagnia teatrale:");
        TextField t2=new TextField();
        t2.setPromptText("PegadorCompany");
        t2.setStyle("-fx-background-color: #f5ebe0; -fx-background-radius: 16; -fx-textFill: #edede9; -fx-border-color: #999388; -fx-border-width: 1px; -fx-border-radius: 16;");
        Label l3=new Label("Inserire la data in cui avverrà:");
        TextField t3=new TextField();
        t3.setPromptText("12/24/2023");
        t3.setStyle("-fx-background-color: #f5ebe0; -fx-background-radius: 16; -fx-textFill: #edede9; -fx-border-color: #999388; -fx-border-width: 1px; -fx-border-radius: 16;");
        Label l4=new Label("Inserire l'ora d'inizio:");
        TextField t4=new TextField();
        t4.setPromptText("11:23");
        t4.setStyle("-fx-background-color: #f5ebe0; -fx-background-radius: 16; -fx-textFill: #edede9; -fx-border-color: #999388; -fx-border-width: 1px; -fx-border-radius: 16;");
        Label l5=new Label("Inserire il prezzo del biglietto intero:");
        TextField t5=new TextField();
        t5.setPromptText("5.00 €");
        t5.setStyle("-fx-background-color: #f5ebe0; -fx-background-radius: 16; -fx-textFill: #edede9; -fx-border-color: #999388; -fx-border-width: 1px; -fx-border-radius: 16;");
        Label l6=new Label("Inserire il numero di posti:");
        TextField t6=new TextField();
        t6.setPromptText("100");
        t6.setStyle("-fx-background-color: #f5ebe0; -fx-background-radius: 16; -fx-textFill: #edede9; -fx-border-color: #999388; -fx-border-width: 1px; -fx-border-radius: 16;");

        HBox hboxBottone = new HBox();
        Pane spacing=new Pane();
        spacing.setPrefHeight(10);
        hboxBottone.setAlignment(Pos.CENTER_RIGHT);
        Button bu1=new Button("Inserisci");
        bu1.setStyle("-fx-background-color: #d6ccc2; -fx-background-radius: 16; -fx-textFill: #edede9;");
        bu1.setPrefSize(96,24);
        hboxBottone.getChildren().add(bu1);

        rootOperation.getChildren().addAll(l1,t1,l2,t2,l3,t3,l4,t4,l5,t5,l6,t6,spacing,hboxBottone);
        bu1.setOnAction( e ->{
            spettacolo=new Spettacolo(t1.getText(),t2.getText(),t3.getText(),t4.getText(),Double.parseDouble(t5.getText()),Integer.parseInt(t6.getText()));
            rootOperation.getChildren().clear();
            titolo.setText(spettacolo.getTitoloSpettacolo());
            b1.setVisible(true);
            b2.setVisible(true);
            b3.setVisible(true);
            b4.setVisible(true);
            b5.setVisible(true);
        });
    }

    @FXML
    protected void nuovoSpettatore(){
        rootOperation.getChildren().clear();
        ComboBox c1=new ComboBox<>();
        Label l0=new Label("Seleziona un tipo di biglietto:");
        c1.getItems().addAll("Persona","Studente","Professore");
        Button bu1=new Button("Continua");
        rootOperation.getChildren().addAll(l0,c1,bu1);
        bu1.setOnAction( e -> {
            if ("Professore".equalsIgnoreCase((String) c1.getValue())){
                rootOperation.getChildren().clear();
                Label l1=new Label("Inserire il nome e cognome:");
                TextField t1=new TextField();
                t1.setPromptText("Mario Rossi");
                Label l2=new Label("Inserire l'indirizzo:");
                TextField t2=new TextField();
                t2.setPromptText("VCO, via milano 65 24035");
                Label l3=new Label("Inserire il codice del docente");
                TextField t3=new TextField();
                t3.setPromptText("AB0043");
                Label l4=new Label("Inserire il dipartimento i cui lavora:");
                TextField t4=new TextField();
                t4.setPromptText("Medicina");
                Button bu2=new Button("Inserisci");
                rootOperation.getChildren().addAll(l1,t1,l2,t2,l3,t3,l4,t4,bu2);
                bu2.setOnAction( e1 -> {
                    spettacolo.aggiuntaSpettatore(new Professore(t1.getText(),t2.getText(),t3.getText(),t4.getText()));
                    rootOperation.getChildren().clear();
                    mostraMessaggioConferma();
                });
            } else if ("Studente".equalsIgnoreCase((String) c1.getValue())) {
                rootOperation.getChildren().clear();
                Label l1=new Label("Inserire il nome e cognome:");
                TextField t1=new TextField();
                t1.setPromptText("Mario Rossi");
                Label l2=new Label("Inserire l'indirizzo:");
                TextField t2=new TextField();
                t2.setPromptText("VCO, via milano 65 24035");
                Button bu2=new Button("Inserisci");
                rootOperation.getChildren().addAll(l1,t1,l2,t2,bu2);
                bu2.setOnAction( e1 -> {
                    spettacolo.aggiuntaSpettatore(new Studente(t1.getText(),t2.getText()));
                    rootOperation.getChildren().clear();
                    mostraMessaggioConferma();
                });
            }else{
                rootOperation.getChildren().clear();
                Label l1=new Label("Inserire il nome e cognome:");
                TextField t1=new TextField();
                t1.setPromptText("Mario Rossi");
                Label l2=new Label("Inserire l'indirizzo:");
                TextField t2=new TextField();
                t2.setPromptText("VCO, via milano 65 24035");
                Button bu2=new Button("Inserisci");
                rootOperation.getChildren().addAll(l1,t1,l2,t2,bu2);
                bu2.setOnAction( e1 -> {
                    spettacolo.aggiuntaSpettatore(new Persona(t1.getText(),t2.getText()));
                    rootOperation.getChildren().clear();
                    mostraMessaggioConferma();
                });
            }
        });
    }

    @FXML
    protected void mostraMessaggioConferma() {
        Label messaggioConferma = new Label("Aggiunto correttamente");
        messaggioConferma.setStyle("-fx-background-color: #00FF00; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px;");
        messaggioConferma.setTextFill(Color.WHITE);
        messaggioConferma.setOpacity(0.9);
        messaggioConferma.setLayoutX(19);
        messaggioConferma.setLayoutY(370);

        root.getChildren().add(messaggioConferma);

        PauseTransition pausa = new PauseTransition(Duration.seconds(3));
        pausa.setOnFinished(event -> root.getChildren().remove(messaggioConferma));
        pausa.play();
    }

    @FXML
    protected void infoSpettacolo(){
        Label l1=new Label(spettacolo.toString());
        rootOperation.getChildren().clear();
        rootOperation.getChildren().add(l1);
    }

    @FXML
    protected void postiDisponibili(){
        Label l1=new Label("Posti disponibili: "+spettacolo.getPostiLiberi());
        rootOperation.getChildren().clear();
        rootOperation.getChildren().add(l1);
    }

    @FXML
    protected void elencoPrenotati(){
        Label l1=new Label(spettacolo.elencoPrenotazioni());
        rootOperation.getChildren().clear();
        rootOperation.getChildren().add(l1);
    }

    @FXML
    protected void ricercaCosto(){
        rootOperation.getChildren().clear();
        Persona [] spettatori= spettacolo.getSpettatori();
        ComboBox c1=new ComboBox<>();
        Label l0=new Label("seleziona uno spettatore:");
        for (int i=0; i<(spettatori.length-spettacolo.getPostiLiberi()); i++) {
            c1.getItems().add(spettatori[i].getNome());
        }
        Button bu1=new Button("Seleziona");
        rootOperation.getChildren().addAll(l0,c1,bu1);
        bu1.setOnAction( e -> {
            String s="";
            for (int i=0; i<(spettatori.length-spettacolo.getPostiLiberi()); i++) {
               if(spettatori[i].getNome().equalsIgnoreCase((String) c1.getValue())){
                   s=s+spettatori[i].getNome()+" costo: "+spettacolo.getCostoBiglietto(spettatori[i])+" €";
                   break;
               }
            }
            rootOperation.getChildren().clear();
            Label l1=new Label("Costo del biglietto per: "+s);
            l1.setWrapText(true);
            rootOperation.getChildren().add(l1);
        });
    }
}