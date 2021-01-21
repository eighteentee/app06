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
 * @version 
 */

public class Game 
{
    public static final int TAKE_SCORE = 50;
    public static final int COMMAND_ENERGY = 2;
    
    public static final char CLEAR_SCREEN ='\u000C';
    
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private Map map;
    
    
    //Setup logic
    private boolean grateLocked;
    //private boolean engineRoomLocked;
    //private boolean electricityOff;
    //private boolean isLeverPulled;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game(String playerName) 
    {
        player = new Player(playerName);
        
        map = new Map();
        currentRoom = map.getStartRoom();
        grateLocked = true;
        
        parser = new Parser();
    }


    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
            
            if(!player.isAlive())
            {
                System.out.println(" \n You have died due life support failure!\n");
                finished = true;
            }
            else if(player.isCarrying(ItemTypes.TREASURE))
            {
                System.out.println(" You have found fabulous treasure!");
                System.out.println(" and are setup for life!\n");
                System.out.println(" I just hope you can find your way out");
                
                finished = true;               
            }
        }
        
        System.out.println(" Thanka you so mucha for playing my gamee.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println(CLEAR_SCREEN);
        System.out.println(" Welcome to the World of Zuul!");
        System.out.println(" World of Zuul is a new, incredibly exiting adventure game.");
        System.out.println(" Type '" + CommandWord.HELP + "' if you need help.");
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
                System.out.println("Please can you be more specific");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
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
               
            case UNLOCK:
                unlockGrate();
                break;
                
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

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
            // if there is no second word, we don't know where to go...
            System.out.println(" Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println("You can not go this way!");
        }
        else 
        {
            if((currentRoom.getID() == 6) && grateLocked)
            {
                System.out.println(" The Engine Room Door is locked!");
            }
            else
            {
                currentRoom = nextRoom;
                
                player.incMoves();
                
                System.out.println(player);
                System.out.println(currentRoom.getShortDescription());
            }
        }
    }

    public void takeItem(Command command)
    {
        ItemTypes item = currentRoom.getItem();
        String object = command.getSecondWord();
        String stringItem = item.toString();
        
        boolean wantsWater = object.equals("water");
        
        if(object == null)
        {
            System.out.println("\n What do you want to take?");
        }
        else if((item == ItemTypes.NONE) && (!wantsWater))
        {
            System.out.println("\n There is nothing here to take!");
        }
        else
        {
            if(object.equals(stringItem) || wantsWater)
            {
                if(!wantsWater)
                {
                    currentRoom.removeItem();
                }
                
                if((wantsWater) && (!currentRoom.hasWater()))
                {
                    System.out.println("\n There is no water within reach!");
                }
                else if ((wantsWater && 
                         (!player.isCarrying(ItemTypes.BOTTLE))))
                {
                    System.out.println("\n You do not have a bottle!");
                    System.out.println(" You take a drink!");
                    player.incEnergy(2);
                }
                else
                {
                    if(!wantsWater)
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
    
    private void fill(Command command)
    //TODO Change BOTTLE to tank, change WATER to OXYGEN
    {
        if(currentRoom.hasWater())
        {
            String object = command.getSecondWord();
            
            if(object.equals(ItemTypes.BOTTLE.toString()))
            {
                player.addItem(ItemTypes.WATER);
                player.incScore(TAKE_SCORE);
                
                System.out.println(player);
                System.out.println(currentRoom.getShortDescription());                
            }
            else
            {
                System.out.println(" You do not have a bottle!");
            }
        }
        else
        {
            System.out.println(" There is no water here!");
        }
    }
    
    private void unlockGrate()
    //TODO change grate to engine room
    {
        if(player.isCarrying(ItemTypes.KEY))
        {
            grateLocked = false;
            System.out.println(" You have unlocked the engine room door!");
        }
        else
        {
            System.out.println(" You cannot unlock the engine room door without keycard!");
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
            System.out.println(" Quit what?");
            return false;
        }
        else 
        {
            return true;  // signal that we want to quit
        }
    }
}
