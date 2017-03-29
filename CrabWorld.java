import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Erzeugt die Krabbenwelt (den Strand). Unsere Welt hat eine Groesse 
     * von 560x560 Zellen, wobei jede Zelle nur ein Pixel gross ist.
     */
    
    int rnd1;
    int rnd2;
    boolean runningGame = true;
    int rnd3 = Greenfoot.getRandomNumber(20);
    
    
    public CrabWorld() 
    {
        super(560, 560, 1);
        Greenfoot.setSpeed(40);
        createWorld();
        Greenfoot.playSound("fanfare.wav");
        //Greenfoot.showText("Score: " , 2, 2); 
    }
    
    public void createWorld() {
        addObject(new Krabbe(), 280, 280); // summon crab
        boolean runningGame = false;
        
        for(int w = 0; w < 10; w++){
            rnd1 = Greenfoot.getRandomNumber(560); // generate a random number between 0 and 560
            rnd2 = Greenfoot.getRandomNumber(560);
            addObject(new Wurm(), rnd1, rnd2); // summon 10 worms
        }
        for(int h = 0; h < 3; h++){
            rnd1 = Greenfoot.getRandomNumber(560); // generate a random number between 0 and 560
            rnd2 = Greenfoot.getRandomNumber(560);
            addObject(new Hummer(), rnd1, rnd2);
        }
        for(int s = 0; s < 1; s++){
            rnd1 = Greenfoot.getRandomNumber(560); // generate a random number between 0 and 560
            rnd2 = Greenfoot.getRandomNumber(560);
        }
        powerUpSpawn();
    }
    
    public void powerUpSpawn(){
        if(runningGame == true){
            rnd1 = Greenfoot.getRandomNumber(560); // generate a random number between 0 and 560
            rnd2 = Greenfoot.getRandomNumber(560); // generate a random number between 0 and 560
            //if(rnd3 == 10){
                addObject(new Stern(), rnd1, rnd2);
                Krabbe.stern = 0;
            //}
        }
    }
}