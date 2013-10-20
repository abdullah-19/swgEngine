

package test;

import engine.Dibujable;
import engine.colisiones.Colision;
import engine.colisiones.Colisionable;
import engine.formas.Linea;
import engine.formas.Rectangulo;
import engine.utils.Punto;
import engine.utils.Vector2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Juanjo Gallardo
 */
public class Caja extends Rectangulo implements Dibujable,Colisionable{
    
 //   public static EscenaAnimada a;
    private Vector2D velocidad;
    private Punto pos;
    
    public Caja(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.pos = new Punto(x, y);
    }

    /* espacio = espacioInicial + Velocidad * tiempo;
     * x0 = x0 + v0*t; 
     * @param tiempoTranscurrido 
     */
    public void actualizar(int tiempoTranscurrido){
        pos.x+=  (velocidad.getX() * ((float)tiempoTranscurrido/100));
        pos.y+=  (velocidad.getY() * ((float)tiempoTranscurrido/100));
        this.setLocation((int)pos.x,(int)pos.y);
    }

    public Punto getPos() {
        return pos;
    }

    
    public Vector2D getVelocidad() {
        return velocidad;
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
        g.setColor(Color.red);
     //   g.drawRect(this.getBounds().x, this.getBounds().y,this.getBounds().width, this.getBounds().height);
        Rectangle r=this.getAreaColision().getLineaDerecha().getBounds(Linea.VERTICAL);
        g.drawRect(r.x, r.y, r.width, r.height);
        
    }


    public void setVelocidad(Vector2D velocidad) {
        this.velocidad=velocidad;
    }

    
    @Override
    public Rectangulo getAreaColision() {
        return this.getBounds();
    }

    @Override
    public void alColisionar(Colision colision) {
 
        
    }



}
