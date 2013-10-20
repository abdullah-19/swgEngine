

package test;

import engine.colisiones.Colision;
import engine.colisiones.Colisionable;
import engine.formas.Rectangulo;
import engine.input.EntradaTeclado;
import engine.sprite.AnimacionSpr;
import engine.sprite.SpriteMovil;
import engine.utils.Punto;
import engine.utils.Vector2D;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 *
 * @author Juanjo Gallardo
 */
public class MiJugador extends SpriteMovil implements Colisionable{
    private EntradaTeclado entrada;
    public MiJugador(List<AnimacionSpr> anim,Punto pos, Vector2D velocidad,EntradaTeclado entrada) {
        super(anim, pos, velocidad);
        this.entrada=entrada;

    }

    @Override
    public void alColisionar(Colision colision) {
        if(colision.getCuerpoColisionado().getClass().getSimpleName().equals("Caja")){
            Caja c = (Caja)colision.getCuerpoColisionado();
            if(colision.getTipoColisionX()==Colision.TipoColisionX.IZQUIERDA){
                c.getPos().x+=4;
            }
            if(colision.getTipoColisionX()==Colision.TipoColisionX.DERECHA){
                c.getPos().x-=4;
            }
            if(colision.getTipoColisionY()==Colision.TipoColisionY.ARRIBA){
                c.getPos().y+=5;
            }
            if(colision.getTipoColisionY()==Colision.TipoColisionY.ABAJO){
                c.getPos().y-=5;
            }           
            c.setLocation((int)c.getPos().x,(int)c.getPos().y);
        }else{

        }
    }

    @Override
    public Rectangulo getAreaColision() {
        return new Rectangulo((int)pos.x,(int)pos.y,this.anims.get(animacionActual).getImage().getWidth(null),this.anims.get(animacionActual).getImage().getHeight(null));
    }


    public void actualizar(int tiempoTranscurrido){
        this.gestionarEntradaTeclado();
        this.actualizarSprite(tiempoTranscurrido);        
        pos.x+=  (velocidad.getX() * ((float)tiempoTranscurrido/100));
        pos.y+=  (velocidad.getY() * ((float)tiempoTranscurrido/100));        
    }
    public Punto getPos() {
        return pos;
    }

    public Vector2D getVelocidad() {
        return velocidad;
    }

    public void gestionarEntradaTeclado(){
        if(entrada.estaTeclaPulsada(KeyEvent.VK_DOWN)){
            velocidad.getP2().y++;
        }
        else if(entrada.estaTeclaPulsada(KeyEvent.VK_UP)){
            velocidad.getP2().y--;
        }
        else if(entrada.estaTeclaPulsada(KeyEvent.VK_LEFT)){
            velocidad.getP2().x--;
        }   
        else if(entrada.estaTeclaPulsada(KeyEvent.VK_RIGHT)){
            velocidad.getP2().x++;
        }else{
            velocidad.setX(0);
            velocidad.setY(0);
        }
    }



}
