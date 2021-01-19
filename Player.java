import java.util.ArrayList;

/**
 * This class stores information about the player
 * including the player's current state in terms
 * of energy, score and the number of turns so far.
 * The player can carry a number of items up to 
 * the maximum weight.
 *
 * @author Chris Edgley & Phill Horrocks
 * @version (a version number or a date)
 */
public class Player
{
    public static final int MAX_ENERGY = 10000000;
    public static final int MIN_ENERGY = 10;
    
    public static final int MAX_OXYGEN = 100;

    public static final int MAX_PROVISION = 100000000;
    public static final int MIN_PROVISION = 1;
    public static final int PROVISION_LOSS = 1;
    
    public static final int MOVE_ENERGY = 1;
    
    private String name;

    private int score;

    private int moves;

    private int energy;

    private int water;
    
    private int food;
    
    private int oxygen;
    
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
        energy = MAX_ENERGY;
        
        oxygen = MAX_OXYGEN;

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
        
        if(energy < MIN_ENERGY)
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
    
    public int getEnergy()
    {
        return this.energy;
    }

    public void incEnergy(int increase)
    {
        this.energy += increase;
        if(energy > MAX_ENERGY)energy = MAX_ENERGY;
    }

    public void decEnergy(int decrease)
    {
        this.energy -= decrease;
        if(energy < MIN_ENERGY)
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
    // TODO: Change energy to 'oxygen'
    {
        String 
        output = "\n ----------------------------------------------" +
            "\n | " + name + ": | Move " + moves + " | Energy = " + energy +
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
            inventory += "nothing!";
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
