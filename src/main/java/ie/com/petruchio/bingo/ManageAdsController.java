package ie.com.petruchio.bingo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static ie.com.petruchio.utils.BingoUtils.FILE_SEPARATOR;
import static ie.com.petruchio.utils.BingoUtils.getAdsImagesPath;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author Flavio
 */
public class ManageAdsController implements Initializable {

    @FXML
    private ScrollPane root;
    @FXML
    private TilePane tile;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showAds();
    }

    @FXML
    private void addAdsImage() {
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(imageFilter);
        List<File> list = fc.showOpenMultipleDialog(new Stage());
        if (list != null) {
            list.forEach(file -> {
                try {
                    File destination = new File(getAdsImagesPath()+FILE_SEPARATOR+file.getName());
                    copyFile(file, destination);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }
        showAds();
    }
    
    @FXML
    private void switchToHome() throws IOException {
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

    private void showAds() {
        tile.getChildren().clear();
        try {
            List<File> files = Files.list(Paths.get(getAdsImagesPath()))
              .map(Path::toFile)
              .filter(File::isFile)
              .collect(Collectors.toList());

            files.forEach(file -> {
                tile.getChildren().addAll(createImageView(file));
            });
          } catch (IOException e) {
          }

        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Horizontal
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar
        root.setFitToWidth(true);
        root.setContent(tile);
    }

    private ImageView createImageView(final File imageFile) {
        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 150, 0, true, true);
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setOnMouseClicked((MouseEvent mouseEvent) -> {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    try {
                        BorderPane borderPane = new BorderPane();
                        ImageView imageView1 = new ImageView();
                        Image image1 = new Image(new FileInputStream(imageFile));
                        imageView1.setImage(image1);
                        imageView1.setStyle("-fx-background-insets: 0 ;");
                        imageView1.setPreserveRatio(true);
                        imageView1.setSmooth(true);
                        imageView1.setCache(true);
                        borderPane.setCenter(imageView1);
                        borderPane.setStyle("-fx-border-color: BLUE");
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imageView;
    }

    public static void copyFile(File source, File destination) throws IOException {
        if(destination.exists()){
            destination.delete();
        }
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
       }
   }
    
}
