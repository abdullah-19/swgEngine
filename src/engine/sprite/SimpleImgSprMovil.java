

package engine.sprite;

import engine.utils.Punto;
import engine.utils.Vector2D;
import java.awt.Image;

/**
 * Sprite Simple formado por una sola imagen con la capacidad de moverse
 * @author Juanjo Gallardo
 */
public abstract class SimpleImgSprMovil extends SimpleImgSpr{

    protected Vector2D velocidad;
    
    public SimpleImgSprMovil(Punto pos,Vector2D v, Image img) {
        super(pos, img);
        velocidad=v;
    }
    
    public Vector2D getVelocidad() {
        return velocidad;
    }
 
}
