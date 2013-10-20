package engine.sprite;
import engine.Dibujable;
import engine.utils.Punto;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Un sprite simple formado por una imagen en un punto.
 * @author Juanjo Gallardo
 */
public abstract class SimpleImgSpr implements Dibujable{    
    protected Punto pos;
    protected Image img;
    
    public SimpleImgSpr(Punto pos, Image img) {
        this.pos = pos;
        this.img = img;
    }
    
    public Image getImg() {
        return img;
    }
    
    public Punto getPos() {
        return pos;
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.drawImage(img,(int)pos.x,(int)pos.y, null);
    } 
}
