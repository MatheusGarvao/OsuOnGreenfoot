import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circulo extends Actor
{
    private GreenfootImage imagemCirculo;
    private GreenfootImage imagemBorda;
    public Borda borda;

    public Circulo(String numero, int x, int y,World osu,Vida vida) {
        GreenfootImage imagemCirculo = new GreenfootImage(50, 50);
        imagemCirculo.setColor(Color.RED);
        imagemCirculo.fillOval(0, 0, 50, 50);
        setImage(imagemCirculo);
        
        borda = new Borda(x, y,this,vida);
        osu.addObject(borda, x, y);
        
        imagemCirculo.setColor(Color.WHITE);
        imagemCirculo.drawString(numero, 20, 30);
    }
 
}
