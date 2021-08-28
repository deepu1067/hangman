package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Controller {
    private String word;
    private int lifes=6;
    private int scores=0;

    @FXML
    private Label life, score, result;
    @FXML
    private Label txt1, txt2, txt3, txt4, txt5, txt6;
    @FXML
    private ImageView img1;
    @FXML
    private Button next, go;
    @FXML
    private TextField textIn;
    @FXML
    public void submit(ActionEvent e){
        String guessed = textIn.getText().toUpperCase(Locale.ROOT);

        if(guessed.equals(word.toUpperCase(Locale.ROOT))) {
            scores += 5;
            score.setText(scores+"");
            result.setText("Well done");
            textIn.setText("");
            textIn.setDisable(true);
            go.setDisable(true);
            next.setVisible(true);
        }
        else{
            lifes--;
            life.setText(lifes+"");
            if(lifes == 5)
                img1.setImage(new Image(getClass().getResourceAsStream("image/1.png")));
            else if(lifes == 4 )
                img1.setImage(new Image(getClass().getResourceAsStream("image/2.png")));
            else if(lifes == 3 )
                img1.setImage(new Image(getClass().getResourceAsStream("image/3.png")));
            else if(lifes == 2 )
                img1.setImage(new Image(getClass().getResourceAsStream("image/4.png")));
            else if(lifes == 1 )
                img1.setImage(new Image(getClass().getResourceAsStream("image/5.png")));
            else if(lifes == 0 ) {
                String strScore = score.getText();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("gameOver.fxml"));
                    Parent root = loader.load();

                    GameOver controller2 = loader.getController();
                    controller2.displayScore(strScore);

                    Stage stage =(Stage) ((Node)e.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            result.setText("Wrong");
        }
    }
    @FXML
    public void changeWord(){
        initialize();
        next.setVisible(false);
        go.setDisable(false);
        textIn.setDisable(false);
    }

    //Initializing values after starting the application
    @FXML
    void initialize(){
        scoringSystem(scores);
        System.out.println(word);
        textIn.setText("");
    }

    private void showWord3(String str){
        ArrayList<Label> labelList = new ArrayList<Label>();
        labelList.add(txt1);
        labelList.add(txt2);
        labelList.add(txt3);
        labelList.add(txt4);
        labelList.add(txt5);
        labelList.add(txt6);

        labelList.get(0).setText("");
        labelList.get(4).setText("");
        labelList.get(5).setText("");

        ArrayList<Integer> randomNum = randomInteger(3);
        int flag=0;
        for(int i=1; i<4; i++){
            flag=0;

            for(int j: randomNum){
                if(i==(j+1)) {
                    labelList.get(i).setText("_");
                    flag=1;
                    break;
                }
            }

            if(flag != 1)
                labelList.get(i).setText(str.charAt(i-1)+"");
        }
    }

    private void showWord4(String str){
        ArrayList<Label> labelList = new ArrayList<Label>();
        labelList.add(txt1);
        labelList.add(txt2);
        labelList.add(txt3);
        labelList.add(txt4);
        labelList.add(txt5);
        labelList.add(txt6);

        labelList.get(0).setText("");
        labelList.get(5).setText("");

        ArrayList<Integer> randomNum = randomInteger(4);
        int flag=0;
        for(int i=1; i<5; i++){
            flag=0;

            for(int j: randomNum){
                if(i==(j+1)) {
                    labelList.get(i).setText("_");
                    flag=1;
                    break;
                }
            }

            if(flag != 1)
                labelList.get(i).setText(str.charAt(i-1)+"");
        }
    }

    private void showWord5(String str){
        ArrayList<Label> labelList = new ArrayList<Label>();
        labelList.add(txt1);
        labelList.add(txt2);
        labelList.add(txt3);
        labelList.add(txt4);
        labelList.add(txt5);
        labelList.add(txt6);

        labelList.get(0).setText("");

        ArrayList<Integer> randomNum = randomInteger(5);
        int flag=0;
        for(int i=1; i<6; i++){
            flag=0;

            for(int j: randomNum){
                if(i==(j+1)) {
                    labelList.get(i).setText("_");
                    flag=1;
                    break;
                }
            }

            if(flag != 1)
                labelList.get(i).setText(str.charAt(i-1)+"");
        }
    }

    private void showWord6(String str){
        ArrayList<Label> labelList = new ArrayList<Label>();
        labelList.add(txt1);
        labelList.add(txt2);
        labelList.add(txt3);
        labelList.add(txt4);
        labelList.add(txt5);
        labelList.add(txt6);

        ArrayList<Integer> randomNum = randomInteger(6);
        int flag=0;
        for(int i=0; i<6; i++){
            flag=0;

            for(int j: randomNum){
                if(i==j) {
                    labelList.get(i).setText("_");
                    flag=1;
                    break;
                }
            }

            if(flag != 1)
                labelList.get(i).setText(str.charAt(i)+"");
        }
    }

//    private String generateString(String path){
//        ArrayList<String> list = new ArrayList<>();
//        try {
//            FileReader file = new FileReader(path);
//            BufferedReader reader = new BufferedReader(file);
//
//            while((reader.readLine()) != null){
//                list.add(reader.readLine());
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Collections.shuffle(list);
//
//        return list.get(0).toUpperCase(Locale.ROOT);
//    }

    private static String generateString(String path, int length){
        ArrayList<String> list = new ArrayList<>();
        try {
            FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine();
            while(line != null){
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> finalList = new ArrayList<>();
        for(String str: list){
            if(str.length()==length){
                finalList.add(str);
            }
        }

        Collections.shuffle(finalList);
        return finalList.get(0);
    }

    private ArrayList<Integer> randomInteger(int max){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<max; i++){
            list.add(i);
        }

        Collections.shuffle(list);
        
        ArrayList<Integer> outList = new ArrayList<>();
        if(max==6) {
            outList.add(list.get(0));
            outList.add(list.get(1));
            outList.add(list.get(2));
        }
        else if(max==5 || max==4){
            outList.add(list.get(0));
            outList.add(list.get(1));
        }
        else{
            outList.add(list.get(0));
        }
        return outList;
    }

    private void scoringSystem(int scores){
        if(scores>=0 && scores<=15){
            word = generateString("src/sample/output.txt", 3);
            showWord3(word);
        }
        else if(scores>=20 && scores<=35){
            word = generateString("src/sample/output.txt", 4);
            showWord4(word);
        }
        else if(scores>=40 && scores<=55){
            word = generateString("src/sample/output.txt", 5);
            showWord5(word);
        }
        else{
            word = generateString("src/sample/output.txt", 6);
            showWord6(word);
        }
    }
}
