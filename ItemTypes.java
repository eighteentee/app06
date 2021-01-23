/**
 * Enumeration class ItemTypes - write a description of the enum class here
 *
 * @author Chris Edgley & Phill Horrocks
 * @version 23.1.21
 */
public enum ItemTypes
{
    NONE("none"), KEY("passkey"), BOTTLE("tank"), OXYGEN("oxygen"), 
    FOOD("stimpack"),DOORKEY("doorkey");
    
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
