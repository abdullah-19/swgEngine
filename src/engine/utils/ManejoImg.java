package engine.utils;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Juanjo Gallardo
 */
public class ManejoImg {
    
    public static Image cargarImagen(String img){
        return Toolkit.getDefaultToolkit().getImage(img);
    }
    
    public static Image[][] cortarImagen(String imgCompleta,int nFilas,int nColumnas) throws IOException{
        BufferedImage buff = ImageIO.read(new File(imgCompleta));
        Dimension tamTrozo = new Dimension(buff.getWidth()/nColumnas,buff.getHeight()/nFilas);
        Image[][] trozos = new Image[nFilas][nColumnas];
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nColumnas; j++) {
                trozos[i][j]=buff.getSubimage(tamTrozo.width*i, tamTrozo.height*j,tamTrozo.width,tamTrozo.height);
            }        
        }
        return trozos;    
    }
    public static List<Image> cortarImagenList(String imgCompleta,int nFilas,int nColumnas) throws IOException{
        List<Image> listaImagenes = new ArrayList<>();
        BufferedImage buff = ImageIO.read(new File(imgCompleta));
        Dimension tamTrozo = new Dimension(buff.getWidth()/nColumnas,buff.getHeight()/nFilas);
        Image[][] trozos = new Image[nFilas][nColumnas];
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nColumnas; j++) {
                listaImagenes.add(buff.getSubimage(tamTrozo.width*i, tamTrozo.height*j,tamTrozo.width,tamTrozo.height));
            }        
        }
        return listaImagenes;    
    }    
    public static Image[] sheetToFrames(String sheetstr,int nTrozos) throws IOException{
        BufferedImage buff = ImageIO.read(new File(sheetstr));
        Dimension tamTrozo = new Dimension(buff.getWidth()/nTrozos,buff.getHeight());
        Image[] frames = new Image[nTrozos];
        for (int i = 0; i < nTrozos; i++) {
            frames[i] = buff.getSubimage(tamTrozo.width*i, 0, tamTrozo.width,tamTrozo.height );
        }        
        return frames;
    }
 
    
    public static Image escalarImagen(Image img,int ancho,int alto){
        return img.getScaledInstance(ancho,alto,Image.SCALE_SMOOTH);                   
    }

}