import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Write a description of class spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    /**
     * Act - do whatever the spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound sound;
    FileReader arquivo;
    BufferedReader leitor;
    String[] dados;
    private int tempo = 0;
    boolean acabou = false;
    Vida vida;
    public Spawner(GreenfootImage background, Vida vida){
        this.vida = vida;
        GreenfootImage image = new GreenfootImage(50, 50);
        image.setTransparency(0);
        setImage(image);
        try{
            if (Configuracoes.opMusica == 2){
            arquivo = new FileReader("maps/musica 2.txt");
            sound = new GreenfootSound("musica 2.mp3"); 
        } else {
            arquivo = new FileReader("maps/musica 1.txt");
            sound = new GreenfootSound("musica 1.mp3");
        }
            leitor = new BufferedReader(arquivo);
            dados = leitor.readLine().split(",");
        } catch (IOException e){
            GreenfootImage error = new GreenfootImage("NÃO ACHOU A MÚSICA",20,Color.BLACK,Color.WHITE);
            background.drawImage(error,getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
        sound.play();
    }

    public void act(){  
        tempo++;
        if(tempo>=Integer.parseInt(dados[3])){
            criarCirculo();
            tempo = 0;
        }
        if(acabou){
            getWorld().removeObject(this);
        }
    }

    private void criarCirculo(){
        try{
            String linha = leitor.readLine();
            if (linha!=null){
                dados = linha.split(",");
            } else {
                acabou = true;
            }
        } catch(IOException e){
            acabou = true;  
        }
        if (dados != null && dados.length == 4 && !acabou) {
            Circulo circulo = new Circulo(dados[0],Integer.parseInt(dados[1]),Integer.parseInt(dados[2]),getWorld(),vida);
            getWorld().addObject(circulo,Integer.parseInt(dados[1]),Integer.parseInt(dados[2]));
        }
    }
}
