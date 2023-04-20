import greenfoot.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Write a description of class ClickHandlerThread here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClickHandlerThread extends Thread {
    private Osu world;
    private boolean running;
    private boolean segurandoZ;
    private boolean segurandoX;    
    GreenfootSound sound = new GreenfootSound("click.wav");

    public ClickHandlerThread(Osu world) {
        this.world = world;
        running = true;
    }

    public void run() {
        while (running) {
            if (Greenfoot.isKeyDown("z") && !segurandoZ) { 
                MouseInfo mouse = Greenfoot.getMouseInfo();
                if (mouse != null) {
                    Circulo circulo = (Circulo) world.getObjectsAt(mouse.getX(), mouse.getY(), Circulo.class).stream()
                        .filter(Circulo.class::isInstance)
                        .map(Circulo.class::cast)
                        .findFirst().orElse(null);
                    if (circulo != null) {
                        world.removeObject(circulo.borda);
                        world.removeObject(circulo);
                    }
                }
                segurandoZ = true;
            }else if(!Greenfoot.isKeyDown("z")){
                segurandoZ = false;
            }

            if (Greenfoot.isKeyDown("x") && !segurandoX) { 
                MouseInfo mouse = Greenfoot.getMouseInfo();
                if (mouse != null) {
                    Circulo circulo = (Circulo) world.getObjectsAt(mouse.getX(), mouse.getY(), Circulo.class).stream()
                        .filter(Circulo.class::isInstance)
                        .map(Circulo.class::cast)
                        .findFirst().orElse(null);
                    if (circulo != null) {
                        sound.play();
                        int pont = circulo.borda.tamanho;
                        circulo.borda.vida.contador();
                        if(pont>=55&&pont<=65){
                           System.out.println("X"+pont); 
                        }
                        // NANDIM, AQUI A PONTUAÇÃO, EU FIZ PARA O CLICK DO X, DPS Q TU ARRUMAR
                        // FAZ PARA O CLICK DO Z
                        world.removeObject(circulo.borda);
                        world.removeObject(circulo);
                    }
                }
                segurandoX = true;
            }else if(!Greenfoot.isKeyDown("x")){
                segurandoX = false;
            }
        }
    }

    public void stopThread() {
        running = false;
    }
}

