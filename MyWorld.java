import greenfoot.*;

public class MyWorld extends World {
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    
    public MyWorld() {
        super(600, 400, 1, false);
        
        // Create elephant object
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 360);
        
        // Create new label
        scoreLabel = new Label(0, 60);
        addObject(scoreLabel, 40, 40);
        
        createApple();
    }
    
    /**
     * This method ends the game, and prints "Game Over"
     */
    public void gameOver() {
        Label gameOverLabel = new Label("Game Over :(", 120);
        addObject(gameOverLabel, 300, 200);
        Greenfoot.stop();
    }
    
    /**
     * Increase score method
     */
    public void increaseScore() {
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0) {
            level += 1;
        }
    }
    
    /**
     * Creates apples at locations across the x-plane
     */
    public void createApple() {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}


