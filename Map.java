                                                                                                                                                                   /**
 * Write a description of class Map here.
 *
 * @author Chris Edgley & Phill Horrocks
 * @version 23.1.21
 */
public class Map


{
    
    private String description;
    
    private Room start;
    private Room staffroom;
    private Room electrical;
    private Room mobileServicing;
    private Room communications;
    private Room medbay;
    private Room engineRoom;
    private Room vent;
    private Room corridor;
    private Room reactor; 
    private Room airlock;
    private Room damagedPod;
    private Room escapePod;
    
    
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createStart();
        createStaffroom();
        createElectrical();
        createMobileServicing();
        createComms();
        createMedbay();
        createEngineRoom();
        createVent();
        createCorridor();
        createReactor();
        createAirlock();
        createDamagedPod();
        createEscapePod();
                
    }
    
    public Room getStartRoom()
    {
        return start;
    }
    
    /**
     * This is the room the player starts in
     */
    private void createStart()
    {
        start = new Room(0, " inside the ship's navigation room");//START ROOM
        description =  
        " groggy, your vision blurred, eyes rolling around.\n"+
        "The piercing wailing of the ship’s alarm system is bringing\n"+
        "you round faster than your concussion would like. “WARNING: HULL\n"+
        "BREACH. WARNING: HULL BREACH. LIFE SUPPORT SYSTEMS CRITICAL.\n"+
        "APPROXIMATE TIME TO OXYGEN DEPLETION 3 MINUTES”. Your eyes\n"+
        "make out the flashing of the alarm lights and the warning\n"+
        "messages flashing on the ship’s main console. There is a\n"+
        "clock on the console, counting down the minutes. You pick\n"+
        "yourself up and manage to stagger to the ship’s console and\n"+
        "turn off the cacophonous noise of the alarm. Slowly, eye’s\n"+
        "still going in and out of focus, you bring up the ship’s\n"+
        "schematic and damage report on the computer. The damage report\n"+
        "states that the ship's quarters have sustained critical\n"+
        "damage and no life forms are being reported. Your crew is gone.\n"+
        "Just then, your suit reports a critical oxygen leak - your\n"+
        "oxygen tank has taken damage and is losing pressure fast.\n"+
        "The suit damage report states you have less than 2 minutes of\n"+
        "oxygen remaining. You realise you don’t have enough oxygen to\n"+
        "make it to the escape pod in time, unless of course you can\n"+
        "find replacement oxygen… and fast. Your only way out is north\n"+
        "to the navigation room. In the corner is an empty oxygen tank";
        
        start.setDescription(description);
        //Rename to TANK
        start.setItem(ItemTypes.BOTTLE, "\n There is an empty oxygen tank lying in the corner");
    }
    
    /**
     * This Staffroom has a key here to be picked up
     */
    private void createStaffroom()
    {
        staffroom = new Room(1, "inside the staff room");
        
        // STAFFROOM
        description = 
        "in the staff room, chairs and tables are strewn around everywhere\n"+
        "making navigation difficult. There are a number of garments laying\n"+
        "around and in the corner, one in particular catches your eye, the\n"+
        "name tag reading Stark. Captain Stark’s jacket has a small key marked\n"+
        "'LAUNCH' in the chest pocket. The rest of the room seems to contain\n"+
        "nothing useful as you watch the timer tick down on the console screen\n"+
        "above, you decide you must act fast.";
        
        staffroom.setDescription(description);
        
        staffroom.setItem(ItemTypes.KEY, "\n There is a passkey marked Engine Room here.");
        connectRooms(start, "north", staffroom);
    }

    /**
     * This is the Electrical Room 
     */
    private void createElectrical()
    {
        electrical = new Room(2, "in the ship's main electrical room.");
        
        description = 
        "In the electrical room, wires and steam currently block your path\n"+
        "back to the main ship but you see the engine room has been burst open,\n"+
        "possibly by one of your crewmates before they deserted the ship.";
        
        //TODO Set electrical switch mechanic to enable the escape pod
        electrical.setDescription(description);        

        connectRooms(start, "east", electrical);        
    }
    
    /**
     * This is the Mobile Servicing Room   
     */
    private void createMobileServicing()
    {
       mobileServicing = new Room(3, "in the ship's mobile service system.");
        
       description =  
       "in the Mobile Service System, normally, this is a dedicated area for\n"+
       "launching satellites into orbit or repairing damaged space vehicles.\n"+
       "Now, the arm which normally does this is broken and laying on its side\n"+
       "with its main manipulator torn off. There is nothing of use here";
       
       mobileServicing.setDescription(description);        
       
       connectRooms(start, "west", mobileServicing);
    }
    
    /**
     * This is the Communication room 
     */
    private void createComms()
    {
        communications = new Room(4, "in the ship's communications room");
        
        description = 
        "in the communications room it is surprisingly unaffected by the\n"+
        "catastrophic event now signalling your death. Around the room\n"+
        "there are the now familiar console warnings and flashing red\n"+
        "alarm lights. Over near the main comms console you can see a\n"+
        "terminal which looks unlike the others. ";
        
        communications.setDescription(description);
        
        communications.setItem(ItemTypes.FOOD, "\n There is a stimpack on the floor!");
            
        connectRooms(start, "south", communications);
              
    }
    
    /**
     * This is the Medbay room 
     */
    private void createMedbay()
    {
        medbay = new Room(5, "in the ship's medical bay");
        
        description = 
        "in the medbay, medical computers, beds and equipment are in complete\n"+
        "disarray with the rooms various cupboards and storage contents emptied\n"+
        "everywhere. Through the mess, you can spot the emergency door to the\n"+
        "engine room, which is currently open with steam and sparks emitting from\n"+
        "the broken systems that lie beyond. On top of one of the upturned beds,\n"+
        "you can just make out the top of what looks like a yellow oxygen tank.\n"+
        "On the floor you spot an oxygen outlet";
        
        // use the oxygen outlet to fill the oxygen tank
        
        medbay.setDescription(description);
        medbay.setOxygen();
        
        connectRooms(medbay, "north", communications);
    }
    
    /**
     *  This is the Engine Room  
     */
    private void createEngineRoom()
    {
        engineRoom = new Room(6, "in the ship's engine room");
        
        // TODO: Need to have the passkey for this door from the ships bridge
        
        description = 
        "in the ship’s engine room. Here, the power source of the ship’s\n"+
        "propulsion system lies exposed, dangerously emitting arcs of\n"+
        "electricity between the core and the hull of the ship. Steam and\n"+
        "sparks are everywhere. There is no chance of repairing the warp\n"+
        "core as it’s too badly damaged. Time is running out and the warnings\n"+
        "are now showing ‘SYSTEMS CRITICAL’ on the engine room consoles...\n"+
        "There is a door marked 'Emergency Escape This Way'.Beyond the door \n"+ 
        "you can see ladders descending into the darkness...";
        
        engineRoom.setDescription(description);
        connectRooms(engineRoom, "north", medbay);
    }
    
    /**
     * This is the Ventilation Shaft
     */
    private void createVent()
    {
        vent = new Room(7, "in a ventillation shaft");
        
        description = 
        "descending the ladders, you pathway is blocked and your only way\n"+
        "out is to go through a small ventillation shaft just behind you.\n"+
        "The shaft is claustrophic and the oxygen tank rattles and scrapes\n"+
        "its way along with you. Up ahead you can make out flashing red\n"+
        "alarm lights again";
        
        vent.setItem(ItemTypes.DOORKEY,"\n THERE IS A DOORKEY MYSTERIOUSLY ON THE GROUND");
        vent.setDescription(description);
        connectRooms(vent, "up", engineRoom);
    }
    
    /**
     * This is a corridor
     */
    private void createCorridor()
    {
        corridor = new Room(8, "in a small connecting corridor");
        
        description = 
        "in a corridor heading towards the main ship's reactor. The path to the\n"+
        "ladders ascending to the main parts of the ship are blocked at the\n"+
        "bottom, and your only way back is to the vent or to the reactor. Steam\n"+
        "and sparks fill the corridor making movement tricky. The faint voice of\n"+
        "the ship's computer once again announces that the ship systems are failing\n"+
        "and that crew members much abandon ship immediatly";
        
        corridor.setDescription(description);
        connectRooms(corridor, "north", vent);
    }
    
    /**
     * This is the reactor of the ship
     */
    private void createReactor()
    {
        reactor = new Room(9, "in the reactor room");
        
        description = 
        "The main reaction room! where the main functions of the ship reside\n" +
        "Quickly! the airlock is east, a seemingly damage escape pod towards\n" + 
        "south and a usable escpe pod west from you. HURRY!";
        
        reactor.setDescription(description);
        connectRooms(reactor, "north", corridor);
    }
    
    /**
     * This is the airlock, descriptions are in the game class
     * play method
     */
    private void createAirlock()
    {    
        Room airlock = new Room(10, "in the ship's airlock");
        
        connectRooms(airlock, "west", reactor);
    }
    
    /**
     * This is the damaged Pod
     */
    private void createDamagedPod()
    {
        Room damagedPod = new Room(11, "in one of the two escape pods");
        description = 
        "in the second escape pod. It has been critically damaged and it's nose\n"+
        "has almost entirely been smashed off by high-speed debris. None of the\n"+
        "systems are operational - there is no chance of escape in this pod.";
        
        damagedPod.setDescription(description);
        
        connectRooms(damagedPod, "north", reactor);
    
    }
    
    /**
     * This is the primary Escape Pod
     */
    private void createEscapePod()
    {
        escapePod = new Room(12, "in ship's primary escape pod");
        
        description = 
        "in the Escape Pod. This is, by comparison to the rest of the ship,\n"+
        "is in unmarked condition and all of its systems seem to be intact.\n"+
        "Looking around, there are two pilot seats and enough extra seating\n"+
        "in the rear for 10 crew members to safely escape. You can see that\n"+
        "the computer is expecting an access key in order to engage and authorise\n"+
        "the launch sequence. You don’t have much time left. You must activate\n"+
        "take off the emergency launch switch cover";

        escapePod.setDescription(description);
        connectRooms(escapePod, "east", reactor);        
    }
    
    /**
     * This allows exits to be formed, and rooms to be connected
     */
    private void connectRooms(Room room, String direction, Room otherRoom)
    {
        room.setExit(direction, otherRoom);
        
        if(direction.equals("east"))
        {
            otherRoom.setExit("west", room);
        }
        else if(direction.equals("west"))
        {
            otherRoom.setExit("east", room);
        }
        else if(direction.equals("north"))
        {
            otherRoom.setExit("south", room);
        }
        else if(direction.equals("south"))
        {
            otherRoom.setExit("north", room);
        }
        else if(direction.equals("down"))
        {
            otherRoom.setExit("up", room);
        }
        else if(direction.equals("up"))
        {
            otherRoom.setExit("down", room);
        }        
    }
    
}
