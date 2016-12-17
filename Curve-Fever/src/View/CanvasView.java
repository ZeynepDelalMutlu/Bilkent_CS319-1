package View;

import Music.MusicPlay;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Baris Poyraz on 8.12.2016.
 */
public class CanvasView extends JPanel {

    //Instances for View Classes
    private MainMenuPanel mainMenuPanel;
    private PlayerSelectionPanel playerSelectionPanel;
    private AddPlayerPanel addPlayerPanel;
    private SettingsPanel settingsPanel;
    private CreditsPanel creditsPanel;
    private HelpPanel helpPanel;
    private MusicPlay musicPlay;

    //Strings for CardLayout: Switching from Panels
    private final String mainMenu = "Main Menu";
    private final String playerSelection = "Player Selection";
    private final String addPlayer = "Add Player";
    private final String settingsMenu = "Settings Menu";
    private final String creditsMenu = "Credits Menu";
    private final String helpMenu = "Help Menu";

    //TODO: ADD ALL PANELS IN CANVASVIEW

    //Constructor for CanvasView
    public CanvasView(){

        super(new CardLayout());
        musicPlay = new MusicPlay();
        //Creates each panel
        mainMenuPanel = new MainMenuPanel(this);
        playerSelectionPanel = new PlayerSelectionPanel(this);
        addPlayerPanel = new AddPlayerPanel(this);
        settingsPanel = new SettingsPanel(this);
        creditsPanel = new CreditsPanel(this);
        helpPanel = new HelpPanel(this);

        //Puts each panel in CardLayout making switching from panels easier
        super.add(mainMenuPanel, mainMenu);
        super.add(playerSelectionPanel, playerSelection);
        super.add(addPlayerPanel, addPlayer);
        super.add(settingsPanel, settingsMenu);
        super.add(creditsPanel, creditsMenu);
        super.add(helpPanel, helpMenu);
    }

    /**
     * Main Menu Panel String for CardLayout
     * @return mainMenu Key String for CardLayout
     */
    public String getMainMenu(){
        return mainMenu;
    }

    /**
     * Player Selection Panel String for CardLayout
     * @return playerSelection Key String for CardLayout
     */
    public String getPlay(){
        return playerSelection;
    }

    public String getAddPlayer(){
        return addPlayer;
    }

    /**
     * Settings Panel String for CardLayout
     * @return settingsMenu Key String for CardLayout
     */
    public String getSettings(){
        return settingsMenu;
    }

    /**
     * Help Panel String for CardLayout
     * @return helpMenu Key String for CardLayout
     */
    public String getHelp(){
        return helpMenu;
    }

    /**
     * Credits Panel String for CardLayout
     * @return creditsMenu Key String for CardLayout
     */
    public String getCredits(){
        return creditsMenu;
    }

    public MusicPlay getMusicPlay(){
        return musicPlay;
    }
}
