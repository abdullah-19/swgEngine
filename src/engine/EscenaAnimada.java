
package engine;

import engine.input.EntradaTeclado;
import java.awt.Graphics;

/**
 *
 * @author Juanjo Gallardo
 */
public abstract class EscenaAnimada implements Runnable{
    
    protected volatile Thread hiloPrincipal;

    protected static int FRAMES_POR_SEGUNDO=50; //en ms
    protected ContenedorBasico contenedor; //contenedor que usará la animacion para visualizarse
    
    protected static Boolean enMarcha; //Indica si el animacion está en funcionamiento o no.
    
    /**
     * Se llama al llamar al metodo iniciar() por primera vez
     */
    protected abstract void iniciarComponentes();

    /**
     * Actualiza los elementos del animacion.
     *  Se llama constantemente en el ciclo de animacion
     * @param tiempoTranscurrido milisegundos transcurridos desde la ultima vez que se llamo al metodo
     */
    protected abstract void actualizar(int tiempoTranscurrido);
    /**
     * Dibuja los elementos del animacion en nuestro contenedor
     *  Se llama constantemente en el ciclo de animacion
     * @param g Objeto grafico sobre el que pintaremos.
     */
    protected abstract void renderizar(Graphics g);    
    
    /**
     * Inicia el ciclo de animacion y ejectua iniciarComponentes() la primera vez.
     */
    public void iniciar(){
        hiloPrincipal = new Thread(this);
        hiloPrincipal.start();
    }
    /**
     * Termina la animacion.
     */
    public void parar(){
        enMarcha=false;
    }

    @Override
    public void run() {
        if(enMarcha==null){
            iniciarComponentes();
            enMarcha=true;
        }            
        contenedor.hacerVisible(true);
        int tiempoFinal = 0;
        while(enMarcha){          
            try {      
                long tiempoAntes = System.currentTimeMillis();
                actualizar(tiempoFinal); //actualizar
                contenedor.repaint(); //pintar   
                long tiempoDespues =System.currentTimeMillis()-tiempoAntes;
                if(tiempoDespues<1000/FRAMES_POR_SEGUNDO){
                    Thread.sleep((1000/FRAMES_POR_SEGUNDO)-tiempoDespues); //esperar
                }
                //tiempo desde que se llamo a actualizar
                tiempoFinal = (int)(System.currentTimeMillis()-tiempoAntes); 
            } catch (InterruptedException ex) {}
        }
    }

    public void setContenedor(ContenedorBasico contenedor) {
        this.contenedor = contenedor;
    }

    public static void setFPS(int numFPS) {
        EscenaAnimada.FRAMES_POR_SEGUNDO = numFPS;
    }

    
    
    
    
            
}
