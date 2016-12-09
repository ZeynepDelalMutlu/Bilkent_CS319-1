package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Baris Poyraz on 8.12.2016.
 */
public class CanvasView extends JPanel {

    //Instances for View Classes
    private MainMenuPanel mainMenuPanel;
    private SettingsPanel settingsPanel;
    private CreditsPanel creditsPanel;
    private HelpPanel helpPanel;

    //Strings for CardLayout: Switching from Panels
    private final String mainMenu = "Main Menu";
    private final String playerSelection = "Player Selection";
    private final String settingsMenu = "Settings Menu";
    private final String creditsMenu = "Credits Menu";
    private final String helpMenu = "Help Menu";

    //TODO: ADD ALL PANELS IN CANVASVIEW

    //Constructor for CanvasView
    public CanvasView(){

        super(new CardLayout());

        //Creates each panel
        mainMenuPanel = new MainMenuPanel(this);
        settingsPanel = new SettingsPanel(this);
        creditsPanel = new CreditsPanel(this);
        helpPanel = new HelpPanel(this);

        //Puts each panel in cardlayout making switching from panels easier
        super.add(mainMenuPanel, mainMenu);
        super.add(settingsPanel, settingsMenu);
        super.add(creditsPanel, creditsMenu);
        super.add(helpPanel, helpMenu);
    }

    /**
     * Main Menu Panel String for CardLayout
     * @return mainMenu
     */
    public String getMainMenu(){
        return mainMenu;
    }

    /**
     * Player Selection Panel String for CardLayout
     * @return playerSelection
     */
    public String getPlay(){
        return playerSelection;
    }

    /**
     * Settings Panel String for CardLayout
     * @return settingsMenu
     */
    public String getSettings(){
        return settingsMenu;
    }

    /**
     * Help Panel String for CardLayout
     * @return helpMenu
     */
    public String getHelp(){
        return helpMenu;
    }

    /**
     * Credits Panel String for CardLayout
     * @return creditsMenu
     */
    public String getCredits(){
        return creditsMenu;
    }

}
