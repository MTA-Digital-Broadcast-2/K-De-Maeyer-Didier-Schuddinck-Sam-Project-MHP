package hellotvxlet;

import java.awt.event.*;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet,HActionListener {
    
    private XletContext actueleXletContent;
    private HScene scene;
    
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HTextButton knop1,knop2,knop3,knop4;
    
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
      
      tekstLabel = new HStaticText("Wie wordt multimiljonair ?");
      tekstLabel.setLocation(150,50);
      tekstLabel.setSize(400,50);
      tekstLabel.setBackground(new DVBColor(255,255,255,179));
      tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop1 = new HTextButton("Antwoord 1");
      knop1.setLocation(150,150);
      knop1.setSize(400,50);
      knop1.setBackground(new DVBColor(0,0,0,179));
      knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop2 = new HTextButton("Antwoord 2");
      knop2.setLocation(150,225);
      knop2.setSize(400,50);
      knop2.setBackground(new DVBColor(0,0,0,179));
      knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop3 = new HTextButton("Antwoord 3");
      knop3.setLocation(150,300);
      knop3.setSize(400,50);
      knop3.setBackground(new DVBColor(0,0,0,179));
      knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop4 = new HTextButton("Antwoord 4");
      knop4.setLocation(150,375);
      knop4.setSize(400,50);
      knop4.setBackground(new DVBColor(0,0,0,179));
      knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      /*
      knopHulplijn = new HTextButton("Hulplijn aanvragen");
      knopHulplijn.setLocation(150,450);
      knopHulplijn.setSize(400,50);
      knopHulplijn.setBackground(new DVBColor(0,0,0,179));
      knopHulplijn.setBackgroundMode(HVisible.BACKGROUND_FILL);*/
      
      knop1.setFocusTraversal(knop4, knop2, null, null);
      knop2.setFocusTraversal(knop1, knop3, null, null);
      knop3.setFocusTraversal(knop2, knop4, null, null);
      knop4.setFocusTraversal(knop3, knop1, null, null);
      //knopHulplijn.setFocusTraversal(knop4, knop1, null, null);
      
      knop1.setActionCommand("1");
      knop2.setActionCommand("2");
      knop3.setActionCommand("3");
      knop4.setActionCommand("4");
      //knopHulplijn.setActionCommand("Hulplijn");
      
      knop1.addHActionListener(this);
      knop2.addHActionListener(this);
      knop3.addHActionListener(this);
      knop4.addHActionListener(this);
      //knopHulplijn.addHActionListener(this);
      
      scene.add(tekstLabel);
      scene.add(knop1);
      scene.add(knop2);
      scene.add(knop3);
      scene.add(knop4);
      scene.add(knopHulplijn);
      
      knop1.requestFocus();
      
     
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

    public void actionPerformed(ActionEvent e) {
        String correctAnswer = "2";
        
        if(e.getActionCommand().equals(correctAnswer))
        {
            knop2.setBackground(new DVBColor(0,255,0,179));
            scene.validate();
        }
        else if(e.getActionCommand().equals("1"))
        {
            knop1.setBackground(new DVBColor(255,0,0,179));
            scene.validate();
        }
         else if(e.getActionCommand().equals("3"))
        {
            knop3.setBackground(new DVBColor(255,0,0,179));
            scene.validate();
        }
         else if(e.getActionCommand().equals("4"))
        {
            knop4.setBackground(new DVBColor(255,0,0,179));
            scene.validate();
        }
        /*
        else if(e.getActionCommand().equals("Hulplijn"))
        {
            knop4.setBackground(new DVBColor(255,0,0,179));
            knop4.requestFocus();
            knop1.setBackground(new DVBColor(255,0,0,179));
            knop1.requestFocus();
            
            knop1.setFocusTraversal(knop4, knop2, null, null);
            knop4.setFocusTraversal(knop3, knop1, null, null);
            
            knopHulplijn.setVisible(false);
            scene.validate();
        }*/
       
    }
}
