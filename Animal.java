import greenfoot.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Animal. Dies ist die Basisklasse fuer alle Tiere. Zusaetzlich zu den Standardmethoden 
 * der Actor-Klasse verleiht sie die Faehigkeit, sich zu bewegen und zu drehen.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Animal extends Actor
{
    private static final double WALKING_SPEED = 5.0;
    
    /**
     * Konstruktor fuer Animal - ohne Aufgabe.
     */
    public Animal()
    {
    }

    /**
     * Leere Methode. Tiere verfuegen ueber keine Standardaktionen.
     */
    public void act()
    {
    }
    
    
    /**
     * Dreht 'angle' Grad nach rechts (im Uhrzeigersinn).
     */
    public void turn(int angle)
    {
        setRotation(getRotation() + angle);
    }
    

    /**
     * Rueckt vorwaerts in die aktuelle Richtung.
     */
    public void move()
    {
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * WALKING_SPEED);
        int y = (int) Math.round(getY() + Math.sin(angle) * WALKING_SPEED);
        
        setLocation(x, y);
    }

    
    /**
     * Prueft, ob wir nahe an einem der Ränder der Welt sind. Liefert true zurueck, wenn ja.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    
    
    /**
     * Liefert true zurueck, wenn wir genau dort, wo wir sind, ein Objekt der Klasse 'clss' sehen. 
     * False, wenn dort kein solches Objekt vorhanden ist.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    
    /**
     * Versucht, ein Objekt der Klasse 'clss' zu fressen. Dies ist nur erfolgreich, wenn dort,
     * wo wir gerade sind, ein solches Objekt vorhanden ist. Andernfalls macht diese Methode
     * nichts.
     */
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
}