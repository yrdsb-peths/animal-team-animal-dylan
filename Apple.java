import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    int speed = 2;
    GreenfootImage apple = new GreenfootImage("images/apple-fruit.png");
    public Apple() {
        apple.scale(45, 55);
        setImage(apple);    
    }
    
    public void act()
    {
        setLocation(getX(), getY() + speed);
        
        // to remove apple and draw game over
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd) {
        speed = spd;
    }
}
