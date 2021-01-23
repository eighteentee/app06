import java.util.ArrayList;

/**
 * This class stores information about the player
 * including the player's current state in terms
 * of energy, score and the number of turns so far.
 *
 * @author Chris Edgley & Phill Horrocks
 * @version 23.1.21
 */
public class Player
{
    public static final int MAX_ENERGY = 100;
    public static final int MIN_ENERGY = 10;
    public static final int MAX_PROVISION = 100;
    public static final int MIN_PROVISION = 10;
    public static final int PROVISION_LOSS = 1;
    public static final int MOVE_ENERGY = 3;
    
    private String name;
    
    private int score;
    private int moves;
    private int energy;
    private int food;
    private int oxygen;
    
    private boolean alive;

    private ArrayList<ItemTypes> items;

    /**
     * This is the Player, once a game is started
     * this is created for the player to have their
     * data stored whilst playing the game
     */
    public Player(String name)
    {
        this.name = name;
        items = new ArrayList<ItemTypes>();

        score = 0;
        moves = 0;
        
        food = MAX_PROVISION;
        oxygen = MAX_PROVISION;
        energy = MAX_ENERGY;

        alive = true;
    }

    /**
     * This allows the game to get your name 
     * you enter
     */
    public String getName()
    {
        return this.name;
    }//end method getName

    /**
     * This allows a user to be able to enter 
     * a name for themselves
     */
    public void setName(String name)
    {
        this.name = name;
    }//end method setName

    /**
     * This allows the game to be able to access 
     * your score
     */
    public int getScore()
    {
        return this.score;
    }//end method getScore

    /**
     * This allows the game to add a set amount of
     * points
     */
    public void incScore(int amount)
    {
        score = score + amount;
    }//end method setScore

    /**
     * This allows the game to keep track of how many
     * times you have moved
     */
    public int getMoves()
    {
        return this.moves;
    }

    /**
     * This allows the game to be able to increase the
     * amount of your current moves
     */
    public void incMoves()
    {
        this.moves++;
        this.energy -= MOVE_ENERGY;

        useProvisions(ItemTypes.OXYGEN, oxygen);
        useProvisions(ItemTypes.FOOD, food);
        
        if(energy < MIN_ENERGY)
            alive = false;
    }

    /**
     * This allows the game to see what items
     * you have and change the amount of energy
     * and oxygen you use
     */
    private void useProvisions(ItemTypes item, int provision)
    {
        if(isCarrying(item))
        {
            provision -= (PROVISION_LOSS/2);
            energy += 2;
        }
        else
        {
            oxygen -= PROVISION_LOSS;
        }
        
        if(provision < MIN_PROVISION)
            alive = false;
        
    }
    
    /**
     * This allows the game to show you your current energy
     */
    public int getEnergy()
    {
        return this.energy;
    }

    /**
     * This allows the game to increase your
     * current amount of energy
     */
    public void incEnergy(int increase)
    {
        this.energy += increase;
        if(energy > MAX_ENERGY)energy = MAX_ENERGY;
    }

    /**
     * This allows the game to increase your
     * current amount of energy
     */
    public void decEnergy(int decrease)
    {
        this.energy -= decrease;
        if(energy < MIN_ENERGY)
            alive = false;
    }

    /**
     * This checks to see if the player is alive
     */
    public boolean isAlive()
    {
        return this.alive;
    }

    /**
     * This sets the player's alive status to true
     */
    public void setAlive()
    {
        this.alive = true;
    }

    /**
     * This allows you to see what items you have
     * in your possession
     */
    public ArrayList<ItemTypes> getItems()
    {
        return this.items;
    }

    /**
     * This allows the game to add an item to your
     * inventory
     */
    public void addItem(ItemTypes item)
    {
        if(!isCarrying(item))
            this.items.add(item);
    }

    /**
     * This allows the game to remove an item from
     * your inventory
     */
    public void removeItem(ItemTypes item)
    {
        this.items.remove(item);
    } 
    
    /**
     * This is your information, able to be seen
     * from in the game. it will load everytime
     * you do an action.   
     */
    public String toString()
    {
        String 
        output 
        = "\n ----------------------------------------------------------------------" +
            "\n | " + name + ": | Move number: " + moves + " | Energy : " + energy +
            " | Score:  " + score + " |" + " Oxygen: "+ oxygen + " |" + 
                 "\n ----------------------------------------------------------------------\n";

        output += showItems();
        return output;
    }

    /**
     * This allows the game to see if you are
     * currently holding an item of choice
     */
    public boolean isCarrying(ItemTypes item)
    {
        return items.contains(item);
    }
    
    /**
     * This allows the user to see what
     * items they are currently holding.
     */
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
