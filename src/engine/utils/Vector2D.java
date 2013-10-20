package engine.utils;

import engine.Dibujable;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Define un vector (usado por ejemplo para la velocidad.)
 * @author Juanjo Gallardo
 */
public class Vector2D implements Dibujable{
    private Punto p1;
    private Punto p2;

    public Vector2D(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public Vector2D(Punto p2){
        this(new Punto(0,0),p2);
    }
    
    public Vector2D(float px,float py){
        this(new Punto(0,0),new Punto(px, py));
    }

    public Punto getP1() {
        return p1;
    }

    public void setP1(Punto p1) {
        this.p1 = p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP2(Punto p2) {
        this.p2 = p2;
    }

    public void setX(float x){
        this.p2.x=(p1.x+x);
        this.p1.x=(p2.x-x);
    }
    
    public void setY(float y){
        this.p2.y=(p1.y+y);
        this.p1.y=(p2.y-y);  
    }
    
    public float getX(){
        return p2.getX()-p1.getX();
    }
    
    public float getY(){
        return p2.getY()-p1.getY();
    }   
    
    public void invertirCordenadaX(){
        p2.x*=-1;
    }
    
    public void invertirCordenadaY(){
        p2.y*=-1;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.red);
        g.drawLine((int)p1.x,(int)p1.y,(int)p2.x,(int)p2.y);
    }
}
