package test;

import engine.Juego;
import engine.colisiones.ControladorDeColisiones;
import engine.sprite.AnimacionSpr;
import engine.utils.ManejoImg;
import engine.utils.Punto;
import engine.utils.Vector2D;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase base de un juego. Implementa el GameLoop de EscenaAnimada y añade ademas la entrada
 * de teclado.
 * IMPORTANTE: Sobreescribir el metodo iniciarComponentes para iniciar nuestros componentes
 * @author Juanjo Gallardo
 */
public class MiJuego extends Juego{
    Caja c1;
    Caja c2;
    MiJugador jugador;
    ControladorDeColisiones colisiones;
    
    @Override
    protected void iniciarComponentes() {
        super.iniciarComponentes();
        c1 = new Caja(90,200,150,150);        
        c1.setVelocidad(new Vector2D(2f,2));
        c2 = new Caja(400, 200,90,90);
        c2.setVelocidad(new Vector2D(2f,2));
        
        List<AnimacionSpr> listaSpr=new ArrayList<>();
        AnimacionSpr miJugadorSpr = new AnimacionSpr();
        Image[] imgMiJugador = null;
        try {
             imgMiJugador = ManejoImg.sheetToFrames("joe_walk.png",4);
        } catch (IOException ex) {}
        for (int i = 0; i < imgMiJugador.length; i++) {
            miJugadorSpr.addFrame(imgMiJugador[i],100);
        }
        listaSpr.add(miJugadorSpr);
        
        
        
        jugador = new MiJugador(listaSpr,new Punto(300,300),new Vector2D(0,0),entrada);
        
        
        colisiones = new ControladorDeColisiones();
        colisiones.addElemento(c1);
        colisiones.addElemento(c2);
        colisiones.addElemento(jugador);
    }

    @Override
    protected void renderizar(Graphics g) {
        g.clearRect(0,0,contenedor.getWidth(),contenedor.getHeight());
        c1.dibujar(g);
        c2.dibujar(g);
        jugador.dibujar(g);
    }

    @Override
    protected void actualizar(int tiempoTrascurrido) {
    //    System.out.println(""+tiempoTrascurrido);        
        c1.actualizar(tiempoTrascurrido);
        c2.actualizar(tiempoTrascurrido);
        jugador.actualizar(tiempoTrascurrido);
        colisiones.comprobarColisiones();
    }

}
