package hellotvxlet;

import java.awt.event.*;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet {
    
    private XletContext actueleXletContent;
    private HScene scene;
    
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HTextButton knop1,knop2,knop3,knop4,knopHulplijn;
    
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
      MijnComponent mc = new MijnComponent(100,100,100,100);
      scene.add(mc);
      
      
     
    }

    public void startXlet() {
        if(debug) System.out.println("Xlet Starten");
        //Scene zichtbaar maken
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

}
