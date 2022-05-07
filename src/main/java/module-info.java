module ie.com.petruchio.bingo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;

    opens ie.com.petruchio.bingo to javafx.fxml;
    exports ie.com.petruchio.bingo;
    
    opens ie.com.petruchio.utils to javafx.fxml;
    exports ie.com.petruchio.utils;
}
