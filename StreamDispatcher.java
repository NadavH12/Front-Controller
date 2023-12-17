/* Nadav Horowitz CS410 Software Engineering 5/27/23 StreamDispatcher.java Design Pattern Assignment
* This class contains implementation details for the StreamDispatcher class. The class contains private fields representing the 
* request types it is able to handle. Calls appropriate methods associated with it's field objects according to request type.
*/

package demo.src.main.java.com.example;

public class StreamDispatcher {

    private RadioFeed Radio;
    private TVFeed TV;

    //Initializes request type fields 
    StreamDispatcher(){
        Radio = new RadioFeed();
        TV = new TVFeed();
    }

    //streamMedia method calls correct request handling methods according to the request's object type
    public void streamMedia(String feedType){
        if(feedType.equalsIgnoreCase("r")){
            Radio.play();
        } else {
            TV.play();
        }
    }
}