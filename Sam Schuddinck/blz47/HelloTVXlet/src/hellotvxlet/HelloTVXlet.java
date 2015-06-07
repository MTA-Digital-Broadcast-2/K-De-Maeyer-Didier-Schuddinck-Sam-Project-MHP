package hellotvxlet;

import java.awt.event.*;
import javax.tv.xlet.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet,UserEventListener {
    
    private XletContext actueleXletContent;
    private HScene scene;
    
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HTextButton knop1,knop2,knop3,knop4,knopHulplijn;
    
    private Sprite SpaceShip;
    Sprite Sterren;
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      this.actueleXletContent = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION,
              new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
              new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      SpaceShip = new Sprite("spaceship.png",10,10);
      scene.add(SpaceShip);
         
    }

    public void startXlet() {
        if(debug) System.out.println("Xlet Starten");
        //Scene zichtbaar maken
        
        //Eventmanager aanvragen
        EventManager manager = EventManager.getInstance();
        //Repos
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        // Events toevoegen
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        //Bekend maken bij Event Manager
        manager.addUserEventListener(this, repository);
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException{
     if(unconditional)
     {
        System.out.println("De Xlet moet beëindigd worden.");
     }
     else
     {
        System.out.println("De mogelijkheid bestaat door het werpen van een exceptie de Xlet in leven te houden.");
        throw new XletStateChangeException("Laat me leven!");
     }
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED)
        {
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    SpaceShip.Verplaats(0, -10);
                    break;
                case HRcEvent.VK_DOWN:
                    SpaceShip.Verplaats(0,10);
                    break;
                case HRcEvent.VK_LEFT:
                    SpaceShip.Verplaats(-10,0);
                    System.out.println("Links");
                    break;
                case HRcEvent.VK_RIGHT:
                    SpaceShip.Verplaats(10,0);
                    System.out.println("Rechts");
                    break;
            }
        }
    }

}
