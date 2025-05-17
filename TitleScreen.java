import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen of the game
 * 
 * @author Dylan Tam 
 * @version May 9 2025
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 80);
    Label text = new Label("Press \"Space\" to Play", 40);
    Label controlText = new Label("Press \"a\" and \"d\" to move", 40);
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, 300, 50);
        addObject(text, 300, 145);
        prepare();
    }

    /**
     * Main world act loop: Starts game if user presses space bar
     */
    public void act() {
        if(Greenfoot.isKeyDown("space")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }    
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,300,250);
        addObject(controlText, 300, 350);
    }
}
