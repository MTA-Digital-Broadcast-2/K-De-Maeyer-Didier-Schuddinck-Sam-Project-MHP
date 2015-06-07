package hellotvxlet;


import java.awt.Font;
import java.awt.event.*;
import java.util.Timer;
//import org.bluray.ui.event.*;
import javax.tv.xlet.*;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, HActionListener,UserEventListener{
    
    private XletContext actueleContext;
    private HScene scene;
    //debuggen activeren of niet?
    private boolean debug = true;

    private boolean checkInput = false;
    private HStaticText txtRound, txtQuestionNumber, txtQuestion, txtTime, txtAnswer,txtCorrection;
    private HTextButton txtAntwoord1, txtAntwoord2, txtAntwoord3, txtAntwoord4, txtAntwoord5;
    private UserEventRepository repository;
    private EventManager manager = EventManager.getInstance();
    private Sprite logo, logoSmall;
    private int logoX = 100, 
                logoY = 50,
                logoSmallX = 20,
                logoSmallY = 20;
    
    private String userAnswer = ""; //Variabele om antwoord in bij te houden
    private int currentQ;
    private int questionCounter = 1;
    private int currentRound;
    private boolean[] qAnswered = new boolean[10];
    private String[][] openVragen = {
        {"Welke vloeistof gebruik je zeker als je stoofvlees wilt maken","bier"},
        {"welke nationaliteit hebben de meeste mensen die op Corsica wonen ?","Frans"},
        {"In welke Waalse provincie ligt de dierentuin van Pairi Daiza?", "Henegouwen"},
        {"Welk land van de Europese Unie(EU) heeft de grootste oppervlakte?","Frankrijk"},
        {"Welke vogel zit verborgen in het woord 'burgemeestersvrouw'", "mees"},
        {"Wie speelde in de kinderreeks 'Samson en Gert' de rol van Alberto'","Koen Crucke"},
        {"Van welk Japans automerk zijn de Verso en de Carina gekende modellen?","Toyota"},
        {"Wie regiseerde de film Saving Private Ryan?","Steven Spielberg"},
        {"Welke maand ligt zowel in de herfst als in de winter?","December"},
        {"Welke bank gebruikt een oranje leeuw in haar publiciteit?","ING"}
    };
    private String[][] meerkeuzeVragen = {
        {"Welke taal wordt in Zwitserland het meest gesproken?", "Duits", "Frans", "Duits", "Zwitsers", "Italiaans"},
        {"Welke typische kleur hebben de bloemblaadjes van de papaver?", "rood", "blauw", "geel", "rood", "groen"},
        {"Welke kleur hebben de vakbondsblaggen van het ACLVB?", "blauw", "blauw", "rood", "groen", "geel"},
        {"Wat is het beroep van Panoramix uit de Asterix-reeks?", "druïde", "kok", "houthakker", "dorpsleider", "druïde"},
        {"Hoeveel ogen kunnen er maximaal op één dominosteen staan?", "twaalf", "tien", "elf", "twaalf", "veertien"},
        {"Hoeveel boeken heefteen heptagoon?", "zeven", "zes", "zeven", "acht", "negen"},
        {"Op welke datum vieren de inwoners van de USA hun Independence Day?", "4 juli", "1 juli", "4 juli", "16 juli", "21 juli"},
        {"In welke eeuw leefde en werkte Keizer Karel?", "16de eeuw", "13de eeuw", "14de eeuw", "15de eeuw", "16de eeuw"},
        {"Hoeveel punten is de zwarte snookerbal waard?", "7 punten", "7 punten", "8 punten", "9 punten", "10 punten"},
        {"Hoeveel provincies telt België?", "tien", "negen", "tien", "elf", "twaalf"}
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

    public void startXlet() {
        if(debug) System.out.println("Xlet Starten");
        //Scene zichtbaar maken
        
        
        //Repos
        repository = new UserEventRepository("Voorbeeld");
        // Events toevoegen
        repository.addKey(HRcEvent.VK_A);
        repository.addKey(HRcEvent.VK_B);
        repository.addKey(HRcEvent.VK_C);
        repository.addKey(HRcEvent.VK_D);
        repository.addKey(HRcEvent.VK_E);
        repository.addKey(HRcEvent.VK_F);
        repository.addKey(HRcEvent.VK_G);
        repository.addKey(HRcEvent.VK_H);
        repository.addKey(HRcEvent.VK_I);
        repository.addKey(HRcEvent.VK_J);
        repository.addKey(HRcEvent.VK_K);
        repository.addKey(HRcEvent.VK_L);
        repository.addKey(HRcEvent.VK_M);
        repository.addKey(HRcEvent.VK_N);
        repository.addKey(HRcEvent.VK_O);
        repository.addKey(HRcEvent.VK_P);
        repository.addKey(HRcEvent.VK_Q);
        repository.addKey(HRcEvent.VK_R);
        repository.addKey(HRcEvent.VK_S);
        repository.addKey(HRcEvent.VK_T);
        repository.addKey(HRcEvent.VK_U);
        repository.addKey(HRcEvent.VK_V);
        repository.addKey(HRcEvent.VK_W);
        repository.addKey(HRcEvent.VK_X);
        repository.addKey(HRcEvent.VK_Y);
        repository.addKey(HRcEvent.VK_Z);
        //Bekend maken bij Event Manager
        manager.addUserEventListener(this, repository);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
     
    }

    public void actionPerformed(ActionEvent e) {
        if(! this.checkInput)
        {
            if( e.getActionCommand().equals("btnPlayNewGame_pressed" ))
            { 
                // Pas hier toevoegen om error te vermijden in menu
                repository.addKey(HRcEvent.VK_SPACE);
                repository.addKey(HRcEvent.VK_ENTER);
                repository.addKey(HRcEvent.VK_BACK_SPACE);
                //Bekend maken bij Event Manager
                manager.addUserEventListener(this, repository);
                //laat het spelscherm zien en start het spel
                startRonde1();

                System.out.println("btn Play New Game Pressed");
            }
            else if ( e.getActionCommand().equals("btnHighscores_pressed" ))
            {
                System.out.println("btn Highscores Pressed");
            }
            else if ( e.getActionCommand().equals("btnHowToPlay_pressed" ))
            {
                System.out.println("btn How To Play Pressed");
                //scene.repaint(); //zorgt ervoor dat de andere knoppen ook veranderen van kleur, als je dit niet doet moeten de andere knoppen eerst de focus krijgen
            }
            else if ( e.getActionCommand().equals("juist" )) {
                System.out.println("juist");
            }
            else if ( e.getActionCommand().equals("fout" )) {
                System.out.println("fout");
            }
        }
        else
        {
            if( e.getActionCommand().equals("antwoord_1" ))
            { 
                System.out.println("antwoord_1");
                this.userAnswer = this.meerkeuzeVragen[this.currentQ][2];
                this.checkAnswer();
            }
            else if ( e.getActionCommand().equals("antwoord_2" ))
            {
                System.out.println("antwoord_2");
                this.userAnswer = this.meerkeuzeVragen[this.currentQ][3];
                this.checkAnswer();
            }
            else if ( e.getActionCommand().equals("antwoord_3" ))
            {
                System.out.println("antwoord_3");
                this.userAnswer = this.meerkeuzeVragen[this.currentQ][4];
                this.checkAnswer();
            }
            else if ( e.getActionCommand().equals("antwoord_4" ))
            {
                System.out.println("antwoord_4");
                this.userAnswer = this.meerkeuzeVragen[this.currentQ][5];
                this.checkAnswer();
            }
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
        this.currentRound = 1;
        //Remove all components from scene
        scene.removeAll();
        
        
        txtRound = new HStaticText("Ronde 1");
        txtRound.setLocation(200, 50);
        txtRound.setSize(300, 50);
        txtRound.setFont(new Font("sans-serif", Font.PLAIN, 35));
        scene.add(txtRound);
        
        txtQuestionNumber = new HStaticText("Vraag " + this.questionCounter);
        txtQuestionNumber.setLocation(200, 100);
        txtQuestionNumber.setSize(300, 50);
        txtQuestionNumber.setFont(new Font("sans-serif", Font.PLAIN, 25));
        scene.add(txtQuestionNumber);
        
        
        int randomQ = (int) (Math.random() * openVragen.length);
        txtQuestion = new HStaticText(openVragen[randomQ][0]); // er kunnen 40 karakters op 1 lijn
        currentQ = randomQ;
        txtQuestion.setHorizontalAlignment(0);          //links uitlijnen
        txtQuestion.setLocation(50, 150);
        txtQuestion.setSize(600, 50); 
        txtQuestion.setFont(new Font("sans-serif", Font.PLAIN, 20));
        scene.add(txtQuestion);
        
        txtAnswer = new HStaticText(" "); // er kunnen 40 karakters op 1 lijn
        txtAnswer.setLocation(50, 200);
        txtAnswer.setSize(600, 50);   //Hoe zorgt ge ervoor da tekst links uitgelijnd wordt?
        txtAnswer.setFont(new Font("sans-serif", Font.PLAIN, 25));
        scene.add(txtAnswer);
        
        txtCorrection = new HStaticText(" "); // er kunnen 40 karakters op 1 lijn
        txtCorrection.setLocation(50, 250);
        txtCorrection.setSize(600, 50);   //Hoe zorgt ge ervoor da tekst links uitgelijnd wordt?
        txtCorrection.setFont(new Font("sans-serif", Font.PLAIN, 25));
        scene.add(txtCorrection);
        
        checkInput = true;

        
        //LOGO
        logoSmall = new Sprite("de-slimste-mens-ter-wereld-text-small.png", logoSmallX, logoSmallY);
        scene.add(logoSmall);
        
        //BACKGROUND
        scene.add(background);
        scene.pushToBack(background);
        
        scene.repaint();
    }
    
    public void startRonde2() {
        this.currentRound = 2;
        this.questionCounter = 1;
        this.userAnswer = "";
        this.qAnswered = new boolean[10];
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
        int randomQ = (int) (Math.random() * this.meerkeuzeVragen.length);
        this.currentQ = randomQ;
        txtQuestion = new HStaticText(this.meerkeuzeVragen[this.currentQ][0]); // er kunnen 40 karakters op 1 lijn
        currentQ = randomQ;
        txtQuestion.setHorizontalAlignment(0);          //links uitlijnen
        txtQuestion.setLocation(50, 150);
        txtQuestion.setSize(600, 50); 
        txtQuestion.setFont(new Font("sans-serif", Font.PLAIN, 20));
        scene.add(txtQuestion);
        
        txtCorrection = new HStaticText(" "); // er kunnen 40 karakters op 1 lijn
        txtCorrection.setLocation(50, 400);
        txtCorrection.setSize(600, 50);   //Hoe zorgt ge ervoor da tekst links uitgelijnd wordt?
        txtCorrection.setFont(new Font("sans-serif", Font.PLAIN, 25));
        scene.add(txtCorrection);
        
        //antwoorden
        txtAntwoord1 = new HTextButton(this.meerkeuzeVragen[this.currentQ][2]);
        txtAntwoord1.setBordersEnabled(false);  //geen borders
        txtAntwoord1.setHorizontalAlignment(0); //links uitlijnen
        txtAntwoord1.setLocation(30, 200);
        txtAntwoord1.setSize(650, 50);
        txtAntwoord1.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord2 = new HTextButton(this.meerkeuzeVragen[this.currentQ][3]);
        txtAntwoord2.setBordersEnabled(false);
        txtAntwoord2.setHorizontalAlignment(0);
        txtAntwoord2.setLocation(30, 250);
        txtAntwoord2.setSize(650, 50);
        txtAntwoord2.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord3 = new HTextButton(this.meerkeuzeVragen[this.currentQ][4]);
        txtAntwoord3.setBordersEnabled(false);
        txtAntwoord3.setHorizontalAlignment(0);
        txtAntwoord3.setLocation(30, 300);
        txtAntwoord3.setSize(650, 50);
        txtAntwoord3.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord4 = new HTextButton(this.meerkeuzeVragen[this.currentQ][5]);
        txtAntwoord4.setBordersEnabled(false);
        txtAntwoord4.setHorizontalAlignment(0);
        txtAntwoord4.setLocation(30, 350);
        txtAntwoord4.setSize(650, 50);
        txtAntwoord4.setFont(new Font("sans-serif", Font.PLAIN, 20));
        
        txtAntwoord1.setFocusTraversal((null), txtAntwoord2, null, null);
        txtAntwoord2.setFocusTraversal(txtAntwoord1, txtAntwoord3, null, null);
        txtAntwoord3.setFocusTraversal(txtAntwoord2, txtAntwoord4, null, null);
        txtAntwoord4.setFocusTraversal(txtAntwoord3, null, null, null);
        
        
        txtAntwoord1.setActionCommand("antwoord_1");
        txtAntwoord2.setActionCommand("antwoord_2");
        txtAntwoord3.setActionCommand("antwoord_3");
        txtAntwoord4.setActionCommand("antwoord_4");
        
        txtAntwoord1.addHActionListener(this);
        txtAntwoord2.addHActionListener(this);
        txtAntwoord3.addHActionListener(this);
        txtAntwoord4.addHActionListener(this);   
        
        scene.add(txtAntwoord1);
        scene.add(txtAntwoord2);
        scene.add(txtAntwoord3);
        scene.add(txtAntwoord4);
        
        txtAntwoord1.requestFocus();
        
        //LOGO
        logoSmall = new Sprite("de-slimste-mens-ter-wereld-text-small.png", logoSmallX, logoSmallY);
        scene.add(logoSmall);
        
        //BACKGROUND
        scene.add(background);
        scene.pushToBack(background);
        checkInput = true;
        scene.repaint();
    }
    
    public void checkAnswer()
    {
        this.qAnswered[this.currentQ] = true;
        
        if(this.currentRound == 1)
        {
            //Controle huidige vraag
            if(this.openVragen[this.currentQ][1].toLowerCase().equals(userAnswer.toLowerCase()))
            {
                txtCorrection.setForeground(new DVBColor(0,255,0,179));
                txtCorrection.setTextContent("Goed!",HState.FIRST_STATE);
                
            }
            else
            {
                txtCorrection.setForeground(new DVBColor(255,0,0,179));
                txtCorrection.setTextContent("Fout!",HState.FIRST_STATE);
            }
            try
            {
                Thread.sleep(1000);
                txtCorrection.setTextContent("",HState.FIRST_STATE);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            this.nextQuestion();
        }
        else if(this.currentRound == 2)
        {
            //Controle huidige vraag
            if(this.meerkeuzeVragen[this.currentQ][1].toLowerCase().equals(userAnswer.toLowerCase()))
            {
                txtCorrection.setForeground(new DVBColor(0,255,0,179));
                txtCorrection.setTextContent("Vorige vraag: Goed!",HState.FIRST_STATE);
                
            }
            else
            {
                txtCorrection.setForeground(new DVBColor(255,0,0,179));
                txtCorrection.setTextContent("Vorige vraag: Fout!",HState.FIRST_STATE);   
            }
            
            this.nextQuestion();
        }
        
    }
    public void nextQuestion()
    {         
        if(this.currentRound == 1)
        {
            if(this.questionCounter < 8)
            {
                //Volgende vraag selecteren
                boolean next = false;
                int randomQ;
                while(next == false)
                {
                    randomQ = (int) (Math.random() * openVragen.length -1);

                    if(this.qAnswered[randomQ] != true)
                    {
                        this.currentQ = randomQ;
                        next = true;
                    }
                }
                System.out.println(this.currentQ);
                //Volgende vraag weergeven
                this.questionCounter ++;
                txtQuestionNumber.setTextContent("Vraag " + this.questionCounter,HState.FIRST_STATE);
                txtQuestion.setTextContent(this.openVragen[this.currentQ][0],HState.FIRST_STATE); 
                this.userAnswer = "";
                txtAnswer.setTextContent(this.userAnswer, HState.FIRST_STATE);
                
            }
            else
            {
                this.startRonde2();
                return;
            }
        }
        else if(this.currentRound == 2)
        {
            if(this.questionCounter < 8)
            {
                //Volgende vraag selecteren
                boolean next = false;
                int randomQ;
                while(next == false)
                {
                    randomQ = (int) (Math.random() * this.meerkeuzeVragen.length -1);

                    if(this.qAnswered[randomQ] != true)
                    {
                        this.currentQ = randomQ;
                        next = true;
                    }
                }
                System.out.println(this.currentQ);
                //Volgende vraag weergeven
                this.questionCounter ++;
                txtQuestionNumber.setTextContent("Vraag " + this.questionCounter,HState.FIRST_STATE);
                txtQuestion.setTextContent(this.meerkeuzeVragen[this.currentQ][0],HState.FIRST_STATE);
                this.userAnswer = "";
                
                txtAntwoord1.setTextContent(this.meerkeuzeVragen[this.currentQ][2], HState.FIRST_STATE);
                txtAntwoord2.setTextContent(this.meerkeuzeVragen[this.currentQ][3], HState.FIRST_STATE);
                txtAntwoord3.setTextContent(this.meerkeuzeVragen[this.currentQ][4], HState.FIRST_STATE);
                txtAntwoord4.setTextContent(this.meerkeuzeVragen[this.currentQ][5], HState.FIRST_STATE);
                
               
            }
            else
            {
                
            }
        }
    }
     public void userEventReceived(UserEvent e) {
        if(this.currentRound == 1)
        {
            if(checkInput)
            {
                if(e.getType() == KeyEvent.KEY_PRESSED)
                {
                    switch(e.getCode())
                    {
                        case HRcEvent.VK_A:
                            userAnswer += "A";
                            break;
                        case HRcEvent.VK_B:
                            userAnswer += "B";
                            break;
                        case HRcEvent.VK_C:
                            userAnswer += "C";
                            break;
                        case HRcEvent.VK_D:
                            userAnswer += "D";
                            break;
                        case HRcEvent.VK_E:
                            userAnswer += "E";
                            break;
                        case HRcEvent.VK_F:
                            userAnswer += "F";
                            break;
                        case HRcEvent.VK_G:
                            userAnswer += "G";
                            break;
                        case HRcEvent.VK_H:
                            userAnswer += "H";
                            break;
                        case HRcEvent.VK_I:
                            userAnswer += "I";
                            break;
                        case HRcEvent.VK_J:
                            userAnswer += "J";
                            break;
                        case HRcEvent.VK_K:
                            userAnswer += "K";
                            break;
                        case HRcEvent.VK_L:
                            userAnswer += "L";
                            break;
                        case HRcEvent.VK_M:
                            userAnswer += "M";
                            break;
                        case HRcEvent.VK_N:
                            userAnswer += "N";
                            break;
                        case HRcEvent.VK_O:
                            userAnswer += "O";
                            break;
                        case HRcEvent.VK_P:
                            userAnswer += "P";
                            break;
                        case HRcEvent.VK_Q:
                            userAnswer += "Q";
                            break;
                        case HRcEvent.VK_R:
                            userAnswer += "R";
                            break;
                        case HRcEvent.VK_S:
                            userAnswer += "S";
                            break;
                        case HRcEvent.VK_T:
                            userAnswer += "T";
                            break;
                        case HRcEvent.VK_U:
                            userAnswer += "U";
                            break;
                        case HRcEvent.VK_V:
                            userAnswer += "V";
                            break;
                        case HRcEvent.VK_W:
                            userAnswer += "W";
                            break;
                        case HRcEvent.VK_X:
                            userAnswer += "X";
                            break;
                        case HRcEvent.VK_Y:
                            userAnswer += "Y";
                            break;
                        case HRcEvent.VK_Z:
                            userAnswer += "Y";
                            break;
                        case HRcEvent.VK_SPACE:
                            userAnswer += " ";
                            break;
                        case HRcEvent.VK_ENTER:
                            this.checkAnswer();
                            break;
                        case HRcEvent.VK_BACK_SPACE:
                            if(userAnswer.length() > 0)
                            {
                                userAnswer = userAnswer.substring(0, userAnswer.length() -1);
                            }
                            break;

                    }
                }

            }
            txtAnswer.setTextContent(userAnswer,HState.FIRST_STATE);
            scene.repaint();
        }
    }

}
