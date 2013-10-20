package engine.sprite;

import engine.utils.Punto;
import engine.utils.Vector2D;
import java.util.List;

public abstract class SpriteMovil extends Sprite{

    protected Vector2D velocidad; //velocidad del sprite.

    public SpriteMovil(List<AnimacionSpr> anims,Punto pos,Vector2D velocidad) {
        super(anims, pos);
        this.velocidad = velocidad;
    }
    public SpriteMovil(Sprite s,Vector2D velocidad){
        this(s.getAnims(),s.getPos(),velocidad);
    }

    
    public Vector2D getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Vector2D velocidad) {
        this.velocidad = velocidad;
    }
    
    
}

