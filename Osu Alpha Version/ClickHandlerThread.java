import greenfoot.*;
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
    int pontuacao;
    static int vezesMuitoCedo;
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
                        if(circulo.borda.tamanho >= 55 && circulo.borda.tamanho <= 65){
                           pontuacao += 300;
                        } else if (circulo.borda.tamanho > 65 && circulo.borda.tamanho < 75){
                            pontuacao += 100;
                        } else if (circulo.borda.tamanho > 75 && circulo.borda.tamanho < 85){
                            pontuacao += 50;
                        } else {
                            vezesMuitoCedo++;
                        }
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
                        if(circulo.borda.tamanho >= 55 && circulo.borda.tamanho <= 65){
                           pontuacao += 300;
                        } else if (circulo.borda.tamanho > 65 && circulo.borda.tamanho < 75){
                            pontuacao += 100;
                        } else if (circulo.borda.tamanho > 75 && circulo.borda.tamanho < 85){
                            pontuacao += 50;
                        } else {
                            vezesMuitoCedo++;
                        }
                        world.removeObject(circulo.borda);
                        world.removeObject(circulo);
                    }
                }
                segurandoX = true;
            }else if(!Greenfoot.isKeyDown("x")){
                segurandoX = false;
            }
            
            if (vezesMuitoCedo == 3){
                // aqui vai ter o método de reduzir vida
                vezesMuitoCedo = 0;
            }
        }
    }

    public void stopThread() {
        running = false;
    }
}

