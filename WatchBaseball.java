/* Nadav Horowitz CS410 Software Engineering 5/27/23 WatchBaseball.java Design Pattern Assignment
* This class is used to initialize and send a request to a FrontController object.
*/

package demo.src.main.java.com.example;

public class WatchBaseball {

    public static void main(String[] args) throws Exception{
        FrontController front = new FrontController();
        front.request();
    }
}