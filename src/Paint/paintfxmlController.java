package Paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class paintfxmlController implements Initializable {

    @FXML
    private ColorPicker colorpicker;

    @FXML
    private TextField bsize;

    @FXML
    private Canvas canvas;

    boolean toolSelected = false;

    GraphicsContext brushToll;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        brushToll = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged( e -> {
            double size;
            try{
                size = Double.parseDouble(bsize.getText());
            }catch (NumberFormatException ec){
                size = 0;
            }
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if(toolSelected && !bsize.getText().isEmpty()){
                brushToll.setFill(colorpicker.getValue());
                brushToll.fillRoundRect(x, y, size, size, size, size);
            }
        });
    }

    @FXML
    public void toolselected(ActionEvent e){
        toolSelected = true;
    }
}