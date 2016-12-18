package View;

import javax.swing.*;
import java.awt.*;
import Model.Player;

public class CanvasView extends JPanel {

    //Instances for View Classes
    private MainMenuPanel mainMenuPanel;
    private PlayerSelectionPanel playerSelectionPanel;
    private AddPlayerPanel addPlayerPanel;
    private SettingsPanel settingsPanel;
    private CreditsPanel creditsPanel;
    private HelpPanel helpPanel;

    //Strings for CardLayout: Switching from Panels
    private final String mainMenu = "Main Menu";
    private final String playerSelection = "Player Selection";
    private final String addPlayer = "Add Player";
    private final String settingsMenu = "Settings Menu";
    private final String creditsMenu = "Credits Menu";
    private final String helpMenu = "Help Menu";
    private int playerNumber;
    private int currentPlayerNumber = 1;
    private Player[] players;
    String currentPlayerName;

    //TODO: ADD ALL PANELS IN CANVASVIEW

    //Constructor for CanvasView
    public CanvasView(){

        super(new CardLayout());

        //Creates each panel
        mainMenuPanel = new MainMenuPanel(this);
        playerSelectionPanel = new PlayerSelectionPanel(this);
        settingsPanel = new SettingsPanel(this);
        creditsPanel = new CreditsPanel(this);
        helpPanel = new HelpPanel(this);

        //Puts each panel in CardLayout making switching from panels easier
        super.add(mainMenuPanel, mainMenu);
        super.add(playerSelectionPanel, playerSelection);
        super.add(settingsPanel, settingsMenu);
        super.add(creditsPanel, creditsMenu);
        super.add(helpPanel, helpMenu);
    }

    public String getMainMenu(){
        return mainMenu;
    }

    public String getPlay(){
        currentPlayerNumber = 1;
        playerNumber=playerSelectionPanel.getPlayerSize();
        return playerSelection;
    }
    /*public String getAddPlayer(){
        playerNumber = playerSelectionPanel.getPlayerSize();
        addPlayerPanel = new AddPlayerPanel( currentPlayerNumber, playerNumber, this);
        super.add(addPlayerPanel, addPlayer);
        return addPlayer;
    }*/

    public String getAddPlayer(String currentPlayerName){
        System.out.println("CANVAS");
        this.currentPlayerName = currentPlayerName;
        playerNumber = playerSelectionPanel.getPlayerSize();
        addPlayerPanel = new AddPlayerPanel( currentPlayerNumber, playerNumber, this);
        super.add(addPlayerPanel, addPlayer);
        System.out.println(playerNumber + " canvastayım " + currentPlayerNumber);
        if(currentPlayerNumber == 1){
            players = new Player[playerNumber];
            players[currentPlayerNumber] = new Player(currentPlayerName);
            System.out.println("BURADAYIM currentplayer=1");
            //(players[currentPlayerNumber]).toString();
            System.out.println("canvasta birinci player if'indeki name: " +currentPlayerName);
        }
        /*else{
            players[currentPlayerNumber] = new Player(currentPlayerName);
            System.out.println("ASLINDA BURADAYIM");
            players[currentPlayerNumber].toString();
        }*/
        //System.out.println("canvastaki en alt yer: "+currentPlayerName);
        currentPlayerNumber++;
        return addPlayer;
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
