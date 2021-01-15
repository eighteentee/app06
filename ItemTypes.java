/**
 * Enumeration class ItemTypes - write a description of the enum class here
 *
 * @author Phill Horrocks
 * @version 0.1
 */
public enum ItemTypes
{
    NONE("none"), KEY("keys"), BOTTLE("bottle"), WATER("water"), 
    FOOD("apples"), TREASURE("treasure"), OXYGEN("oxygen");
    
    // NONE("none"), PASSWORD("password"), KEYCARD("keycard"), CUTTERS("cutters"),
    // SCREWDRIVER("screwdriver"), OXYGEN("oxygen");
    
    private String itemString;
    
    ItemTypes(String itemString)
    {
        this.itemString = itemString;
    }
    
    public String toString()
    {
        return itemString;
    }
}
