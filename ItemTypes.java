
/**
 * Enumeration class ItemTypes - write a description of the enum class here
 *
 * @author Chris Edgley & Phill Horrocks
 * @version 
 */
public enum ItemTypes
{
    NONE("none"), KEY("key"), BOTTLE("bottle"), WATER("water"), 
    FOOD("apples"), TREASURE("treasure");
    
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
