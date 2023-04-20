import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicButton2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicButton2 extends Button
{
    /**
     * Act - do whatever the MusicButton2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean music2Clicked = false;
    GreenfootImage unchecked2 = new GreenfootImage("MusicSelectButton2.png");
    GreenfootImage checked2 = new GreenfootImage("SelectedMusic2.png");
    public void act()
    {
        if (isButtonClicked() && music2Clicked == false){
            setImage(checked2);
            music2Clicked = true;

            ((Menu)getWorld()).primeiroBotao().setMusic1Clicked(false);
        } else if (isButtonClicked() && music2Clicked == true){
            setImage(unchecked2);
            music2Clicked = false;
            
        }
    }
    
     /*
     * getMusic2Clicked() - Retorna se o botão 2 está ativo ou não.
     */
    public boolean getMusic2Clicked(){
        return this.music2Clicked;
    }
    
    /*
     * setMusic2Clicked() - Define se o botão 2 esta ativo ou não.
     */
    public void setMusic2Clicked(boolean music2Clicked){
        this.music2Clicked = music2Clicked;
        if(music2Clicked){
            setImage(checked2);
        }else{
            setImage(unchecked2);
        }
    }
}
