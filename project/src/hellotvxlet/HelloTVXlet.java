package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;

import java.awt.event.*;
import java.util.Timer;
import javax.swing.*;
import org.bluray.ui.event.*;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, HActionListener {
    
    private XletContext actueleContext;
    private HScene scene;
    //debuggen activeren of niet?
    private boolean debug = true;
    
    private HStaticText txtRound, txtQuestionNumber, txtQuestion, txtTime;
    private HTextButton txtAntwoord1, txtAntwoord2, txtAntwoord3, txtAntwoord4, txtAntwoord5;
    
    
    private Sprite logo, logoSmall;
    private int logoX = 100, 
                logoY = 50,
                logoSmallX = 20,
                logoSmallY = 20;
    
    private String[][] openVragen = {
        {"Welke vloeistof gebruik je zeker als je stoofvlees wilt maken","bier"},
        {"welke nationaliteit hebben de meeste mensen die op Corsica wonen ?","Frans"},
        {"In welke Waalse provincie ligt de dierentuin van Pairi Daiza?", "Henegouwen"},
        {"Welk land van de Europese Unie(EU) heeft de grootste oppervlakte?","Frankrijk"},
        {"Welke vogel zit verborgen in het woord 'burgemeestersvrouw'", "mees"},
        {"Wie speelde in de kinderreeks 'Samson en Gert' de rol van Alberto'","Koen Crucke"},
        {"Van welk Japans automerk zijn de Verso en de Carina gekende modellen?","Toyata"},
        {"Wie regiseerde de film Saving Private Ryan?","Steven Spielberg"},
        {"Welke maand ligt zowel in de herfst als in de winter?","December"},
        {"Welke bank gebruikt een oranje leeuw in haar publiciteit?","ING"}
    };
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
        if( e.getActionCommand() == "btnPlayNewGame_pressed" ) 
        { 
            //laat het spelscherm zien en start het spel
            startRonde2();
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
    
    public void startRonde1() {
        //Remove all components from scene
        scene.removeAll();
        
        
        txtRound = new HStaticText("Ronde 1");
        txtRound.setLocation(200, 50);
        txtRound.setSize(300, 50);
        txtRound.setFont(new Font("sans-serif", Font.PLAIN, 35));
        scene.add(txtRound);
        
        txtQuestionNumber = new HStaticText("Vraag 1");
        txtQuestionNumber.setLocation(200, 100);
        txtQuestionNumber.setSize(300, 50);
        txtQuestionNumber.setFont(new Font("sans-serif", Font.PLAIN, 25));
        scene.add(txtQuestionNumber);
        
        txtQuestion = new HStaticText("Van welk Japans automerk zijn de Verso en de Carina gekende modellen?"); // er kunnen 40 karakters op 1 lijn
        txtQuestion.setHorizontalAlignment(0);          //links uitlijnen
        txtQuestion.setLocation(25, 150);
        txtQuestion.setSize(650, 50);
        txtQuestion.setFont(new Font("sans-serif", Font.PLAIN, 24));
        scene.add(txtQuestion);
        
        //LOGO
        logoSmall = new Sprite("de-slimste-mens-ter-wereld-text-small.png", logoSmallX, logoSmallY);
        scene.add(logoSmall);
        
        //BACKGROUND
        scene.add(background);
        scene.pushToBack(background);
        
        scene.repaint();
    }
    
    public void startRonde2() {
        //Remove all components from scene
        scene.removeAll();
        
        
        txtRound = new HStaticText("Ronde 2");
        txtRound.setLocation(200, 50);
        txtRound.setSize(300, 50);
        txtRound.setFont(new Font("sans-serif", Font.PLAIN, 35));
        scene.add(txtRound);
        
        txtQuestionNumber = new HStaticText("Vraag 1");
        txtQuestionNumber.setLocation(200, 100);
        txtQuestionNumber.setSize(300, 50);
        txtQuestionNumber.setFont(new Font("sans-serif", Font.PLAIN, 25));
        scene.add(txtQuestionNumber);
        
        //vraag
        txtQuestion = new HStaticText("Van welk Japans automerk zijn de Verso en de Carina gekende modellen?"); // er kunnen 40 karakters op 1 lijn
        txtQuestion.setHorizontalAlignment(0);          //links uitlijnen
        txtQuestion.setLocation(25, 150);
        txtQuestion.setSize(650, 50);
        txtQuestion.setFont(new Font("sans-serif", Font.PLAIN, 24));
        scene.add(txtQuestion);
        
        //antwoorden
        txtAntwoord1 = new HTextButton("antwoord 1");
        txtAntwoord1.setBordersEnabled(false);  //geen borders
        txtAntwoord1.setHorizontalAlignment(0); //links uitlijnen
        txtAntwoord1.setLocation(30, 200);
        txtAntwoord1.setSize(650, 50);
        txtAntwoord1.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord2 = new HTextButton("antwoord 2");
        txtAntwoord2.setBordersEnabled(false);
        txtAntwoord2.setHorizontalAlignment(0);
        txtAntwoord2.setLocation(30, 250);
        txtAntwoord2.setSize(650, 50);
        txtAntwoord2.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord3 = new HTextButton("antwoord 3");
        txtAntwoord3.setBordersEnabled(false);
        txtAntwoord3.setHorizontalAlignment(0);
        txtAntwoord3.setLocation(30, 300);
        txtAntwoord3.setSize(650, 50);
        txtAntwoord3.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord4 = new HTextButton("antwoord 4");
        txtAntwoord4.setBordersEnabled(false);
        txtAntwoord4.setHorizontalAlignment(0);
        txtAntwoord4.setLocation(30, 350);
        txtAntwoord4.setSize(650, 50);
        txtAntwoord4.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord5 = new HTextButton("antwoord 5");
        txtAntwoord5.setBordersEnabled(false);  
        txtAntwoord5.setHorizontalAlignment(0); 
        txtAntwoord5.setLocation(30, 400);
        txtAntwoord5.setSize(650, 50);
        txtAntwoord5.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord1.setFocusTraversal((null), txtAntwoord2, null, null);
        txtAntwoord2.setFocusTraversal(txtAntwoord1, txtAntwoord3, null, null);
        txtAntwoord3.setFocusTraversal(txtAntwoord2, txtAntwoord4, null, null);
        txtAntwoord4.setFocusTraversal(txtAntwoord3, txtAntwoord5, null, null);
        txtAntwoord5.setFocusTraversal(txtAntwoord4, null, null, null);
        
        txtAntwoord1.addHActionListener(this);
        txtAntwoord2.addHActionListener(this);
        txtAntwoord3.addHActionListener(this);   
        
        scene.add(txtAntwoord1);
        scene.add(txtAntwoord2);
        scene.add(txtAntwoord3);
        scene.add(txtAntwoord4);
        scene.add(txtAntwoord5);
        
        txtAntwoord1.requestFocus();
        
        
        
        
        //LOGO
        logoSmall = new Sprite("de-slimste-mens-ter-wereld-text-small.png", logoSmallX, logoSmallY);
        scene.add(logoSmall);
        
        //BACKGROUND
        scene.add(background);
        scene.pushToBack(background);
        
        scene.repaint();
    }

}
