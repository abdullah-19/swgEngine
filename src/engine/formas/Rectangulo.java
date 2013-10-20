package engine.formas;

import engine.Dibujable;
import engine.utils.Punto;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class Rectangulo extends Rectangle implements Dibujable{

    public Rectangulo(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Linea getLineaSuperior(){
        return new Linea(new Point(x,y),new Point((x+width),y));
    }
    public Linea getLineaInferior(){
        return new Linea(new Point(x,y+height),new Point((x+width),y+height));
    }
    public Linea getLineaIzquierda(){
        return new Linea(new Point(x,y),new Point(x,y+height));
    }
    public Linea getLineaDerecha(){
        return new Linea(new Point(x+width,y),new Point((x+width),y+height));      
    }

    public Punto getCentro(){
        return new Punto(x+(width/2),y+(width/2));
    }
    @Override
    public Rectangulo getBounds() {
        return this;
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawRect(x, y, width, height);
        g.drawOval((int)getCentro().x,(int)getCentro().y, 2,2);
    }

    
    

    
}
