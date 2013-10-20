package engine.sprite;
import engine.Dibujable;
import engine.utils.Punto;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
/*
 * 
 */
public abstract class Sprite implements Dibujable{
    
    protected List<AnimacionSpr> anims;
    protected int animacionActual=0;
    
    protected Punto pos; //posicion del sprite.

    public Sprite(List<AnimacionSpr> anims, Punto pos) {
        this.anims = anims;
        this.pos = pos;
    }

    /**
     * Actualiza el sprite
    */
    protected void actualizarSprite(long tiempoTranscurrido){
        anims.get(animacionActual).update(tiempoTranscurrido);        
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(anims.get(animacionActual).getImage(),(int)pos.x,(int)pos.y, null);
    }
    
    
    
    /**
        Devuelve la imagen actual de la animacion.
    */
    public Image getImage() {
        return anims.get(animacionActual).getImage();
    }

    public AnimacionSpr getAnimacionActual() {
        return anims.get(animacionActual);
    }


    public Punto getPos() {
        return pos;
    }

    public void setPos(Punto pos) {
        this.pos = pos;
    }



    public List<AnimacionSpr> getAnims() {
        return anims;
    }

    
    
}