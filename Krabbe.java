import greenfoot.*;  // (World, Actor, GreenfootImage und Greenfoot)

/**
 * Diese Klasse definiert eine Krabbe. Krabben leben auf dem Strand.
 * Diese Klasse wurde von Michael Kolling entworfen und von mir an meinen Unterricht angepasst.
 * 
 * @author Ralph Henne
 * @version 4.8.2010
 */
public class Krabbe extends Animal
{
    /** 
     *  Tut, was auch immer Krabben gerne tun. Diese Methode wird immer dann aufgerufen,
     *  wenn die Buttons 'Act' oder 'Run' in der Entwicklungsumgebung gedrueckt werden.
     */
    
    int eatenWorm = 0;
    static boolean powerup;
    static int stern = 0;
    static int leben = 3;
    
    public void act()
    {
        turnEdge();
        keyCode();
        chaseTheWorm();
        finish();
        useStar();
    }
    
    public void randomTurn(){
        if(Greenfoot.getRandomNumber(100) < 10){
            turn(Greenfoot.getRandomNumber(45));
        }
    }
    
    public void keyCode(){
        if(Greenfoot.isKeyDown("right")){
            move();
            stern++;
        } else if(Greenfoot.isKeyDown("left")){
            move(-5);
            stern++;
        } else if(Greenfoot.isKeyDown("up")){
            turn(5);
            stern++;
        } else if(Greenfoot.isKeyDown("down")){
            turn(-5);
            stern++;
        } else if(Greenfoot.isKeyDown("up") && Greenfoot.isKeyDown("right")){
            turn(5);
            move();
        }
    }
    
    public void turnEdge(){          // Krabbe dreht sich an World Border um 17
        if(atWorldEdge()){
            turn(17);
            for(int i = 0; i < 5; i++){
                move();
            }
        }
    }
    
    public void chaseTheWorm(){
        if(canSee(Wurm.class)){
            eat(Wurm.class);
            eatenWorm++;
            Greenfoot.playSound("slurp.wav");
        }
    }
    
    public void useStar(){
        if(canSee(Stern.class)){
            eat(Stern.class);
            powerup = true;
            Stern.active();
        }
    }
    
    public void finish(){
        if(eatenWorm == 10){
            Greenfoot.stop();
        }
    }
}


