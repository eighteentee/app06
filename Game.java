/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. 
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method or run the Program.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author Chris Edgley & Phill Horrocks
 * @version 23.1.21
 */

public class Game 
{
    public static final int TAKE_SCORE = 50;
    public static final int COMMAND_ENERGY = 5;
    
    public static final char CLEAR_SCREEN ='\u000C';
    
    private Parser parser;
    private Room currentRoom;
    private Room nextRoom;
    private Player player;
    private Map map;
    
    private boolean finished = false;
    private boolean leverIsOn = false;
    //Setup logic
  
    
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game(String playerName) 
    {
        player = new Player(playerName);
        
        map = new Map();
        currentRoom = map.getStartRoom();
        
        parser = new Parser();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        //Enter the main command loop.  Here we repeatedly read commands and
        //execute them until the game is over.
                
        boolean finished = false;
        boolean leverIsOn = false;
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
            
            if(!player.isAlive())
            {
                System.out.println(" \n You have died due to life support failure!\n");
                finished = true;
            }

            else if (player.isCarrying(ItemTypes.KEY) && currentRoom.getID() == 12 && leverIsOn == false)
            {
                System.out.println("Quick!Use the passkey!");
                leverIsOn = true;
            } 
            
            else if(player.isCarrying(ItemTypes.KEY) && currentRoom.getID() == 12 && leverIsOn == true)
            {
                
                System.out.println("You flash the passkey and slam that now opened button to get way away \n" + 
                "from the collapsing ship! your life is saved!");
                finished = true;
            }
            
            else if(player.isAlive() && currentRoom.getID() == 10 && !player.isCarrying(ItemTypes.DOORKEY))
            {
                System.out.println(" YOU HAVE DIED IN THE SHIP'S FAULTY AIRLOCK");
                
                finished = true; 
            }
            else if(player.isAlive() && currentRoom.getID() == 10 && player.isCarrying(ItemTypes.DOORKEY))
            {
               System.out.println(
               "Today is your lucky day - normally, you'd have died a painful, cold\n"+
               "death in the icy grip of deep space, but, you had the good foresight\n"+
               "to collect the door key in the vent. You quickly notice the key colour\n"+
               "is the same as the airlock and you thrust the card into the reader.\n"+
               "You haul youself through the door and to safety. The door closes.");
               finished = false;
               
            }   
        }
        
        System.out.println("Thanks for playing our game. Hope to see you again soon!");
    }
  
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println(CLEAR_SCREEN);
        System.out.println(" Welcome to The Abandoned Spaceship!");
        System.out.println(" The Abandoned Spaceship is a new, incredibly exiting adventure game.");
        System.out.println(" Please Type '" + CommandWord.HELP + "' if you need any help!");
        System.out.println();
        
        System.out.println(player);
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        player.decEnergy(COMMAND_ENERGY);
        
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("Please can you be more specific? I can't understand you.");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
                
            case EAT:
                eatFood(command);
                break;
                
            case LOOK:
                System.out.println(currentRoom.getLongDescription());
                break;

            case TAKE:
                takeItem(command);
                break;
                
            case FILL:
                fill(command);
                break;
                
            case LAUNCH:
                launch(command);
                break;
                
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    //implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println(player);
        System.out.println(" You are currently " + currentRoom.getShortDescription());
        System.out.println();
        System.out.println(" Your command phrases are:");
        
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            //if there is no second word, we don't know where to go...
            System.out.println("Where do you want to go?");
            return;
        }

        String direction = command.getSecondWord();

        //Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println("You can not go this way!");
        }
        else 
        {
                currentRoom = nextRoom;
                
                player.incMoves();
                
                System.out.println(player);
                System.out.println(currentRoom.getShortDescription());
            
        }
    }

    /**
     * This checks to see if there is an item to take, then checks
     * if the item you typed was the correct items. if these both
     * are true, you take the item.
     */
    public void takeItem(Command command)
    {
        ItemTypes item = currentRoom.getItem();
        String object = command.getSecondWord();
        String stringItem = item.toString();
        
        boolean wantsOxygen = object.equals("oxygen");
        
        if(object == null)
        {
            System.out.println("\n What do you want to take?");
        }
        else if((item == ItemTypes.NONE) && (!wantsOxygen))
        {
            System.out.println("\n You can not take something that isn't there!");
        }
        else
        {
            if(object.equals(stringItem) || wantsOxygen)
            {
                if(!wantsOxygen)
                {
                    currentRoom.removeItem();
                }
                
                if((wantsOxygen) && (!currentRoom.hasOxygen()))
                {
                    System.out.println("\n There is no oxygen within reach!");
                }
                else
                {
                    if(!wantsOxygen)
                    {
                        player.addItem(item);
                        player.incScore(TAKE_SCORE);
                        System.out.println("\n You have taken the " + item);
                    }
                    else
                    {
                        System.out.println("\n You have filled the oxygen tank with oxygen!");
                    }
                    
                    System.out.println(player);
                    System.out.println(currentRoom.getShortDescription());                    
                }
            }
            else
            {
                System.out.println("\n You can't take the " + object);
            }
        }
    }
    
    private void eatFood(Command command)
    {
        if (player.isCarrying(ItemTypes.FOOD))
        {
            player.incEnergy(50);
            player.removeItem(ItemTypes.FOOD);
            System.out.println("You have used the stimpack and feel refreshed");
        }    
    }    
    
    /**
     * This is essentially our win condition, it checks
     * to see if you hold a certain item when you use the
     * command
     */
    private void launch(Command command)
    {
        
        if (player.isCarrying(ItemTypes.KEY) && currentRoom.getID() == 12)
        {
            leverIsOn = true;
            System.out.println("You have used the key to be able to pull the lever");
            
        }
        else if (!player.isCarrying(ItemTypes.KEY) && currentRoom.getID() == 12)
        {
            System.out.println("You need the key! you remember Mr Stark had the key. \n" +
            "Maybe his jacket is still in the staffroom?");
        }   
    }  
    
    /**
     * This command allows the user to fill
     * their tank up with oxygen
     */
    private void fill(Command command)
    
    {
        if(currentRoom.hasOxygen())
        {
            String object = command.getSecondWord();
            
            if(object.equals(ItemTypes.BOTTLE.toString()))
            {
                player.addItem(ItemTypes.OXYGEN);
                player.incScore(TAKE_SCORE);
                
                System.out.println(player);
                System.out.println(currentRoom.getShortDescription());                
            }
            else
            {
                System.out.println(" You do not have a tank!");
            }
        }
        else
        {
            System.out.println(" There is no oxygen here!");
        }
    }
     
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("What do you want to quit?");
            return false;
        }
        else 
        {
            return true;  // signal that we want to quit
        }
    }
}
