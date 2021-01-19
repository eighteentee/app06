/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Chris Edgley & Phill Horrocks
 * @version 
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), 
    TAKE("take"), UNLOCK("unlock"), EAT("eat"), 
    LOOK("look"), FILL("fill"), DRINK("drink"),
    INVENTORY("inventory"), UNKNOWN("?");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString.toLowerCase();
    }

    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString.toLowerCase();
    }
}
