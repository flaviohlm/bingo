/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anuncios;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JLabel;
import javax.swing.Timer;
import utils.BingoUtils;

/**
 * FXML Controller class
 *
 * @author Flavio
 */
public class FXMLAnunciosController implements Initializable {

    public List<String> listaImages = new ArrayList<>();
    public JLabel pic;
    public Timer tm;
    public int x = 0;
    public Boolean fullscreen = true;
    @FXML
    private ImageView image_anuncios;
    @FXML
    private ToggleButton btn_fullscreen_anuncios;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.iniciaAnunciantes();
    }

    @FXML
    private void handleAnunciatesTelaCheiaAction(Event event) {
        fullscreen = !fullscreen;
        
        Stage stage;
        stage = (Stage) this.image_anuncios.getScene().getWindow();
        stage.setFullScreen(fullscreen);        
    }
    
    public void iniciaAnunciantes() {
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
        
        URL urlIcon = getClass().getResource("/pedras/fullscreen_off.png");
        Image image = new Image(urlIcon.toString());
        final ImageView iv = new ImageView(image);        
    }

    public void lerImagensDiretorio() {
        //1 - Verifica se existe o diretorio de imagens dos anuncios. Caso nao exista, cria-se.        
        File caminhoImagensAnunciantes = new File(BingoUtils.getAnunciantesPath());
        if (!caminhoImagensAnunciantes.exists()) {
            caminhoImagensAnunciantes.mkdirs();
        }

        //2 - Faz a leitura dos arquivos do diretorio
        for (File imagem : caminhoImagensAnunciantes.listFiles()) {
            //System.out.println(name);
            if (!imagem.getName().equals("Thumbs.db")) {
                listaImages.add(BingoUtils.getAnunciantesPath() + "/" + imagem.getName());
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
