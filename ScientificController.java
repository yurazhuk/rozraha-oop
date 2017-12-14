package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;


public class ScientificController extends Controller {
    @FXML private MenuBar bar;

    @FXML
    private void changeToBasic() throws IOException {
        Parent basicViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scientificViewScene = new Scene(basicViewParent);

        Stage window = (Stage) (bar).getScene().getWindow();
        window.setTitle("Basic");
        window.setScene(scientificViewScene);
        window.show();
    }
}
