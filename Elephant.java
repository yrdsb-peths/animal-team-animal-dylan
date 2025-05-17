import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero.
 * 
 * @author Dylan Tam 
 * @version Apr. 2025
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephant sound.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[17];
    GreenfootImage[] idleLeft = new GreenfootImage[17];
    
    //Directs the elephant to the right
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor of an elephant
     */
    
    public Elephant() {
        for(int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("images/elephant_gif_animation/idle" + i + ".png");
            idleRight[i].scale(80, 75);
        }
        
        for(int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_gif_animation/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(80, 75);
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    }
    
    /*
     * Elephant animation method
     */
    int imageIndex = 0;
    public void animateElephant() {
        if(animationTimer.millisElapsed() < 110)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right")) {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        } else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("a")) {
            move(-3);
            facing = "left";
        } else if(Greenfoot.isKeyDown("d")) {
            move(3);
            facing = "right";
        }
        eat();
        
        animateElephant();
    }
    
    public void eat() {
        if(isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            
            elephantSound.setVolume(50);
            elephantSound.play();
        }
    }
}
