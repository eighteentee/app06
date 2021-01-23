import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighbouring room.
 * 
 * @author Chris Edgley & Phill Horrocks
 * @version 23.1.21
 */

public class Room 
{
    private int id;
    
    private String name;
    
    private String description;
    
    private HashMap<String, Room> exits;        
    
    private ItemTypes item;
    //TODO Rename to oxygen
    private ItemTypes oxygen;
    
    private String itemDescription;
    
    /**
     * This allows the creation of a room.
     * Initially wiht no name or exits,
     * this data is filled elsewhere.
     * 
     * @param name The room's name.
     */
    public Room(int id, String name) 
    {
        this.name = name;
        this.description = name;
        this.id = id;
        
        exits = new HashMap<>();
        item = ItemTypes.NONE;
        oxygen = ItemTypes.NONE;
    }

    /**
     * This allows the game to get the
     * room's ID in the app.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * This allows us to define how an exit is made
     * 
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * This allows the game to get the short descrption written
     * about a room
     */
    public String getShortDescription()
    {
        return " You are  " + name;
    }

    /**
     * Return a long description of the room in the form:
     * 
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String message =  " You are " + name + "\n\n You are " + 
               description + ".\n";
        
        if(item != ItemTypes.NONE)
            message += itemDescription + "\n";
            
        return message + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "\n Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * This allows the game to be able to 
     * get the name of the rooms
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * This allows the game to set a description
     * for each room
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * This allows the game to get the saved description
     * for your room
     */
    public String getDescription()
    {
        if(item == ItemTypes.NONE)
            return description;
        else
            return description + " " + itemDescription;
    }
    
    /**
     * This allows the game to set an item
     * for the user to interact with
     */
    public void setItem(ItemTypes item, String itemDescription)
    {
        this.item = item;
        this.itemDescription = itemDescription;
    }
    
    /**
     * This allows the game to put an item into the user's
     * inventory
     */
    public ItemTypes getItem()
    {
        return item;
    }
    
    /**
     * This allows the game to put an item into the user's
     * inventory
     */
    public void removeItem()
    {
        item = ItemTypes.NONE;
    }
    
    /**
     * This allows a room to have an oxygen tank
     */
    public void setOxygen()
    {
        oxygen = ItemTypes.OXYGEN;
    }
    
    /**
     * This checks to see if the room has any oxygen
     * in it
     */
    public boolean hasOxygen()
    {
        return (oxygen == ItemTypes.OXYGEN);
    }
}

