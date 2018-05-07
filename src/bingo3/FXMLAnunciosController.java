/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo3;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * FXML Controller class
 *
 * @author Flavio
 */
public class FXMLAnunciosController implements Initializable {

    public String path = "C:\\bingo\\images";
    public List<String> listaImages = new ArrayList<>();
    public JLabel pic;
    public Timer tm;
    public int x = 0;
    @FXML
    private ImageView image_anuncios;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    }

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
