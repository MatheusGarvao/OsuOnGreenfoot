import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Button
{
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int c = 0;
    public void act()
    {
        if(isButtonClicked()){
            if (isPlayable() == true){
            qualMusica();
            Greenfoot.setWorld(new Osu());
        } else {
            ErrorCaution errorCaution = new ErrorCaution();
            getWorld().addObject(errorCaution,531,551);
            Greenfoot.delay(250);
            getWorld().removeObject(errorCaution);
        }
        }
    }
     
    /*
     * isPlayable - Identifica se é possível começar o jogo ao clicar em play ou não.
     */
    public boolean isPlayable(){
        if (((Menu)getWorld()).segundoBotao().getMusic2Clicked() == false && ((Menu)getWorld()).primeiroBotao().getMusic1Clicked() == false){
            return false;
        } else {
            return true;
        }
    }
    
    public void qualMusica(){
        if (((Menu)getWorld()).primeiroBotao().getMusic1Clicked() == true){
            Configuracoes.opMusica = 1;
        } else {
            Configuracoes.opMusica = 2;
        }
    }
}
