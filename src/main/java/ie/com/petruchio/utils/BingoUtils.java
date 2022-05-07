package ie.com.petruchio.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javax.swing.Timer;

/**
 *
 * @author flavio
 */
public class BingoUtils extends FxmlUtils {
    public static final String FILE_SEPARATOR = "/";
    
    private List<String> adsImagesList;
    private Timer tm;
    private int x;
    
    public static String getAdsImagesPath(){
        return System.getProperty("user.dir")+"/images";
    }
    
    public void startsAds(){
        loadAdsImages();
        x=0;
        if (!adsImagesList.isEmpty()) {
            tm = new Timer(3000, (java.awt.event.ActionEvent e) -> {
                SetImageSize(x);
                x += 1;
                if (x >= adsImagesList.size()) {
                    x = 0;
                }
            });
            tm.start();
        }
    }
    
    private void loadAdsImages() {       
        File adsImagesPath = new File(getAdsImagesPath());
        if (!adsImagesPath.exists()) {
            adsImagesPath.mkdirs();
        }

        adsImagesList = new ArrayList<>();
        for (File file : adsImagesPath.listFiles()) {
            if (!file.getName().equals("Thumbs.db")) {
                adsImagesList.add(getAdsImagesPath() + FILE_SEPARATOR + file.getName());
            }
        }
        
        URL urlIcon = getClass().getResource("/ie/com/petruchio/images/Bingo.jpeg");
        Image image = new Image(urlIcon.toString());
        image_anuncios.setImage(image);
    }

    private void SetImageSize(int i) {
        try {
            File file = new File(adsImagesList.get(i));
            Image image = new Image(file.toURI().toString());
            image_anuncios.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
