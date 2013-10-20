package test;





import engine.ContenedorBasico;

/**
 *
 * @author x0001
 */
public class MotorJuego {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        MiJuego j = new MiJuego();
        ContenedorBasico miContenedor = new ContenedorBasico(j);
        j.iniciar();
    }
}
