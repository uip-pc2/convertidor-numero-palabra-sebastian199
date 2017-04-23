package Secundaria;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


public class Principal {

    public ConvertidorDeNumero

    this.Entero = letra;


        @FXML
        private
        TextField Entero;

        public Principal(Button btn_enviar) {
            this.btn_enviar = btn_enviar;
        }

        @FXML
        private
        Button btn_enviar;


        public void enviar(ActionEvent actionEvent) throws IOException {
            double Entero = 0;
            String n1 = n1.getText();
            if (n1.isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error en Numero no introducido");
                alerta.setHeaderText("Mira, hubo un error...");
                alerta.setContentText("no debe estar vacio.");
                alerta.showAndWait();
¶                n1.setText("");
                return;
            } else {
                try {
                    n1 = Double.parseDouble(n1);
                } catch (NumberFormatException e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error en Sub-total");
                    alerta.setHeaderText("Mira, hubo un error...");
                    alerta.setContentText("El sub-total es un numero.");
                    alerta.showAndWait();
                    Entero.setText();
                    return;
                }
                Stage stage = (Stage) btn_enviar.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Secundaria.fxml"));
                Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (Exception e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error de Aplicacion");
                    alerta.setHeaderText("Mira, hubo un error...");
                    alerta.setContentText("Lo siento. Llama al administrador.");
                    alerta.showAndWait();
                    Platform.exit();
                }
                Secundaria sc = fxmlLoader.<Secundaria>getController();
                sc.setEntero(Entero);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }

        public void cerrar (ActionEvent actionEvent) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmacion de Salida");
            alerta.setHeaderText("Usted esta saliendo de la aplicacion");
            alerta.setContentText("Esta seguro de esto?");
            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.get() == ButtonType.OK) {
                Platform.exit();
            }
        }
    }

