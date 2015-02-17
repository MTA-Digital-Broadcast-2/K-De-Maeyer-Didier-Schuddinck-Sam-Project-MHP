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
    
    private int width, height;
    
    //plaats en locatie instellen in de constructor
    public MijnComponent(int x, int y, int width, int height) 
    {
        this.width = width;
        this.height = height;
        this.setBounds(x, y, width, height);
    }
    
    //paint methode overschrijven
    public void paint(Graphics g)
    {   
        g.setColor(new DVBColor(100 , 0, 0, 255));
        g.fillRect(0, 0, width, height);
    }

}
