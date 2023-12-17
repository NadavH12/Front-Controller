/* Nadav Horowitz CS410 Software Engineering 5/27/23 TVFeed.java Design Pattern Assignment
* This class contains implementation details for the TVFeed class which serves as a request type for the front controller design pattern.
*/

package demo.src.main.java.com.example;

import java.io.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.util.*;

public class TVFeed extends Application {

    public void play(){
        Application.launch(TVFeed.class);
    }

    //Plays video of baseball game, takes 3rd party library Javafx Stage object as parameter 
    //Prints error message if unable to play video of baseball game
    public void start(Stage stage){
        try{
            File file = new File("MLB_Video.mp4");
            
            //Initialize player and viewer
            MediaPlayer player = new MediaPlayer(new Media(file.toURI().toURL().toString()));
            MediaView viewer = new MediaView(player);
        
            //Change width and height to fit video
            DoubleProperty width = viewer.fitWidthProperty();
            DoubleProperty height = viewer.fitHeightProperty();
            width.bind(Bindings.selectDouble(viewer.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(viewer.sceneProperty(), "height"));
            viewer.setPreserveRatio(true);
        
            //Set the scene
            StackPane root = new StackPane();
            root.getChildren().add(viewer);
            Scene scenes = new Scene(root, 900, 900, Color.BLACK);
            stage.setScene(scenes);

            //Set title and play
            stage.setAlwaysOnTop(true);
            stage.setTitle("Mariners Baseball TV Feed");
            stage.show();   
            player.play(); 

            //Auto-close window upon video completion
            PauseTransition delay = new PauseTransition(Duration.seconds(15));
            delay.setOnFinished( event -> stage.close() );
            delay.play();
        } catch(Exception e){
            System.out.println("Could not open TV Feed");
        }
    } 
}