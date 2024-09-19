// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Snake extends Actor
{

    /**
     * Act - do whatever the Snake wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        eat();
        moveAndTurn();
        if (isTouching(Lobster.class)) {
            World world = (World)getWorld();
            int x = getX();
            int y = getY();
            world.removeObject(this);
            Lobster newLobster =  new  Lobster();
            world.addObject(newLobster, x, y);
            Greenfoot.playSound("eating.wav");
        }
    }

    /**
     * 
     */
    public void eat()
    {
        Actor lobster = getOneIntersectingObject(Lobster.class);
        if (lobster != null) {
            World world = getWorld();
            world.removeObject(lobster);
            Greenfoot.playSound("eating.wav");
        }
    }

    /**
     * 
     */
    public void moveAndTurn()
    {
        move(4);
        if (Greenfoot.isKeyDown("left")) {
            turn(3);
        }
        if (Greenfoot.isKeyDown("right")) {
            turn(-3);
        }
    }
}
