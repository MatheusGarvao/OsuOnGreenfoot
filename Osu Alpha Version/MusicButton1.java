import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicButton1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicButton1 extends Button
{
    /**
     * Act - do whatever the MusicButton1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean music1Clicked = false;
    GreenfootImage unchecked = new GreenfootImage("MusicSelectButton.png");
    GreenfootImage checked = new GreenfootImage("SelectedMusic1.png");
    public void act()
    {
        if (isButtonClicked() && music1Clicked == false){
            setImage(checked);
            music1Clicked = true;
            ((Menu)getWorld()).segundoBotao().setMusic2Clicked(false);
        } else if (isButtonClicked() && music1Clicked == true){
            setImage(unchecked);
            music1Clicked = false;
           
        }
    }
    
    /*
     * getMusic1Clicked() - Retorna se o botão 1 está ativo ou não.
     */
    public boolean getMusic1Clicked(){
        return this.music1Clicked;
    }
    
    /*
     * setMusic1Clicked() - Define se o botão 1 esta ativo ou não.
     */
    public void setMusic1Clicked(boolean music1Clicked){
        this.music1Clicked = music1Clicked;
        if(music1Clicked){
            setImage(checked);
        }else{
            setImage(unchecked);
        }
    }
}
