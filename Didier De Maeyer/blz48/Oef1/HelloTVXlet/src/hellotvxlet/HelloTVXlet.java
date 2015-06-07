package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;

import java.awt.event.*;
import java.util.Timer;
import org.bluray.ui.event.*;
import org.dvb.event.*;
import org.havi.ui.*;

public class HelloTVXlet implements Xlet, UserEventListener {
    
    private XletContext actueleContext;
    private HScene scene;
    //debuggen activeren of niet?
    private boolean debug = true;
    
    private Sprite spaceship, sterren, sterren2;
    private int spaceshipX = 100, spaceshipY = 300, sterrenY = 0;
    
    public HelloTVXlet() {
        
        
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException {
      
        if(debug) System.out.println("Xlet Initialiseren");
        this.actueleContext = context;
        
        //Template aanmaken
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        //Grootte en positie aangeven
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        //Een instantie van de Scene aanvragen aan de factory
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
     
        sterren = new Sprite("sterrenhemel.png", 0, 0);
        sterren2 = new Sprite("sterrenhemel.png", 0, -569);
        
        spaceship = new Sprite("spaceship.png",spaceshipX , spaceshipY);
        
        
        scene.add(sterren);
        scene.add(sterren2);
        scene.add(spaceship);
        scene.popToFront(spaceship);
        
    }

    public void startXlet() throws XletStateChangeException {
        if(debug) System.out.println("Xlet starten");
        
        //Eventmanager aanvragen
        EventManager manager = EventManager.getInstance();
        
        //Repository
        UserEventRepository verzameling = new UserEventRepository("mijn verzameling");
        
        //Events toevoegen
        verzameling.addKey( HRcEvent.VK_LEFT );
        verzameling.addKey( HRcEvent.VK_RIGHT );
        
        //bekend makenn bij EventManager
        manager.addUserEventListener(this, verzameling);
        
        //Timer
        MijnTimerTask objMijnTimerTask = new MijnTimerTask(this);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(objMijnTimerTask, 0, 50);   //start na 0ms, voer uit elke 50ms
        
        //Scene zichtbaar maken
        scene.validate();
        scene.setVisible(true);
        
       
        
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }

    public void userEventReceived(UserEvent e) {
        
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed Button");
            switch( e.getCode() )
            {
                case HRcEvent.VK_LEFT:
                    spaceshipX -= 5;
                    spaceship.Verplaats(spaceshipX, spaceshipY);
                    break;
                case HRcEvent.VK_RIGHT:
                    spaceshipX += 5;
                    spaceship.Verplaats(spaceshipX, spaceshipY);
                    break;
            }
        }
        
        
    }
    
    public void callback()
    {
        sterrenY++;
        sterren.Verplaats(0, sterrenY);
        sterren2.Verplaats(0, sterrenY - 569);
        if (sterrenY > 569)
        {
            sterrenY -= 569;
        }
    }
}
