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
    
    private Image SpaceShip;
    private MediaTracker mtrack;
    
    public Sprite(String bitmapnaam, int x, int y)
    {
        SpaceShip = this.getToolkit().getImage(bitmapnaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(SpaceShip, 0);
        try
        {
            mtrack.waitForAll(); // Wacht tot alle bitmaps geladen zijn
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
        this.setBounds(x,y,SpaceShip.getWidth(null),SpaceShip.getHeight(null));
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(SpaceShip, 0,0,null);
    }
    
    public void Verplaats(int x, int y)
    {
        this.setBounds(this.getX() + x,this.getY() + y,SpaceShip.getWidth(null),SpaceShip.getHeight(null));
    }
}
