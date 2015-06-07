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
public class MijnComponent extends HComponent {
    public MijnComponent(int x, int y, int w, int h)
    {
        this.setBounds(x,y,w,h);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(new DVBColor(10,10,10,179));
        g.fillRoundRect(5, 5, 150, 50, 5, 5);
        g.setColor(new DVBColor(0,0,255,179));
        g.fillRoundRect(0, 0, 150, 50, 5, 5);
        g.setColor(new DVBColor(255,255,0,179));
        g.drawString("Gele Tekst", 15, 20);
    }
}
