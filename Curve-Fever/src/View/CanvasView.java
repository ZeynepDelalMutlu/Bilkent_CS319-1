package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Baris Poyraz on 8.12.2016.
 */
public class CanvasView extends JPanel {

    private MainMenuPanel mainMenuPanel;
    private CreditsPanel creditsPanel;
    private HelpPanel helpPanel;

    private final String mainMenu = "Main Menu";
    private final String play = "Play";
    private final String settingsMenu = "Settings Menu";
    private final String creditsMenu = "Credits Menu";
    private final String helpMenu = "Help Menu";

    private CardLayout cardLayout;

    //TODO: ADD ALL PANELS IN CANVASVIEW

    public CanvasView(){

        super(new CardLayout());

        mainMenuPanel = new MainMenuPanel(this);
        creditsPanel = new CreditsPanel(this);
        helpPanel = new HelpPanel(this);

        super.add(mainMenuPanel, mainMenu);
        super.add(creditsPanel, creditsMenu);
        super.add(helpPanel, helpMenu);
    }

    public String getMainMenu(){
        return mainMenu;
    }

    public String getPlay(){
        return play;
    }

    public String getSettings(){
        return settingsMenu;
    }

    public String getHelp(){
        return helpMenu;
    }

    public String getCredits(){
        return creditsMenu;
    }

}
