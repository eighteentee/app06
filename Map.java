
                                                                                                                                                                   
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    private Room start;
    private Room building;   
    private Room eastForest;
    private Room westForest;
    private Room valley;
    private Room slit;
    private Room grate;
    private Room smallChamber;
    private Room cobbles;
    private Room largeChamber;
    private Room kingsHall;
    
    private String description;
    
    //private Room start;
    //private Room navigation;
    //private Room electrical;
    //private Room mobileServicing;
    //private Room communications;
    //private Room medbay;
    //private Room engineRoom;
    //private Room vent;
    //private Room corridor;
    //private Room reactor; // generates airlock and damaged pod
    //private Room escapePod;
    
    
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createStart(); // 0
        createBuilding(); // 1
        createEastForest(); // 2
        createWestForest(); // 3
        createValley(); // 4
        createSlit(); // 5
        createGrate(); // 6
        createSmallChamber(); // 7
        createCobbles(); // 8
        createLargeChamber(); // 9
        createKingsHall(); // 10
        
        //createStart();
        //createNavigation();
        //createElectrical();
        //createMobileServicing;
        //createComms;
        //createEngineRoom;
        //createVent;
        //createCorridor;
        //createReactor;
        //createEscapePod;
                
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
        start = new Room(0, " inside the ship's navigation room");

        description =  
        "You awake, groggily, your vision blurred, eyes rolling around.\n"+
        "The piercing wailing of the ship’s alarm system is bringing you round\n"+
        "faster than your concussion would like. “WARNING: HULL BREACH. WARNING:\n"+
        "HULL BREACH. LIFE SUPPORT SYSTEMS CRITICAL. APPROXIMATE TIME TO OXYGEN\n"+
        "DEPLETION 3 MINUTES”. Your eyes make out the flashing of the alarm\n"+
        "lights and the warning messages flashing on the ship’s main console.\n"+
        "There is a clock on the console, counting down the minutes. You pick\n"+
        "yourself up and manage to stagger to the ship’s console and turn off the\n"+
        "cacophonous noise of the alarm. Slowly, eye’s still going in and out of focus,\n"+
        "you bring up the ship’s schematic and damage report on the computer.\n"+
        "The damage report states that the ship's quarters have sustained critical damage\n"+
        "and no life forms are being reported. Your crew is gone. Just then, your suit\n"+
        "reports a critical oxygen leak - your oxygen tank has taken damage and is losing\n"+
        "pressure fast. The suit damage report states you have less than 2 minutes of\n"+
        "oxygen remaining. You realise you don’t have enough oxygen to make it to the escape\n"+
        "pod in time, unless of course you can find replacement oxygen… and fast.\n"+
        "Your only way out is north to the navigation room. In the corner is an empty\n"+
        "oxygen tank";
        
        start.setWater();
        start.setDescription(description);
        start.setItem(ItemTypes.BOTTLE, "\n There is an empty oxygen tank lying in the corner");
    }
    
    /**
     * The building is North of the Start and contains
     * important items that need to be picked up
     */
    private void createBuilding()
    {
        building = new Room(2, "inside the staff room");
        
        description = 
        "in the staff room, chairs and tables are strewn around everywhere\n"+
        "making navigation difficult. There are a number of garments laying\n"+
        "around and in the corner, one in particular catches your eye, the\n"+
        "name tag reading Stark. Captain Stark’s jacket has a small piece of\n"+
        "paper sticking out of the chest pocket. The rest of the room seems\n"+
        "to contain nothing useful as you watch the timer tick down on the\n"+
        "console screen above, you decide you must act fast.";
        
        building.setDescription(description);
        building.setItem(ItemTypes.KEY, "\n There is an escape pod launch code card here.");
        connectRooms(start, "north", building);
    }

    private void createEastForest()
    {
        eastForest = new Room(3, "in the ship's main electrical room.");
        
        description = 
        "in the electrical room, wires and steam currently block your path\n"+
        "back to the main ship but you see the engine room has been burst open,\n"+
        "possibly by one of your crewmates before they deserted the ship.";
        
        eastForest.setDescription(description);        

        connectRooms(start, "east", eastForest);        
    }
    
    private void createWestForest()
    {
       westForest = new Room(4, "in the ship's mobile service system.");
        
       description =  
       "in the Mobile Service System, normally, this is a dedicated area for\n"+
       "launching satellites into orbit or repairing damaged space vehicles.\n"+
       "Now, the arm which normally does this is broken and laying on its side\n"+
       "with its main manipulator torn off. There is nothing of use here";
       
       westForest.setDescription(description);        
        
       connectRooms(start, "west", westForest);
    }
    
    /**
     * 
     */
    private void createValley()
    {
        valley = new Room(5, "in the ship's communications room");
        
        description = 
        "in the communications room it is surprisingly unaffected by the\n"+
        "catastrophic event now signalling your death. Around the room\n"+
        "there are the now familiar console warnings and flashing red\n"+
        "alarm lights. Over near the main comms console you can see a\n"+
        "terminal which looks unlike the others. ";
        
        valley.setDescription(description);
        
        valley.setWater();
        valley.setItem(ItemTypes.FOOD, 
            "\n There are a couple of apple trees with fruit");
            
        connectRooms(start, "south", valley);
        
        // These are not really used in our map and cannot be duplicated
        //Room forest = cloneRoom(6, eastForest); // make a copy of the forest
        //connectRooms(valley, "east", forest);
        
        //forest = cloneRoom(7, westForest); // make a copy of the forest
        //connectRooms(valley, "west", forest);        
    }

    private void createSlit()
    {
        slit = new Room(8, "in the ship's medical bay");
        
        description = 
        "in the medbay, medical computers, beds and equipment are in complete\n"+
        "disarray with the rooms various cupboards and storage contents emptied\n"+
        "everywhere. Through the mess, you can spot the emergency door to the\n"+
        "engine room, which is currently open with steam and sparks emitting from\n"+
        "the broken systems that lie beyond. On top of one of the upturned beds,\n"+
        "you can just make out the top of what looks like a yellow oxygen tank.\n"+
        "On the floor you spot an oxygen hose";
        
        // use the oxygen hose to fill the oxygen tank
        
        slit.setDescription(description);
        slit.setWater();
        
        connectRooms(slit, "north", valley);
    }
    
    private void createGrate()
    {
        grate = new Room(9, "in the ship's engine room");
        
        // TODO: Need to put the passkey for this door 
        
        description = 
        "in the ship’s engine room. Here, the power source of the ship’s\n"+
        "propulsion system lies exposed, dangerously emitting arcs of\n"+
        "electricity between the core and the hull of the ship. Steam and\n"+
        "sparks are everywhere. There is no chance of repairing the warp\n"+
        "core as it’s too badly damaged. Time is running out and the warnings\n"+
        "are now showing ‘SYSTEMS CRITICAL’ on the engine room consoles...\n"+
        "There is a door marked 'Emergency Escape This Way' but the door which\n"+
        "which is normally open has been security locked and the door control\n"+
        "is asking for a passkey... Beyond the door you can see ladders\n"+
        "descending into the darkness...";

        grate.setDescription(description);
        connectRooms(grate, "north", slit);
    }
    
    private void createSmallChamber()
    {
        smallChamber = new Room(10, "in a ventillation shaft");
        
        description = 
        "descending the ladders, you pathway is blocked and your only way\n"+
        "out is to go through a small ventillation shaft just behind you.\n"+
        "The shaft is claustrophic and the oxygen tank rattles and scrapes\n"+
        "its way along with you. Up ahead you can make out flashing red\n"+
        "alarm lights again";
        
        smallChamber.setDescription(description);
        connectRooms(smallChamber, "up", grate);
    }
    
    private void createCobbles()
    {
        cobbles = new Room(10, "in a small connecting corridor");
        
        description = 
        "in a corridor heading towards the main ship's reactor. The path to the\n"+
        "ladders ascending to the main parts of the ship are blocked at the\n"+
        "bottom, and your only way back is to the vent or to the reactor. Steam\n"+
        "and sparks fill the corridor making movement tricky. The faint voice of\n"+
        "the ship's computer once again announces that the ship systems are failing\n"+
        "and that crew members much abandon ship immediatly";
        
        
        cobbles.setDescription(description);
        connectRooms(cobbles, "west", smallChamber);
    }
    
    private void createLargeChamber()
    {
        largeChamber = new Room(10, "in a large chamber");
        
        description = "in a splendid chamber thirty feet high.";
        description.join("\nThe walls are frozen rivers of orange stone. ",
            "There are passages off in all directions.");
        
        largeChamber.setDescription(description);
        connectRooms(largeChamber, "west", cobbles);
        
        
        // Create the extra rooms off the main reactor room
        Room pit = new Room(11, "in the ship's airlock");
        description = 
        "You enter the ships airlock. Normally this is a safe area. However,\n"+
        "the ship's systems have been badly damaged and you find that the door\n"+
        "closes behind you. You press and press the control panel but it does\n"+
        "not respond. You cannot get back in. Your oxygen depletes and you die\n"+
        "a slow, cold agonising a death trapped in the airlock";
        
        pit.setDescription(description);
        
        connectRooms(pit, "west", largeChamber);
    
        Room  jumble = new Room(12, "in one of the two escape pods");
        description = 
        "in the second escape pod. It has been critically damaged and it's nose\n"+
        "has almost entirely been smashed off by high-speed debris. None of the\n"+
        "systems are operational - there is no chance of escape in this pod.";
        
        jumble.setDescription(description);
        
        connectRooms(jumble, "north", largeChamber);
        
        // Room  rocks = new Room(13, "in a large room");
        // description = "You are in a large room full of dusty rocks. ";
        // description.join("There are cracks everywhere.");
        // rocks.setDescription(description);
        
        // connectRooms(rocks, "south", largeChamber);        
    }
    
    private void createKingsHall()
    {
        kingsHall = new Room(14, "in ship's primary escape pod");
        
        description = 
        "in the Escape Pod. This is, by comparison to the rest of the ship,\n"+
        "is in unmarked condition and all of its systems seem to be intact.\n"+
        "Looking around, there are two pilot seats and enough extra seating\n"+
        "in the rear for 10 crew members to safely escape. You can see that\n"+
        "the computer is expecting an access key in order to engage and authorise\n"+
        "the launch sequence. You don’t have much time left. You must activate\n"+
        "take off the emergency launch switch cover";
        
        kingsHall.setItem(ItemTypes.TREASURE, 
            "\n the console has a large switch with a cover that needs taking off");
        
        kingsHall.setDescription(description);
        connectRooms(kingsHall, "south", largeChamber);        
    }
    
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
    
    private Room cloneRoom(int id, Room toClone)
    {
        Room room = new Room(id, toClone.getName());
        room.setDescription(toClone.getDescription());

        return room;
    }
    
    /**
     * Create all the rooms and link their exits together.
     * and return the current room for the player to start
     */
    public Room createTestRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room(1, " outside the main entrance of the university");
        theater = new Room(2, " in a lecture theater");
        pub = new Room(3, " in the campus pub");
        lab = new Room(4, " in a computing lab");
        office = new Room(5, " in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        return outside;  // start game outside
    }
}
