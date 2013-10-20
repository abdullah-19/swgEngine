/*
 * Esta clase se encarga de crear un contenedor para nuestro animacion.
 * 
 */
package engine;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Juanjo Gallardo
 */
public class ContenedorBasico extends JPanel{
    private JFrame v; //Ventana que cotendrá el panel.
    private EscenaAnimada a;
    private Image dbf; //para implementar el doble buffer
    /**
     * Crea una nueva ventana contenedora para el animacion con los valores especificados
     * @param titulo
     * @param tam
     * @param decorado true con decorado | false sin decorado
     * @param animacion 
     */
    public ContenedorBasico(EscenaAnimada animacion,String titulo,Dimension tam,boolean decorado) {
        this.a=animacion;
        a.setContenedor(this);
        
        this.v = new JFrame(titulo);
        v.setSize(tam);
        v.setLocationRelativeTo(null);
        v.setUndecorated(!decorado);
        v.setResizable(false);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setContentPane(this);
    }

    /**
     * Crea una nueva ventana contenedora para el animacion con los valores especificados
     * 
     * @param titulo
     * @param tam
     */
    public ContenedorBasico(EscenaAnimada animacion,String titulo,Dimension tam) {
        this(animacion,titulo,tam,true);
    }
    /**
     * Crea una nueva ventana contenedora para el animacion con los valores especificados
     * @param titulo
     */
    public ContenedorBasico(EscenaAnimada animacion,String titulo){
        this(animacion,titulo,new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height),true);
    }
    /**
     * Crea una nueva ventana contenedora a pantalla completa
     */
    public ContenedorBasico(EscenaAnimada animacion){
        this(animacion,"",new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height),true);
    }


    /**
     * Devuelve la ventana que contiene el panel de animacion.
     * @return 
     */
    public JFrame getVentana() {
        return v;
    }
    
    public Container getPanel(){
        return this;
    }

    /**
     * implementacion del doble buffer
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        if(a!=null){
            super.paint(g);
            if(dbf==null)
                dbf = createImage(this.getWidth(),this.getHeight());
            a.renderizar(dbf.getGraphics());      
            g.drawImage(dbf, 0, 0, null);
        }
    }
    
    public void hacerVisible(boolean b){
        this.v.setVisible(b);
    }
    

}
