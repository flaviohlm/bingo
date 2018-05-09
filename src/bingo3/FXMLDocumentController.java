/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo3;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Flavio
 */
public class FXMLDocumentController implements Initializable {

    public List<String> listaNumerosSorteados = new ArrayList<>();
    public Integer contador = 0;
    public String numerosSorteados = "";

    public String path = "C:\\bingo\\images";
    public List<String> listaImages = new ArrayList<>();
    public JLabel pic;
    public Timer tm;
    public int x = 0;

    @FXML
    private GridPane grid_geral;
    @FXML
    private GridPane grid_1;
    @FXML
    private Circle shape_00;
    @FXML
    private Label label_ultima_pedra_sorteada;
    @FXML
    private Pane pn_ordem_sorteio;
    @FXML
    private TextArea ta_sequencia_sorteio;
    @FXML
    private Pane pn_cartela;
    @FXML
    private ToggleButton btn_01;
    @FXML
    private Label label_sorteadas;
    @FXML
    private Label label_restantes;
    @FXML
    private Button btn_reiniciar;
    @FXML
    private ToggleButton btn_02;
    @FXML
    private ToggleButton btn_04;
    @FXML
    private ToggleButton btn_03;
    @FXML
    private ToggleButton btn_07;
    @FXML
    private ToggleButton btn_08;
    @FXML
    private ToggleButton btn_06;
    @FXML
    private ToggleButton btn_05;
    @FXML
    private ToggleButton btn_13;
    @FXML
    private ToggleButton btn_15;
    @FXML
    private ToggleButton btn_11;
    @FXML
    private ToggleButton btn_12;
    @FXML
    private ToggleButton btn_10;
    @FXML
    private ToggleButton btn_09;
    @FXML
    private ToggleButton btn_24;
    @FXML
    private ToggleButton btn_25;
    @FXML
    private ToggleButton btn_27;
    @FXML
    private ToggleButton btn_26;
    @FXML
    private ToggleButton btn_30;
    @FXML
    private ToggleButton btn_29;
    @FXML
    private ToggleButton btn_28;
    @FXML
    private ToggleButton btn_20;
    @FXML
    private ToggleButton btn_21;
    @FXML
    private ToggleButton btn_23;
    @FXML
    private ToggleButton btn_22;
    @FXML
    private ToggleButton btn_18;
    @FXML
    private ToggleButton btn_19;
    @FXML
    private ToggleButton btn_17;
    @FXML
    private ToggleButton btn_16;
    @FXML
    private ToggleButton btn_39;
    @FXML
    private ToggleButton btn_40;
    @FXML
    private ToggleButton btn_42;
    @FXML
    private ToggleButton btn_41;
    @FXML
    private ToggleButton btn_45;
    @FXML
    private ToggleButton btn_44;
    @FXML
    private ToggleButton btn_43;
    @FXML
    private ToggleButton btn_35;
    @FXML
    private ToggleButton btn_36;
    @FXML
    private ToggleButton btn_38;
    @FXML
    private ToggleButton btn_37;
    @FXML
    private ToggleButton btn_33;
    @FXML
    private ToggleButton btn_34;
    @FXML
    private ToggleButton btn_32;
    @FXML
    private ToggleButton btn_31;
    @FXML
    private ToggleButton btn_46;
    @FXML
    private ToggleButton btn_47;
    @FXML
    private ToggleButton btn_49;
    @FXML
    private ToggleButton btn_48;
    @FXML
    private ToggleButton btn_52;
    @FXML
    private ToggleButton btn_53;
    @FXML
    private ToggleButton btn_51;
    @FXML
    private ToggleButton btn_50;
    @FXML
    private ToggleButton btn_58;
    @FXML
    private ToggleButton btn_59;
    @FXML
    private ToggleButton btn_60;
    @FXML
    private ToggleButton btn_56;
    @FXML
    private ToggleButton btn_57;
    @FXML
    private ToggleButton btn_55;
    @FXML
    private ToggleButton btn_54;
    @FXML
    private ToggleButton btn_69;
    @FXML
    private ToggleButton btn_70;
    @FXML
    private ToggleButton btn_72;
    @FXML
    private ToggleButton btn_71;
    @FXML
    private ToggleButton btn_75;
    @FXML
    private ToggleButton btn_74;
    @FXML
    private ToggleButton btn_73;
    @FXML
    private ToggleButton btn_65;
    @FXML
    private ToggleButton btn_66;
    @FXML
    private ToggleButton btn_68;
    @FXML
    private ToggleButton btn_67;
    @FXML
    private ToggleButton btn_63;
    @FXML
    private ToggleButton btn_64;
    @FXML
    private ToggleButton btn_62;
    @FXML
    private ToggleButton btn_61;
    @FXML
    private ToggleButton btn_14;
    @FXML
    private ImageView image_anuncios;
    @FXML
    private BorderPane panel_anunciantes;
    @FXML
    private Button btn_anunciantes;
    @FXML
    private ToggleButton btn_fullscreen_main;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniciaAnunciantes();        
    }

    @FXML
    private void handleSelectNumberAction(ActionEvent event) {
        ToggleButton button = (ToggleButton) event.getSource();

        String textoBotao = button.getText();

        String pedraClicada = this.retornaLetra(textoBotao) + textoBotao;

        if (!listaNumerosSorteados.contains(textoBotao)) {
            listaNumerosSorteados.add(textoBotao);
            numerosSorteados += textoBotao + " ";
            label_ultima_pedra_sorteada.setText(pedraClicada);
            button.getStyleClass().add("red-button");
            contador++;
        } else {
            listaNumerosSorteados.remove(textoBotao);
            textoBotao = "-" + textoBotao;
            numerosSorteados += textoBotao + " ";
            button.getStyleClass().removeAll("red-button");
            if (contador > 0) {
                contador--;
            }
        }

        label_sorteadas.setText(contador.toString());
        Integer pedrasRestantes = 75 - contador;
        label_restantes.setText(pedrasRestantes.toString());
        ta_sequencia_sorteio.setText(numerosSorteados);
    }

    @FXML
    private void handleReiniciarJogoAction(ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION, null, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.setTitle("Reiniciar Jogo");
        alert.setHeaderText("Deseja realmente reiniciar o placar do jogo?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            listaNumerosSorteados = new ArrayList<>();
            numerosSorteados = "";
            label_ultima_pedra_sorteada.setText("");
            contador = 0;
            label_sorteadas.setText("0");
            label_restantes.setText("75");
            ta_sequencia_sorteio.setText("");

            //SETA OS BOTOES AO ESTADO DE ORIGEM
            setarBotoesEstadoOriginal();
        }
    }

    @FXML
    private void handleAnunciatesAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLGerenciarAnuncios.fxml"));
            /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            //stage.setTitle("New Window");
            stage.setScene(scene);
            stage.show();
           
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
    
    @FXML
    private void handleAnunciatesTelaCheiaAction(Event event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLAnuncios.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
           
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    
    public void iniciaAnunciantes(){
        this.lerImagensDiretorio();
        if (!this.listaImages.isEmpty()) {
            tm = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    SetImageSize(x);
                    x += 1;
                    if (x >= listaImages.size()) {
                        x = 0;
                    }
                }
            });
            tm.start();
        }
        
        URL urlIcon = getClass().getResource("/pedras/fullscreen_on.png");
        Image image = new Image(urlIcon.toString());
        final ImageView iv = new ImageView(image);
        this.btn_fullscreen_main.setGraphic(iv);
    }
    
    public String retornaLetra(String num) {
        Integer numero = Integer.parseInt(num);
        if (numero > 0 && numero <= 15) {
            return "B";
        } else if (numero > 15 && numero <= 30) {
            return "I";
        } else if (numero > 30 && numero <= 45) {
            return "N";
        } else if (numero > 45 && numero <= 60) {
            return "G";
        } else if (numero > 60) {
            return "O";
        }
        return "";
    }

    private void setarBotoesEstadoOriginal() {
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

    //METODOS DA LEITURA DE IMAGENS
    public void lerImagensDiretorio() {
        //1 - Verifica se existe o diretorio de imagens dos anuncios. Caso nao exista, cria-se.        
        File caminhoImagensAnunciantes = new File(path);
        if (!caminhoImagensAnunciantes.exists()) {
            caminhoImagensAnunciantes.mkdirs();
        }

        //2 - Faz a leitura dos arquivos do diretorio
        for (File imagem : caminhoImagensAnunciantes.listFiles()) {
            //System.out.println(name);
            if (!imagem.getName().equals("Thumbs.db")) {
                listaImages.add(path + "\\" + imagem.getName());
            }
        }
    }

    public void SetImageSize(int i) {
        try {
            File file = new File(listaImages.get(i));
            Image image = new Image(file.toURI().toString());
            image_anuncios.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
