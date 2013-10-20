

package engine.colisiones;

/**
 *
 * @author Juanjo Gallardo
 */
public class Colision {

    public enum TipoColisionX {NULO,IZQUIERDA,DERECHA};
    public enum TipoColisionY {NULO,ARRIBA,ABAJO};
    
    private Colisionable otro; //elemento que generó la colision.
    private TipoColisionX tipoColisionX;
    private TipoColisionY tipoColisionY;

    public Colision(Colisionable otro, TipoColisionX tipoColisionX, TipoColisionY tipoColisionY){
        this.otro = otro;
        this.tipoColisionX = tipoColisionX;
        this.tipoColisionY = tipoColisionY;
    }

    public Colisionable getCuerpoColisionado() {
        return otro;
    }

    public TipoColisionX getTipoColisionX() {
        return tipoColisionX;
    }

    public TipoColisionY getTipoColisionY() {
        return tipoColisionY;
    }
    
    
}
