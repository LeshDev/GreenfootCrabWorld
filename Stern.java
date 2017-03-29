import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stern here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stern extends PowerUp
{
    /**
     * Act - do whatever the Stern wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static void active() 
    {
        while(Krabbe.stern < 100){
            Krabbe.powerup = true;
        }
        Krabbe.powerup = false;
    }    
}
