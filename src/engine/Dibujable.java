/*
 * Interfaz que implementarán aquellos objetos que puedan pintarse en un
 * contenedor.
 */
package engine;

import java.awt.Graphics;

/**
 *
 * @author Juanjo Gallardo
 */
public interface Dibujable {
    
    /**
     * Definirá como se dibuja el objeto.
     */
    public void dibujar(Graphics g);
}
