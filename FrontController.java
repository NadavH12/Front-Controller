/* Nadav Horowitz CS410 Software Engineering 5/27/23 FrontController.java Design Pattern Assignment
* This class contains the implementation of the FrontController object.
* The FrontController object uses a StreamDispatcher as a field to handle requests for RadioFeed and TVFeed.
*/

package demo.src.main.java.com.example;

import java.util.Scanner;
public class FrontController {

    private StreamDispatcher dispatcher;

    FrontController(){
        dispatcher = new StreamDispatcher();
    }

    //Request method takes user input to specify radio or television and passes collected input to dispatcher object.
    public void request(){
        System.out.println("Enter 'R' for radio or 'TV' for television:");
        Scanner input = new Scanner(System.in);
        String mediaType = input.next();
        input.close();
        dispatcher.streamMedia(mediaType);
    }
}