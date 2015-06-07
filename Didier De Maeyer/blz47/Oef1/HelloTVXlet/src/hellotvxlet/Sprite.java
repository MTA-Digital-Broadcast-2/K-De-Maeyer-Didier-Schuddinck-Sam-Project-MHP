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

    private Image spaceship;
    private MediaTracker mtrack;
    
    //plaats en lovatie instellen in de constructor
    public Sprite(String file, int x, int y) 
    {
        spaceship = this.getToolkit().getImage(file);
        mtrack = new MediaTracker(this);
        mtrack.addImage(spaceship, 0);
        try 
        {
            mtrack.waitForAll(); // wacht tot alle bitmaps geladen zijn
        } 
        catch (InterruptedException ex) 
        {
            ex.printStackTrace();
        }
        this.setBounds(x, y, spaceship.getWidth(null), spaceship.getHeight(null)); //opgeven plaats en afmetingen bitmap
    }
    
    //paint methode overschrijven
    public void paint(Graphics g)
    {
        g.drawImage(spaceship, 0, 0, null);
    }
    
    public void Verplaats(int x, int y)
    {
        this.setBounds(x, y, spaceship.getWidth(this), spaceship.getHeight(this));
    }
  
    
}
