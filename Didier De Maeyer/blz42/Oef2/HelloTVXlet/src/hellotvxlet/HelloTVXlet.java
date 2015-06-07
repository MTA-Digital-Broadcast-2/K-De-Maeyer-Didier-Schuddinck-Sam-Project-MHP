package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.event.*;

//Stap 1: klassen onder org.have.ui verkort noteren
import org.havi.ui.*;

public class HelloTVXlet implements Xlet, HActionListener {

    private XletContext actueleContext;
    private HScene scene;
    //debuggen activeren of niet?
    private boolean debug = true;
    
    private HStaticText tekstLabel;
    private HTextButton knop1, knop2, knop3, knop4, knopHulp;
    
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
        
        //Stap 3: object aanmaken
        //Stap 4: eigenschappen van tekstLabel instellen
        //Stap 5: tekstLabel aan de Scene toevoegen
        
        //tekstlabel aanmaken
        tekstLabel = new HStaticText("Wie wordt multimiljonair?");
        tekstLabel.setLocation(200, 50);
        tekstLabel.setSize(300, 50);
        
        
        knop1 = new HTextButton("ANTWOORD 1");
        knop1.setLocation(250,100);
        knop1.setSize(200,50);
        knop1.setBackground(new DVBColor(0,0,0,179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop2 = new HTextButton("ANTWOORD 2");
        knop2.setLocation(250,200);
        knop2.setSize(200,50);
        knop2.setBackground(new DVBColor(0,0,0,179));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop3 = new HTextButton("ANTWOORD 3");
        knop3.setLocation(250,300);
        knop3.setSize(200,50);
        knop3.setBackground(new DVBColor(0,0,0,179));
        knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop4 = new HTextButton("ANTWOORD 4");
        knop4.setLocation(250,400);
        knop4.setSize(200,50);
        knop4.setBackground(new DVBColor(0,0,0,179));
        knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knopHulp = new HTextButton("Hulplijn aanvragen");
        knopHulp.setLocation(200,500);
        knopHulp.setSize(300,50);
        knopHulp.setBackground(new DVBColor(0,0,0,179));
        knopHulp.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop1.setFocusTraversal((null), knop2, null, null);
        knop2.setFocusTraversal(knop1, knop3, null, null);
        knop3.setFocusTraversal(knop2, knop4, null, null);
        knop4.setFocusTraversal(knop3, knopHulp, null, null);
        knopHulp.setFocusTraversal(knop4, null, null, null);
        
        knop1.setActionCommand("knop1_pressed");
        knop2.setActionCommand("knop2_pressed");
        knop3.setActionCommand("knop3_pressed");
        knop4.setActionCommand("knop4_pressed");
        knopHulp.setActionCommand("knopHulp_pressed");
        
        
        knop1.addHActionListener(this);
        knop2.addHActionListener(this);
        knop3.addHActionListener(this);
        knop4.addHActionListener(this);
        knopHulp.addHActionListener(this);
        
        
        scene.add(tekstLabel);
        scene.add(knop1);
        scene.add(knop2);
        scene.add(knop3);
        scene.add(knop4);
        scene.add(knopHulp);
        
        knop1.requestFocus();
    }

    public void startXlet() throws XletStateChangeException {
        if(debug) System.out.println("Xlet starten");
        
        //Scene zichtbaar maken
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }
    
    //Deze methode moet je hebben als HelloTVXlet HActionListener implementeerd
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        
        
        if( e.getActionCommand() == "knop1_pressed" ) 
        { 
            knop1.setBackground(new DVBColor(255, 0, 0, 255));
        }
        else if ( e.getActionCommand() == "knop2_pressed" ) 
        {
            knop2.setBackground(new DVBColor(255, 0, 0, 255));
        }
        else if( e.getActionCommand() == "knop4_pressed" ) 
        { 
            knop4.setBackground(new DVBColor(255, 0, 0, 255));
        }
        else if ( e.getActionCommand() == "knop3_pressed" ) 
        {
            knop1.setBackground(new DVBColor(255, 0, 0, 255));
            knop2.setBackground(new DVBColor(255, 0, 0, 255));
            knop4.setBackground(new DVBColor(255, 0, 0, 255));
            
            knop3.setBackground(new DVBColor(0, 255, 0, 255));
            
            scene.repaint(); //zorgt ervoor dat de andere knoppen ook veranderen van kleur, als je dit niet doet moeten de andere knoppen eerst de focus krijgen
        }
        else if ( e.getActionCommand() == "knopHulp_pressed" )
        {
            knop1.setBackground(new DVBColor(255, 0, 0, 255));
            knop4.setBackground(new DVBColor(255, 0, 0, 255));
            
            knopHulp.setBackground(new DVBColor(255, 0, 0, 255));
            
            scene.repaint();
        }
        
        
        
    }
}
