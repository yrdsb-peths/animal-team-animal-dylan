import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apple: The food to eat
 * 
 * @author Dylan 
 * @version May 17 2025
 */
public class Apple extends Actor
{
    int speed = 2;
    GreenfootImage apple = new GreenfootImage("images/apple-fruit.png");
    public Apple() {
        apple.scale(23, 27);
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
