/*
 *  Interfaz que implementaran aquellos objetos que pueden colisionar.
 * 
 */
package engine.colisiones;

import engine.formas.Rectangulo;
import java.awt.Rectangle;

/**
 *
 * @author Juanjo Gallardo
 */
public interface Colisionable{
    
    /**
     * Se lanza cuando un cuerpo colisiona con otro.
     * Define lo que hará el cuerpo al colisionar.
     * 
     * @param cuerpoColisionado Cuerpo con el objeto ha colisionado.
     */
    public void alColisionar(Colision colision);
    
    /**
     * Devuelve el area que otro objeto debe invadir para que se detecte
     * una colision.
     * 
     * @return Shape que representa el area de colision del objeto
     *          (Rectangle,polygon...)
     */
    public Rectangulo getAreaColision();
        
    
    
}
