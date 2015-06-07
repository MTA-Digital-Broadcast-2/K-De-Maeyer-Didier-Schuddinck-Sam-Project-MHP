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

    //plaats en lovatie instellen in de constructor
    public MijnComponent(int x, int y) 
    {
        this.setBounds(x, y, 100, 100);
    }
    
    //paint methode overschrijven
    public void paint(Graphics g)
    {
        g.setColor(new DVBColor(100, 100, 100, 179));
        g.fillRect(0, 0, 100, 100);
        g.setColor(Color.white);
        g.drawString("Tekst1", 15, 20);
    }
  
    
}
