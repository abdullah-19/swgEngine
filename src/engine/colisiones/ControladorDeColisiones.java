package engine.colisiones;

import engine.colisiones.Colision.TipoColisionX;
import engine.colisiones.Colision.TipoColisionY;
import engine.formas.Linea;
import engine.formas.Rectangulo;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Comprueba las colisiones de los elementos de la lista y efectua sus acciones.
 * Solo rectangulos de momento...
 * @author Juanjo Gallardo
 */
public class ControladorDeColisiones {

    private List<Colisionable> objetos;

    public ControladorDeColisiones(List<Colisionable> objetos) {
        this.objetos = objetos;
    }

    
    public ControladorDeColisiones() {
        this.objetos = new LinkedList<>();
    }
    
    public void comprobarColisiones(){
        Iterator it = objetos.iterator();
        Colisionable e1,otro;
        while(it.hasNext()){
            e1 = (Colisionable)it.next();
            Iterator it2 = objetos.iterator();
            while(it2.hasNext()){
                otro = (Colisionable)it2.next();
                if(comprobarColision(e1, otro)){
                    e1.alColisionar(new Colision(otro,procesarOrigenColisionX(e1,otro),
                                        procesarOrigenColisionY(e1, otro)));     
                }
            }
        }
    }
    
    public boolean comprobarColision(Colisionable obj1, Colisionable obj2){
        if(obj1==obj2)
            return false;           
       if(obj1.getAreaColision().intersects((Rectangle)obj2.getAreaColision())){
           return true;
       } 
       return false;

    }
    /**
     * Calcula el tipo de colision del elemento 1 respecto al elemento 2 en el eje X.
     * 
     * @param e1
     * @param e2
     * @return 
     */
    private TipoColisionX procesarOrigenColisionX(Colisionable e1,Colisionable e2){
        Rectangulo areaE1 = e1.getAreaColision();
        Rectangulo areaE2 = e2.getAreaColision();       
        if(areaE1.intersects(areaE2.getLineaIzquierda().getBounds(Linea.VERTICAL)))
            return TipoColisionX.IZQUIERDA;        
        if(areaE1.intersects(areaE2.getLineaDerecha().getBounds(Linea.VERTICAL)))
            return TipoColisionX.DERECHA;        
        return TipoColisionX.NULO;

    }

/**
     * Calcula el tipo de colision del elemento 1 respecto al elemento 2 en el eje X.
     * 
     * @param e1
     * @param e2
     * @return 
     */
    private TipoColisionY procesarOrigenColisionY(Colisionable e1,Colisionable e2){
        Rectangulo areaE1 = e1.getAreaColision();
        Rectangulo areaE2 = e2.getAreaColision();
        if(areaE1.intersects(areaE2.getLineaSuperior().getBounds(Linea.HORIZONTAL)))
            return TipoColisionY.ARRIBA;
        if(areaE1.intersects(areaE2.getLineaInferior().getBounds(Linea.HORIZONTAL)))
            return TipoColisionY.ABAJO;      
        return TipoColisionY.NULO;       
    }    
    
    public void addElemento(Colisionable elemento){
        this.objetos.add(elemento);
    }
    
    public void addElementos(List<Colisionable> nuevosElementos){
        this.objetos.addAll(nuevosElementos);
    }
    
    public void eliminarElemento(Colisionable elemento){
        this.objetos.remove(elemento);
    }

    public void setElementos(List<Colisionable> elementos) {
        this.objetos = elementos;
    }

    
    public List<Colisionable> getElementos() {
        return objetos;
    }
    

    
}
