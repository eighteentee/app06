import java.util.Scanner;
/**
 * This class creates an instance of the Game
 * class and then calls on its run method.
 *
 * @author Derek Peacock
 * @version 0.1
 */
public class Program
{
    private static Game game;
    private static String name;  
    
    /**
     * This class creates and runs an instance of
     * the Game class
     */
    public static void main()
    {
        String name;
        Scanner user_input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = user_input.next();
        System.out.println ("Your name is:" + name);
        
        game = new Game(name);
        game.play();
        //char c = (char)System.in.read();
        //System.out.println("Character entered = " + c);
    }
}
