/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import java.util.TimerTask;
/**
 *
 * @author student
 */
public class MijnTimer extends TimerTask {
    
    private Sprite Sterren;
    private Sprite Sterren2;
    private int verplaatsing = 0;
    private boolean verplaatsRichting = true;
    
    public MijnTimer(Sprite Object,Sprite Object2)
    {
        this.Sterren = Object;
        this.Sterren2 = Object2;
    }
    public void run() {
        if(verplaatsing == 560)
        {
            verplaatsRichting = false;
        }
        else if(verplaatsing == 0)
        {
           verplaatsRichting = true;
        }
        
        if(verplaatsRichting)
        {
            this.Sterren.Verplaats(0, 10);
            this.Sterren2.Verplaats(0, 10);
            verplaatsing += 10;
        }
        else
        {
            this.Sterren.Verplaats(0, -10);
            this.Sterren2.Verplaats(0, -10);
            verplaatsing -= 10;
        }
        
    }

}
