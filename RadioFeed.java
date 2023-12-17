/* Nadav Horowitz CS410 Software Engineering 5/27/23 RadioFeed.java Design Pattern Assignment
* This class contains implementation details for the RadioFeed class which serves as a request type for the front controller design pattern.
*/

package demo.src.main.java.com.example;

import java.io.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.scene.media.*;
import javafx.stage.*;
import javafx.util.*;

public class RadioFeed extends Application{

    //Prevents early garbage collection
    MediaPlayer player;

    //Used to make front controller compatible with 3rd party library Javafx
    public void play(){
        Application.launch(RadioFeed.class);
    }

    //Plays audio of baseball game, takes 3rd party library Javafx Stage object as parameter 
    public void start(Stage stage){
        String musicFile = "MLB_Audio.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        player = new MediaPlayer(sound);
        player.play();
        stage.show();

        //Auto-close window upon video completion
        PauseTransition delay = new PauseTransition(Duration.seconds(15));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }
}