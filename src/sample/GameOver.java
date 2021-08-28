package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOver {
    @FXML
    Label finalScore;

    void displayScore(String score){
        finalScore.setText(score +"");
    }

    public void playAgain(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
