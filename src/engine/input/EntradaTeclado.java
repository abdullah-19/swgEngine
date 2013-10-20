package engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Obtiene la entrada del teclado y del ratón.
 * Utiliza las teclas definidas en KeyEvent.
 * @author Juanjo Gallardo
 */
public class EntradaTeclado implements MouseListener, KeyListener {

    List<Integer> teclasPulsadas = new ArrayList<>();
    private EntradaTeclado(){
        
    }


    public static EntradaTeclado obtenerEntradaBasica() {
        return new EntradaTeclado();
    }


    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void keyTyped(KeyEvent e) {}

    /**
     * Captura la tecla pulsada
     *
     * @param e the eventhandler opbect
     */
    public void keyPressed(KeyEvent e) {
        if(!estaTeclaPulsada(e.getKeyCode()))
            teclasPulsadas.add(e.getKeyCode());                
    }

    /**
     * Cuando una tecla se suelta
     */
    public void keyReleased(KeyEvent e) {
        if(estaTeclaPulsada(e.getKeyCode()))
            teclasPulsadas.remove(Collections.binarySearch(teclasPulsadas,e.getKeyCode()));   
    }

    public boolean estaTeclaPulsada(int tecla){
        if(Collections.binarySearch(teclasPulsadas,tecla)>=0)
            return true;
        return false;
    }
    
}