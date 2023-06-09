import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Actor
{
    /**
     * Act - do whatever the Vida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage vida100 = new GreenfootImage("vida100.png");
    GreenfootImage vida75 = new GreenfootImage("vida75.png");
    GreenfootImage vida50 = new GreenfootImage("vida50.png");
    GreenfootImage vida25 = new GreenfootImage("vida25.png");
    GreenfootImage vida0 = new GreenfootImage("vida0.png");
    int saude = 100;
    public Vida(){
        setImage(vida100);
    }
    
    public Vida(int saude){
        this.saude = saude;
        setarImagem();
    }
    
    
    public void setarImagem(){
        switch(saude){
                case(100):
                setImage(vida100);
                case(75):
                setImage(vida75);
                case(50):
                setImage(vida50);
                case(25):
                setImage(vida25);
                case(0):
                setImage(vida0);
        }
        if(saude==0){
            //implementar tela de perda
        }
    }
    public void diminuir(){
        saude -=25;
        setarImagem();
    }
    
    public int getSaude(){
        return this.saude;
    }
    
}
