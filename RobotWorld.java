import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @Ryan Bishop (your name) 
 * @3-30-21 (a version number or a date)
 */
public class RobotWorld extends World
{

    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        addObject(new Robot(),29, 49); 
        
        addObject( new Wall(), 53, 173); 
        addObject( new Wall(), 160, 173); 
        addObject( new Wall(), 223, 173); 
        addObject( new Wall(), 330, 173); 
        addObject( new Wall(), 750, 173);
        addObject( new Wall(), 700, 173); 
        addObject( new Wall(), 650, 173); 
        
        addObject(new Block(),489, 173); 
        
        addObject(new Home(), 735, 526);
        
        addObject(new ScorePanel(), 78, 556);
        
        addObject(new Pizza(), 78, 400);
        addObject(new Pizza(), 150, 300);
        addObject(new Pizza(), 300, 400);
        addObject(new Pizza(), 400, 470);
        addObject(new Pizza(), 500, 500);
    }
    
}
