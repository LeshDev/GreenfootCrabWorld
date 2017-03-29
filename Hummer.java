import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hummer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hummer extends Animal
{
    /**
     * Act - do whatever the Hummer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    String death = new String("Du wurdest gefressen!");
    
    //boolean powerup = Krabbe.powerup;
    int leben = 3;
    
    public void act() 
    {
        turnEdge();
        randomTurn();
        //chaseTheCrab();
        move(7);
        hit();
    }    
    
    public void randomTurn(){
        if(Greenfoot.getRandomNumber(100) < 10){
            turn(Greenfoot.getRandomNumber(45));
        }
    }
    
    public void turnEdge(){          // Krabbe dreht sich an World Border um 17
        if(atWorldEdge()){
            turn(17);
        }
    }
    
    public void chaseTheCrab(){
        if(Krabbe.powerup == false){
            if(leben == 0){
                if(canSee(Krabbe.class)){
                    eat(Krabbe.class);
                    Greenfoot.stop();
                    Greenfoot.playSound("au.wav");
                }
            }
        }
    }
    
    public void hit(){
        int leben = 3; 
        if(canSee(Krabbe.class)){
           eat(Krabbe.class);
           Greenfoot.playSound("au.wav");
           leben--;
           getWorld().removeObjects(getWorld().getObjects(Krabbe.class));
           getWorld().addObject(new Krabbe(), 280, 280);
           if(leben == 0){
            chaseTheCrab();
           }
        }
   }
}
