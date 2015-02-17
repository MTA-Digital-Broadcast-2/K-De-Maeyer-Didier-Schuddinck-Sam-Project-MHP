package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;

import java.awt.event.*;
import java.util.Timer;
import org.bluray.ui.event.*;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, HActionListener {
    
    private XletContext actueleContext;
    private HScene scene;
    //debuggen activeren of niet?
    private boolean debug = true;
    
    private HStaticText logoText;
    private Sprite logo, logoSmall;
    private int logoX = 100, 
                logoY = 50,
                logoSmallX = 20,
                logoSmallY = 20;
    
    private HTextButton btnPlayNewGame, btnHighscores, btnHowToPlay;
    
    private Sprite background;
    
    
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
        
        //Laat het startscherm zien
        showHomescreen();
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

    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getActionCommand());
        
        
        if( e.getActionCommand() == "btnPlayNewGame_pressed" ) 
        { 
            //laat het spelscherm zien en start het spel
            startGame();
            System.out.println("btn Play New Game Pressed");
        }
        else if ( e.getActionCommand() == "btnHighscores_pressed" ) 
        {
            System.out.println("btn Highscores Pressed");
        }
        else if ( e.getActionCommand() == "btnHowToPlay_pressed" ) 
        {
            System.out.println("btn How To Play Pressed");
            
            //scene.repaint(); //zorgt ervoor dat de andere knoppen ook veranderen van kleur, als je dit niet doet moeten de andere knoppen eerst de focus krijgen
        }
    }
    
    
    public void showHomescreen() {
        //LOGO
        logo = new Sprite("de-slimste-mens-ter-wereld-text.png", logoX, logoY);
        scene.add(logo);
        //tekstlabel aanmaken
        //logoText = new HStaticText("de SLIMSTE \n MENS ter wereld");
        //logoText.setLocation(200, 50);
        //logoText.setSize(300, 100);
        //logoText.setFont(new Font("sans-serif", Font.PLAIN, 40));
        
        //scene.add(logoText);
        
        
        //BUTTONS
        btnPlayNewGame = new HTextButton("PLAY NEW GAME");
        btnPlayNewGame.setLocation(250,300);
        btnPlayNewGame.setSize(200,50);
        btnPlayNewGame.setBackground(new DVBColor(0,0,0,179));
        btnPlayNewGame.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        btnHighscores = new HTextButton("HIGHSCORES");
        btnHighscores.setLocation(250,360);
        btnHighscores.setSize(200,50);
        btnHighscores.setBackground(new DVBColor(0,0,0,179));
        btnHighscores.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        btnHowToPlay = new HTextButton("HOW TO PLAY");
        btnHowToPlay.setLocation(250,420);
        btnHowToPlay.setSize(200,50);
        btnHowToPlay.setBackground(new DVBColor(0,0,0,179));
        btnHowToPlay.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        btnPlayNewGame.setFocusTraversal((null), btnHighscores, null, null);
        btnHighscores.setFocusTraversal(btnPlayNewGame, btnHowToPlay, null, null);
        btnHowToPlay.setFocusTraversal(btnHighscores, null, null, null);
        
        btnPlayNewGame.setActionCommand("btnPlayNewGame_pressed");
        btnHighscores.setActionCommand("btnHighscores_pressed");
        btnHowToPlay.setActionCommand("btnHowToPlay_pressed");
        
        
        btnPlayNewGame.addHActionListener(this);
        btnHighscores.addHActionListener(this);
        btnHowToPlay.addHActionListener(this);
        
        
        //scene.add(tekstLabel);
        scene.add(btnPlayNewGame);
        scene.add(btnHighscores);
        scene.add(btnHowToPlay);
        
        btnPlayNewGame.requestFocus();
        
        
        //BACKGROUND
        //background = new MijnComponent(0, 0, 1000, 1000);
        background = new Sprite("red-background.jpg", 0, 0);
        
        scene.add(background);
        scene.pushToBack(background);
    }
    
    public void startGame() {
        //Remove all components from scene
        scene.removeAll();
        
        
        //LOGO
        logoSmall = new Sprite("de-slimste-mens-ter-wereld-text-small.png", logoSmallX, logoSmallY);
        scene.add(logoSmall);
        
        //BACKGROUND
        scene.add(background);
        scene.pushToBack(background);
        
        scene.repaint();
    }

}
