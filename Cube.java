import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Cube extends Application {

    @Override
    public void start(Stage primaryStage) {

        Box[] box = new Box[100];
        for (int i = 0; i < 3; i++) {
            int x = (i+1)*300;
            box[i] = createBox(x);
        }

        Group root = new Group();
        for (int i = 0; i < box.length; i++) {
            if (box[i] != null) {
                root.getChildren().add(box[i]);
            }
        }

        PerspectiveCamera camera = new PerspectiveCamera();


        Scene scene = new Scene(root, 1150, 650);
        scene.setCamera(camera);

        primaryStage.setTitle("3D Cube Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Box createBox(int xCor) {
        Box box = new Box();
        box.setWidth(200);
        box.setHeight(200);
        box.setDepth(200);

        box.setTranslateX(xCor);
        box.setTranslateY(300);
        box.setTranslateZ(0);

        PhongMaterial material = new PhongMaterial();
        material.setSpecularColor(Color.BLACK);
        material.setDiffuseColor(Color.RED);

        box.setMaterial(material);
        Rotate xRotation = new Rotate(25, Rotate.X_AXIS);
        Rotate yRotation = new Rotate(25, Rotate.Y_AXIS);

        box.getTransforms().addAll(xRotation, yRotation);
        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}