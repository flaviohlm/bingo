package ie.com.petruchio.bingo;

import ie.com.petruchio.utils.BingoUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Flavio
 */
public class AdsController extends BingoUtils implements Initializable {   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startAds();
    }
    
    public void startAds(){
        startsAds();
    }

    /*public void loadAdsImages() {
        //1 - Verifica se existe o diretorio de imagens dos anuncios. Caso nao exista, cria-se.        
        File caminhoImagensAnunciantes = new File(getAdsImagesPath());
        if (!caminhoImagensAnunciantes.exists()) {
            caminhoImagensAnunciantes.mkdirs();
        }
        //2 - Faz a leitura dos arquivos do diretorio
        for (File imagem : caminhoImagensAnunciantes.listFiles()) {
            if (!imagem.getName().equals("Thumbs.db")) {
                adsImagesList.add(getAdsImagesPath() + FILE_SEPARATOR + imagem.getName());
            }
        }
    }

    public void SetImageSize(int i) {
        try {
            File file = new File(adsImagesList.get(i));
            Image image = new Image(file.toURI().toString());
            image_anuncios.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
