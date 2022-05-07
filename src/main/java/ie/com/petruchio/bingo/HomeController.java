package ie.com.petruchio.bingo;

import ie.com.petruchio.utils.BingoUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JLabel;

/**
 *
 * @author Flavio
 */
public class HomeController extends BingoUtils implements Initializable {

    public List<String> numberPickedList = new ArrayList<>();
    public Integer counter = 0;
    public String numbersPicked = "";
    public JLabel pic;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startAds();        
    }

    @FXML
    private void handleSelectNumberAction(ActionEvent event) {
        ToggleButton button = (ToggleButton) event.getSource();

        String buttonText = button.getText();

        String numberChosen = this.getReferenceLetter(buttonText) + buttonText;

        if (!numberPickedList.contains(buttonText)) {
            numberPickedList.add(buttonText);
            numbersPicked += buttonText + " ";
            label_ultima_pedra_sorteada.setText(numberChosen);
            button.getStyleClass().add("red-button");
            counter++;
        } else {
            numberPickedList.remove(buttonText);
            buttonText = "-" + buttonText;
            numbersPicked += buttonText + " ";
            button.getStyleClass().removeAll("red-button");
            if (counter > 0) {
                counter--;
            }
        }

        label_sorteadas.setText(counter.toString());
        Integer numbersLeft = 75 - counter;
        label_restantes.setText(numbersLeft.toString());
        ta_sequencia_sorteio.setText(numbersPicked);
    }

    @FXML
    private void restartBingo() {

        Alert alert = new Alert(AlertType.CONFIRMATION, null, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.setTitle("Reiniciar Jogo");
        alert.setHeaderText("Deseja realmente reiniciar o placar do jogo?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            numberPickedList = new ArrayList<>();
            numbersPicked = "";
            label_ultima_pedra_sorteada.setText("");
            counter = 0;
            label_sorteadas.setText("0");
            label_restantes.setText("75");
            ta_sequencia_sorteio.setText("");
            unselectNumbers();
        }
    }

    @FXML
    private void switchToManageAds() throws IOException {
       try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/ie/com/petruchio/bingo/manage-ads.fxml"));

            Scene scene = new Scene((Parent) fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Gerenciar Anunciantes");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
    
    @FXML
    private void switchToAdsFullscreen() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/ie/com/petruchio/bingo/ads-fullscreen.fxml"));

            Scene scene = new Scene((Parent) fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
    
    public void startAds(){
        startsAds();
        
        URL urlIcon = getClass().getResource("/ie/com/petruchio/images/fullscreen_on.png");
        Image image = new Image(urlIcon.toString());
        final ImageView iv = new ImageView(image);
        this.btn_fullscreen_main.setGraphic(iv);
    }
    
    public String getReferenceLetter(String num) {
        Integer number = Integer.parseInt(num);
        if (number > 0 && number <= 15) {
            return "B";
        } else if (number > 15 && number <= 30) {
            return "I";
        } else if (number > 30 && number <= 45) {
            return "N";
        } else if (number > 45 && number <= 60) {
            return "G";
        } else if (number > 60) {
            return "O";
        }
        return "";
    }

    private void unselectNumbers() {
        btn_01.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_02.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_03.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_04.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_05.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_06.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_07.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_08.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_09.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_10.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_11.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_12.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_13.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_14.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_15.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_16.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_17.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_18.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_19.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_20.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_21.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_22.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_23.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_24.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_25.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_26.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_27.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_28.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_29.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_30.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_31.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_32.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_33.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_34.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_35.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_36.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_37.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_38.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_39.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_40.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_41.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_42.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_43.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_44.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_45.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_46.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_47.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_48.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_49.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_50.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_51.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_52.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_53.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_54.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_55.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_56.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_57.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_58.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_59.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_60.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_61.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_62.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_63.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_64.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_65.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_66.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_67.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_68.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_69.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_70.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_71.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_72.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_73.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_74.getStyleClass().removeAll("black-button", "white-button", "red-button");
        btn_75.getStyleClass().removeAll("black-button", "white-button", "red-button");
    }
    
}
