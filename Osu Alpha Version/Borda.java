import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Borda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Borda extends Actor
{
    

    Circulo circulo;
    GreenfootImage imagemBorda;
    int tamanho = 100;
    Vida vida;
    public Borda(int x, int y, Circulo circulo, Vida vida) {
        this.vida = vida;
        imagemBorda = new GreenfootImage(100, 100);
        imagemBorda.setColor(Color.GREEN);
        imagemBorda.drawOval(0, 0, 100, 100);
        setImage(imagemBorda);
        setLocation(x, y);
        this.circulo = circulo;
    }
    
    public void act(){
        tamanho--;
        if(tamanho>=50){
            imagemBorda.scale(imagemBorda.getWidth() - 1,imagemBorda.getHeight() - 1);
        }else if(tamanho<40){
            vida.diminuir();
            getWorld().removeObject(circulo);
            getWorld().removeObject(this);
        };
    }
    
}
