package engine.formas;

import engine.Dibujable;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author x0001
 */
public class Linea extends Line2D implements Dibujable{
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    private Point p1;
    private Point p2;
    


    public Linea(Point p1, Point p2) {
        this.p1=p1;
        this.p2=p2;
    }
    
    
    
    @Override
    public double getX1() {
        return (double)p1.x;
    }

    @Override
    public double getY1() {
        return (double)p1.y;
    }

    @Override
    public Point2D getP1() {
        return p1;
    }

    @Override
    public double getX2() {
        return (double)p2.x;

    }

    @Override
    public double getY2() {
        return (double)p2.y;
    }

    @Override
    public Point2D getP2() {
        return p2;
    }


    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        p1 = new Point((int)x1, (int)y1);
        p2 = new Point((int)x2, (int)y2);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return new Rectangle(p1.x, p1.y, p2.x, p2.y);
    }
    
    public void pintar(Graphics g){
        if(p1!=null && p2!=null){
            Graphics2D gg = (Graphics2D)g;
           // gg.setStroke(new BasicStroke(ANCHO*this.vida));
            g.setColor(Color.PINK);
          //  g.drawRect(p2.x, p2.y,1,1);

        }
            
    }

    /**
     * usado en las colisiones de rectangulos para calcular el origen de la colision.
     */
    public Rectangle getBounds(int tipo) {
        if(tipo == HORIZONTAL)
            return new Rectangulo(p1.x+5,p1.y,(p2.x-p1.x)-10,1);
        if(tipo == VERTICAL)
            return new Rectangulo(p1.x,p1.y+5,1,(p2.y-p1.y)-10);

        return null;
    }
    


    @Override
    public void dibujar(Graphics g) {
        if(p1!=null && p2!=null){
            Graphics2D gg = (Graphics2D)g;
//            g.drawRect(p1.x+p2.x, p1.y+p2.y,1,1);
            g.setColor(Color.BLUE);
            gg.drawLine(p1.x, p1.y, p2.x, p2.y);
        }    }
    
    

}
