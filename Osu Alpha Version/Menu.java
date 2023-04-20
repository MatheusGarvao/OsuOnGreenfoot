import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */

    public MusicButton1 music1;
    public MusicButton2 music2;
    
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 578, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Logo logo = new Logo();
        addObject(logo,107,107);
        logo.setLocation(160,112);
        PlayButton pb = new PlayButton();
        addObject(pb,520,112);
        CautionSign cs = new CautionSign();
        addObject(cs,520,212);
        MusicButton1 mb1 = new MusicButton1();
        addObject(mb1,320,312);
        MusicButton2 mb2 = new MusicButton2();
        addObject(mb2,735,312);
        ExitButton eb = new ExitButton();
        addObject(eb,520,412);
        music1 = mb1;
        music2 = mb2;
        TutorialButton tutorialButton = new TutorialButton();
        addObject(tutorialButton,891,67);
    }

    /*
     * primeiroBotao - Retorna o botão numero 1.
     */
    public MusicButton1 primeiroBotao(){
        return music1;
    }
    /*
     * segundoBotao - Retorna o botão numero 2.
     */
    public MusicButton2 segundoBotao(){
        return music2;
    }
}
