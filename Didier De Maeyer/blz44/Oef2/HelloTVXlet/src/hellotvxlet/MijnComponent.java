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
        this.setBounds(x, y, 110, 110);
    }
    
    //paint methode overschrijven
    public void paint(Graphics g)
    {   
        g.setColor(new DVBColor(0, 0, 0, 255));
        g.fillRoundRect(5, 5, 100, 50, 15, 15); //schaduw
        
        g.setColor(new DVBColor(0, 0, 127, 179));
        g.fillRoundRect(0, 0, 100, 50, 15, 15); 
        
        g.setColor(new DVBColor(255, 255, 0, 255));
        g.drawString("Tekst1", 15, 20);
    }
  
    
}
