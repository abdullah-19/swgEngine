

package engine;

import engine.input.EntradaTeclado;

/**
 * Clase base de un juego (Escena animada con gestion de entrada del usuario)
 * @author Juanjo Gallardo
 */
public abstract class Juego extends EscenaAnimada{

    protected EntradaTeclado entrada; 
    public Juego() {
        super();
    }
    
    protected void iniciarComponentes(){
        entrada= EntradaTeclado.obtenerEntradaBasica();   
        contenedor.getVentana().addKeyListener(entrada);
    }
}
