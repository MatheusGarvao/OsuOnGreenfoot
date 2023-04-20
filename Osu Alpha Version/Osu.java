import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Osu
 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private ClickHandlerThread clickThread;
    Boolean holdingDown;
    int spawn = 0;
    int opMusica = 0;
    boolean musicaTocando = false;
    Vida vida;
    public Osu(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 578, 1); 
        GreenfootImage background = new GreenfootImage("osu.png");
        setBackground(background);
        instanciarThreads();
        vida = new Vida();
        addObject(vida, 260, 10);
    }
    
    public void act(){
        if(!musicaTocando){
         musicaTocando = true;
         GreenfootImage background = new GreenfootImage("osu.png");
         Spawner spawner = new Spawner(background,vida);
         addObject(spawner, 0, 0);
        }
    }
        
    public void instanciarThreads(){
        clickThread = new ClickHandlerThread(this);
        clickThread.start();      
    }
    
    public void stopped() {
        clickThread.stopThread();  
    }
    
    public int getOpMusica(){
        return this.opMusica;
    }
}

