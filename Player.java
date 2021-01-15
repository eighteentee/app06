import java.util.ArrayList;

/**
 * This class stores information about the player
 * including the player's current state in terms
 * of oxygen, score and the number of turns so far.
 * The player can carry a number of items up to 
 * the maximum weight.
 *
 * @author Phill Horrocks & Chris Edgley
 * @version 0.1
 */
public class Player
{
    // Setup the variable for the oxygen levels
    // Player starts with 50 oxygen and must locate a spare tank
    
    public static final int MAX_OXYGEN = 100;
    public static final int MIN_OXYGEN = 10;
    public static final int START_OXYGEN = 50;

    public static final int MAX_PROVISION = 100;
    public static final int MIN_PROVISION = 10;
    public static final int PROVISION_LOSS = 6;
    
    public static final int MOVE_ENERGY = 4;
    
    private String name;

    private int score;

    private int moves;

    private int energy;
    
    private int oxygen;

    private int water;
    
    private int food;
    
    private int startOxygen;
    
    private boolean alive;

    private ArrayList<ItemTypes> items;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        items = new ArrayList<ItemTypes>();

        score = 0;
        moves = 0;
        
        food = MAX_PROVISION;
        water = MAX_PROVISION;
        energy = MAX_OXYGEN;
        startOxygen = START_OXYGEN;

        alive = true;
    }

    public String getName()
    {
        return this.name;
    }//end method getName

    public void setName(String name)
    {
        this.name = name;
    }//end method setName

    public int getScore()
    {
        return this.score;
    }//end method getScore

    public void incScore(int amount)
    {
        score = score + amount;
    }//end method setScore

    public void decScore(int amount)
    {
        score = score - amount;
        if(score < 0)score = 0;
    }//end method setScore

    public int getMoves()
    {
        return this.moves;
    }

    public void incMoves()
    {
        this.moves++;
        this.energy -= MOVE_ENERGY;

        useProvisions(ItemTypes.WATER, water);
        useProvisions(ItemTypes.FOOD, food);
        
        if(energy < MIN_OXYGEN)
            alive = false;
    }

    private void useProvisions(ItemTypes item, int provision)
    {
        if(isCarrying(item))
        {
            provision -= (PROVISION_LOSS/2);
            energy += 2;
        }
        else
        {
            water -= PROVISION_LOSS;
        }
        
        if(provision < MIN_PROVISION)
            alive = false;
        
    }
    
    public int getOxygen()
    {
        return this.oxygen;
    }

    public void incOxygen(int increase)
    {
        this.energy += increase;
        if(energy > MAX_OXYGEN)energy = MAX_OXYGEN;
    }

    public void decOxygen(int decrease)
    {
        this.energy -= decrease;
        if(energy < MIN_OXYGEN)
            alive = false;
    }

    public boolean isAlive()
    {
        return this.alive;
    }

    public void setAlive()
    {
        this.alive = true;
    }

    public ArrayList<ItemTypes> getItems()
    {
        return this.items;
    }

    public void addItem(ItemTypes item)
    {
        if(!isCarrying(item))
            this.items.add(item);
    }

    public void removeItem(ItemTypes item)
    {
        this.items.remove(item);
    }    

    public String toString()
    {
        String 
        output = "\n ----------------------------------------------" +
            "\n | " + name + ": | Move " + moves + " | Oxygen = " + oxygen +
            " | Score = " + score + " |" +
            "\n ----------------------------------------------\n";

        output += showItems();
        return output;
    }

    public boolean isCarrying(ItemTypes item)
    {
        return items.contains(item);
    }
    
    public String showItems()
    {
        String inventory = "\n You are carrying: ";
        int count = 0;
        
        if(items.size() == 0)
            inventory += "nothing in your inventory";
        else
        {
            for(ItemTypes item : items)
            {
                count++;
                inventory += item;

                if(count < items.size())
                {
                    inventory += ", ";
                }
                else
                {
                    inventory += "\n";
                }
            }
        }
        return inventory;
    }
}
