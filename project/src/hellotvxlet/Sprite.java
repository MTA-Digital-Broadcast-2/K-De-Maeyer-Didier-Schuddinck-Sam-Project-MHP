/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

/**
 *
 * @author student
 */
public class Sprite extends HComponent {

    private Image image;
    private MediaTracker mtrack;
    
    public Sprite(String file, int x, int y) {
        
        image = this.getToolkit().getImage(file);
        mtrack = new MediaTracker(this);
        mtrack.addImage(image, 0);
        try 
        {
            mtrack.waitForAll(); // wacht tot alle bitmaps geladen zijn
        } 
        catch (InterruptedException ex) 
        {
            ex.printStackTrace();
        }
        
        this.setBounds(x, y, image.getWidth(null), image.getHeight(null)); //opgeven plaats en afmetingen bitmap
        
        
    }
    
    //paint methode overschrijven
    public void paint(Graphics g)
    {
        g.drawImage(image, 0, 0, null);
    }

    
    
}
