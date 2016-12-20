package View;

import Model.Player;
//import Music.MusicPlay;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Baris Poyraz on 8.12.2016.
 */
public class CanvasView extends JPanel {

    //Instances for View Classes
    private MainMenuPanel mainMenuPanel;
    private PlayerSelectionPanel playerSelectionPanel;
    private static AddPlayerPanel addPlayerPanel;
    private SettingsPanel settingsPanel;
    private CreditsPanel creditsPanel;
    private HelpPanel helpPanel;
    private PlayerScreenPanel playerScreenPanel;
    private RemovePlayerPanel removePlayerPanel;

   // private MusicPlay musicPlay;

    //Strings for CardLayout: Switching from Panels
    private final String mainMenu = "Main Menu";
    private final String playerSelection = "Player Selection";
    private final String addPlayer = "Add Player";
    private final String settingsMenu = "Settings Menu";
    private final String creditsMenu = "Credits Menu";
    private final String helpMenu = "Help Menu";
    private final String playerScreen = "Player Screen";
    private final String removePlayer = "Remove Player";

    public Player[] players;
    private Player player;
    private int playerNumber;
    private int currentPlayerNumber = 1;
    private int indexRemovePlayer = -1;


    //TODO: ADD ALL PANELS IN CANVASVIEW

    //Constructor for CanvasView
    public CanvasView(){

        super(new CardLayout());
        //musicPlay = new MusicPlay();

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

    public void removePlayer(){
        for(int i = 0; i< playerNumber; i++)
            System.out.println("şu an bulunan player isimleri: " + players[i].getName());
        players[indexRemovePlayer] = null;
        System.out.println("remove ettim");
        for(int i = 0; i< playerNumber; i++);
            //System.out.println("şu an bulunan player isimleri: " + players[i].getName());
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber1){
        playerNumber = playerNumber1;
        //playerScreenPanel.setPlayerNumber(playerNumber);
    }

    public int getCurrentPlayerNumber(){
        return currentPlayerNumber;
    }

    public void setCurrentPlayerNumber(int currentPlayerNumber1){
        currentPlayerNumber = currentPlayerNumber1;
    }

    public Player[] getPlayers(){
        return players;
    }

    public void setPlayers(Player[] players1){
       // players = new Player[playerNumber];
        players = players1;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player p){
        player = p;
        players[getCurrentPlayerNumber()-1] =player;
    }

    public void setIndexRemovePlayer(int indexRemovePlayer){
        this.indexRemovePlayer = indexRemovePlayer;
        System.out.println("canvasta removeIndex i set ettim: " + indexRemovePlayer);
    }

    public int getIndexRemovePlayer(){
        return indexRemovePlayer;
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
        addPlayerPanel.setRemoveIndex(indexRemovePlayer);
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

    public String getRemovePlayer(){
        removePlayerPanel = new RemovePlayerPanel(this);
        super.add(removePlayerPanel, removePlayer);
        return removePlayer;
    }

    public String getPlayerScreen(){
        playerScreenPanel = new PlayerScreenPanel(this);
        super.add(playerScreenPanel, playerScreen);
        return playerScreen;
    }

    //public MusicPlay getMusicPlay(){
      //  return musicPlay;
    //}
}