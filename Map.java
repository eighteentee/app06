                                                                                                                                                                    
/**
 * Write a description of class Map here.
 *
 * @author Phill Horrocks & Chris Edgley
 * @version 0.1
 */
public class Map
{
    //Lets setup the map
    private Room building;
    
    private Room start;
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
    
    // There should be 12 rooms
    
    private Room navigation;
    private Room corridor;
    private Room escapePod;
    private Room communications;
    private Room engineRoom;
    private Room medbay;
    private Room vent;
    private Room staffRoom;
    private Room electrical;
    private Room airLock;
    private Room outside;
    private Room reactor;
    
    
    
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createStart();
        createBuilding();
        createEastForest();
        createWestForest();
        createValley();
        createSlit();
        createGrate();
        createSmallChamber();
        createCobbles();
        createLargeChamber();
        createKingsHall();
        
        // createStart();
        
         createNavigation();
         createCorridor();
         createEscapePod();
         createCommunications();
         createEngineRoom();
         createMedBay();
         createVent();
         createStaffRoom();
         createElectrical();
         createAirLock();
         createOutside();
         createReactor();
        
    }
    
    public Room getStartRoom()
    {
        return start;
    }
    
    /**
     * The starting room
     */
    private void createStart()
    {
        start = new Room(0, "in the ship's navigation room");
        
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
        
        start.setOxygen();
        start.setDescription(description);
       
        
        
        // description =  
        // " standing at the end of a road before a brick \n" +
        // " building. Around you is a forest. A small stream\n" +
        // " flows out of the building and down a gully.";
        
        // start.setWater();
        // start.setDescription(description);
        // start.setItem(ItemTypes.BOTTLE, "\n There is an empty oxygen tank on the ground");
    }
    
    /**
     * The building is North of the Start and contains
     */
    private void createBuilding()
    {
        building = new Room(2, "inside Brick Building");
        
        description =  " in a well house for a large spring. ";
        
        building.setDescription(description);
        building.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    
    
    
    
    
    
    
    
    
    
    // Start room descriptions
    
    /**
     * Navigation
     */
    private void createNavigation()
    {
        navigation = new Room(1, "in the ship's navigation room");
        
        description = 
        "in the ship’s navigation room it is a scene of devastation\n"+
        "with the eerie red flashing alarm lights casting doom-filled shadows\n"+
        "off various pieces of equipment floating around the room. The ship's consoles\n"+
        "reflect this seemingly final message, informing you of your impending\n"+
        "demise. You can’t see anything of any use here.";
        
        navigation.setDescription(description);
        navigation.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Corridor
     */
    private void createCorridor()
    {
        corridor = new Room(2, "in the ship's main corridor");
        
        description = 
        "in the long corridor leading to the Escape Pod. Pipes are broken and steam\n"+
        "is gushing out everywhere making progress dangerous. Behind you lies the\n"+
        "Navigation Room and ahead your only path to survival. You hear the noises of the\n"+
        "ship coming apart, rattling in your ears. The sound of metal on metal, grinding and\n"+
        "twisting, struggling to stay together. On the floor under a fallen duct,\n"+
        "you spot a screwdriver. ";
        
        corridor.setDescription(description);
        corridor.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Escape Pod
     */
    private void createEscapePod()
    {
        escapePod = new Room(3, "in the ship's escape pod");
        
        description = 
        "in the Escape Pod. This is, by comparison to the rest of the ship,\n"+
        "is in unmarked condition and all of its systems seem to be intact.\n"+
        "Looking around, there are two pilot seats and enough extra seating\n"+
        "in the rear for 10 crew members to safely escape. You can see that\n"+
        "the computer is expecting an access key in order to engage and authorise\n"+
        "the launch sequence. You don’t have much time left. You must activate\n"+
        "the launch sequence now.";
        
        escapePod.setDescription(description);
        escapePod.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Communications
     */
    private void createCommunications()
    {
        communications = new Room(4, "in the ship's communications room");
        
        description = 
        "in the communications room it is surprisingly unaffected by the\n"+
        "catastrophic event now signalling your death. Around the room\n"+
        "there are the now familiar console warnings and flashing red\n"+
        "alarm lights. Over near the main comms console you can see a\n"+
        "terminal which looks unlike the others. ";
        
        communications.setDescription(description);
        communications.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Engine Room
     */
    private void createEngineRoom()
    {
        engineRoom = new Room(5, "in the ship's engine room");
        
        description = 
        "in the ship’s engine room. Here, the power source of the ship’s\n"+
        "propulsion system lies exposed, dangerously emitting arcs of\n"+
        "electricity between the core and the hull of the ship. Steam and\n"+
        "sparks are everywhere. There is no chance of repairing the warp\n"+
        "core as it’s too badly damaged. On the floor, you can see, among\n"+
        "other things, a pair of wire cutters. Maybe these could come in\n"+
        "handy somewhere else to aid your escape. Time is running out and\n"+
        "the warning’s are now showing ‘SYSTEMS CRITICAL’ on the engine room\n"+
        "consoles.";
        
        engineRoom.setDescription(description);
        engineRoom.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Medical Bay
     */
    private void createMedBay()
    {
        medbay = new Room(6, "in the ship's medbay");
        
        description = 
        "in the medbay, medical computers, beds and equipment are in complete\n"+
        "disarray with the rooms various cupboards and storage contents emptied\n"+
        "everywhere. Through the mess, you can spot the emergency door to the\n"+
        "engine room, which is currently open with steam and sparks emitting from\n"+
        "the broken systems that lie beyond. On top of one of the upturned beds,\n"+
        "you can just make out the top of what looks like a yellow oxygen tank.\n"+
        "In the corner, you spot a ventilation shaft but is screwed on tight.";
        
        medbay.setDescription(description);
        medbay.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Vent
     */
    private void createVent()
    {
        vent = new Room(7, "in a small ventilatin vent");
        
        description = 
        "in a vent which is just large enough to fit you. Your oxygen tank\n"+
        "clatters and scrapes perilously against the sharp jagged edges of\n"+
        "the damaged ductwork. Finally, you emerge out from the other side,\n"+
        "the feeling of claustrophobia clearing.";
        
        vent.setDescription(description);
        vent.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Staff Room
     */
    private void createStaffRoom()
    {
        staffRoom = new Room(8, "in the ship's staff room");
        
        description = 
        "in the staff room, chairs and tables are strewn around everywhere\n"+
        "making navigation difficult. There are a number of garments laying\n"+
        "around and in the corner, one in particular catches your eye, the\n"+
        "name tag reading Stark. Captain Stark’s jacket has a small piece of\n"+
        "paper sticking out of the chest pocket. The rest of the room seems\n"+
        "to contain nothing useful as you watch the timer tick down on the\n"+
        "console screen above, you decide you must act fast.";
        
        staffRoom.setDescription(description);
        staffRoom.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Electrical
     */
    private void createElectrical()
    {
        electrical = new Room(9, "in the ship's electrical room");
        
        description = 
        "in the electrical room, wires and steam currently block your path\n"+
        "back to the main ship but you see the engine room has been burst open,\n"+
        "possibly by one of your crewmates before they deserted the ship.";
        
        electrical.setDescription(description);
        electrical.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * AirLock
     */
    private void createAirLock()
    {
        airLock = new Room(10, "in the ship's airlock");
        
        description = 
        "in the ship’s airlock. The red alarm lights make entry to the airlock\n"+
        "a challenge; alternating from the depths of black to bright red, you\n"+
        "fumble for the door release. The ship is completely depressurised and\n"+
        "devoid of oxygen but the exit to the exterior of the ship is wide open.\n"+
        "Luckily, you spot the metal carabiner of the tether clasped to the inside\n"+
        "of the door. You attach the tether to your suit.";
        
        airLock.setDescription(description);
        airLock.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Outside
     */
    private void createOutside()
    {
        outside = new Room(11, "in the ship's airlock");
        
        description = 
        "outside the ship. You exit the airlock through the already open door.\n"+
        "The ship's systems must have crashed and opened it automatically. The\n"+
        "weightlessness kicks in and you feel that all-too-familiar falling\n"+
        "feeling in the pit of your stomach. It takes a lot to overcome the initial\n"+
        "wave of nausea but you push away with your feet. You traverse the exterior\n"+
        "of the ship, holding onto the grab rails and re-positioning your carabiner\n"+
        "at safe points. You eventually turn a corner and see that the side of the\n"+
        "ship has been torn open, exposing debris floating around, suspended. Ahead\n"+
        "you can see a number of the repair crew’s tools, mag-locked to the ship's\n"+
        "exterior. There is a pair of wirecutters.";
        
        outside.setDescription(description);
        outside.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    /**
     * Reactor
     */
    private void createReactor()
    {
        reactor = new Room(11, "in the ship's reactor room");
        
        description = 
        "in the ship's reactor room. You feel surprised by the fact that this area\n"+
        "of the ship seems largely unaffected by the turmoil. Up on the wall, you\n"+
        "see the large display showing that the ship's auxiliary power systems are\n"+
        "offline. There is a large lever below the display on the control console.\n"+
        "It’s red and the label shows ‘ENGAGE EMERGENCY POWER’.";
        
        reactor.setDescription(description);
        reactor.setItem(ItemTypes.KEY, "\n There are some keys on the ground here.");
        connectRooms(start, "north", building);
    }
    
    
    
    
    
    

    
    
    

    private void createEastForest()
    {
        eastForest = new Room(3, "lost in thick Forest");
        
        description =  " up a hill, still in the forest.  \n The road";
        description += " slopes back down the other side of the hill.";
        description += " \n There is a building in the distance";
        
        eastForest.setDescription(description);        
        
        //eastForest.setExit("west", start);
        //start.setExit("east", eastForest);
        connectRooms(start, "east", eastForest);        
    }
    
    private void createWestForest()
    {
        westForest = new Room(4, "lost in open Forest");
        
        description =  " in open forest, with a deep valley to one side";
        westForest.setDescription(description);        
        
        connectRooms(start, "west", westForest);
    }
    
    /**
     * 
     */
    private void createValley()
    {
        valley = new Room(5, "in a valley");
        
        description = " in a valley in the forest beside a stream";
        description += "\n tumbling along a rocky bed.";
        valley.setDescription(description);
        
        valley.setOxygen();
        valley.setItem(ItemTypes.FOOD,
            "\n There are a couple of apple trees with fruit");
            
        connectRooms(start, "south", valley);
        
        Room forest = cloneRoom(6, eastForest);
        connectRooms(valley, "east", forest);
        
        forest = cloneRoom(7, westForest);
        connectRooms(valley, "west", forest);        
    }

    private void createSlit()
    {
        slit = new Room(8, "at slit in streambed");
        
        description = "standing, at your feet all the water of the stream";
        description += " \n splashes into a 2-inch slit in the rock.  ";
        description += " \n Downstream the streambed is bare rock";
        
        slit.setDescription(description);
        slit.setOxygen();
        
        connectRooms(slit, "north", valley);
    }
    
    private void createGrate()
    {
        grate = new Room(9, "beside a grate");
        
        description = " You are in a 20-foot depression floored ";
        description += " \n with bare dirt.  Set into the dirt ";
        description += " \n is a strong steel grate. The grate is locked";

        grate.setDescription(description);
        connectRooms(grate, "north", slit);
    }
    
    private void createSmallChamber()
    {
        smallChamber = new Room(10, "in a chamber");
        
        description = "You are in a small chamber beneath a 3x3 steel";
        description.join("\ngrate to the surface.",
            "\nA low crawl over cobbles leads inward to the west.");
        
        smallChamber.setDescription(description);
        connectRooms(smallChamber, "up", grate);
    }
    
    private void createCobbles()
    {
        cobbles = new Room(10, "crawling over cobbles");
        
        description = "crawling over cobbles in a low passage.";
        description.join("\nThere is a dim light at the east end of the passage.");
        
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
        
        Room pit = new Room(11, "in a small pit");
        description = "in a small pit breathing traces of white mist. ";
        description.join("A east passage ends here except for a small crack leading on");
        pit.setDescription(description);
        
        connectRooms(pit, "west", largeChamber);
    
        Room  jumble = new Room(12, "in a jumble of rocks");
        description = "in a jumble of rocks, with cracks everywhere.";
        jumble.setDescription(description);
        
        connectRooms(jumble, "north", largeChamber);
            
    }
    
    private void createKingsHall()
    {
        kingsHall = new Room(14, "in the King's Hall");
        
        description = "You are in the Hall of the Mountain King";
        description.join("\nThe hall is filled with wisps of white mist ",
        "swaying to and fro as if alive.");
        
        kingsHall.setItem(ItemTypes.TREASURE, 
            "\n There is an old chest filled with treasure");
        
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
     * THIS IS FOR REFERENCE ONLY
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
