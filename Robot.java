import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    public Robot()
    {
        image1=new GreenfootImage("man01.png");
        image2=new GreenfootImage("man02.png");
        setImage(image1);
        image3= new GreenfootImage("gameover.png");
    }
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        robotMovement();
        detectWallCollision();
        detectBlockCollision();
        eatPizza();
        animate();
        PizzaEaten();
        removeLive();
        
    }   
    
    //robot movement keys 
    public void robotMovement()
    {
       if(Greenfoot.isKeyDown("up")) 
       {
           setLocation(getX(), getY()-3);
       }
       if(Greenfoot.isKeyDown("down")) 
       {
           setLocation(getX(), getY()+3);
       }
       if(Greenfoot.isKeyDown("right")) 
       {
           setLocation(getX()+3, getY());
       }
       if(Greenfoot.isKeyDown("left")) 
       {
           setLocation(getX()-3, getY());
       }
    }
    
    //touching wall so tyou don't go through
    public void detectWallCollision()
    {
        if(isTouching(Wall.class))
        {
            setLocation(29,49);
            Greenfoot.playSound("hurt.wav");
            
        }
    }
    
    //touching block go back to start 
    public void detectBlockCollision()
    {
        if(isTouching(Block.class))
        {
            setLocation(29,49);
            Greenfoot.playSound("hurt.wav");
            
        }
    }
    
    //sends you back to the start 
    //score increesed every time robot goes home
    public void detectHome()
    {
        if(isTouching(Home.class))
        {
                Greenfoot.playSound("yipee.wav");
                setLocation(29,49);
                score++;
                pizzaEaten=0;
        }
    }
    
    //check if pizza is being touched 
    public void eatPizza()
    {
        if (isTouching(Pizza.class))
        {
            Greenfoot.playSound("eat.wav");
            removeTouching(Pizza.class); 
            pizzaEaten++;
        }
    }
       
    public void animate()
    {
        if (getImage()==image1)
        {
            setImage(image2);
        }
        else 
        {
            setImage(image1);
        }
        robotMovement();
    }
    
    //tells how many pizzas are eaten 
    public void PizzaEaten()
    {
        if(pizzaEaten==5)
        {
            detectHome();
            
        }
    }
    
    //removes a life if touches wall or block 
    public void removeLive()
    {
        if (isTouching(Wall.class))
        {
            Lives = Lives-1;
        }
        if(isTouching(Block.class))
        {
            Lives = Lives-1;
        }
        if(Lives==0)
        {
            Greenfoot.stop();
            setImage(image3);
        }
    }
    
    //score isincreesed every time robot goes home 
   
    
    private int Lives = 3;
    private int score=0; 
    private int pizzaEaten=0;   
    
}
  
