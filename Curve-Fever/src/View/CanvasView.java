package View;

import Model.Player;
import Controller.Controller;
//import Music.MusicPlay;

import javax.swing.*;
import java.awt.*;

/**
 *  CS-319 PROJECT: CURVE FEWER
 *
 *  Contributers:   Barış Polat         |    Instructor:  Bora Güngören
 *                  Yunus Ölez          |
 *                  Zeynep Delal Mutlu  |
 *
 *  edited on 31.12.2016
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
    private EditPlayerPanel editPlayerPanel;

   // private MusicPlay musicPlay;

    //Strings for CardLayout: Switching from Panels
    private final String mainMenu = "Main Menu";
    private final String playerSelection = "Player Selection";
    private final String addPlayer = "Add Player";
    private final String settingsMenu = "Settings Menu";
    private final String creditsMenu = "Credits Menu";
    private final String helpMenu = "Help Menu";
    private final String playerScreen = "Player Screen";
    private final String editPlayer = "Edit Player";


    public Player[] players;
    private Player player;
    private int playerNumber;
    private int currentPlayerNumber = 1;
    private int indexEditPlayer = -1;
    private int indexRemovePlayer = -1;
    private boolean playersEdited = false;
    private boolean shouldStartGame = false;


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

    public void shouldStartGame(boolean shouldStartGame){
        this.shouldStartGame = shouldStartGame;
    }

    public boolean getShouldStartGame(){
        return shouldStartGame;
    }

    public void setPlayersEdited(boolean playersEdited){
        this.playersEdited = playersEdited;
    }

    public boolean getPlayersEdited(){
        return playersEdited;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber1){
        playerNumber = playerNumber1;
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
        players = players1;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player p){
        players[getCurrentPlayerNumber()-1] = p;
    }

    public void setIndexEditPlayer(int indexEditPlayer){
        this.indexEditPlayer = indexEditPlayer;
    }

    public int getIndexEditPlayer(){
        return indexEditPlayer;
    }

    public int getIndexRemovePlayer(){
        return indexRemovePlayer;
    }

    public void setIndexRemovePlayer(int indexRemovePlayer){
        this.indexRemovePlayer = indexRemovePlayer;
    }

    public void makeEditPlayerNull(){
        players[indexEditPlayer] = null;
    }

    public void deletePlayer(){
        int firstPart;
        int newIndex = 0;
        Player[] newPlayers = new Player[getPlayerNumber()-1];

        if(playerNumber >= 2){
            for(firstPart = 0; firstPart < indexRemovePlayer; firstPart++){
                newPlayers[newIndex] = players[firstPart];
                newIndex++;
            }
            for(int secondPart = firstPart + 1; secondPart < playerNumber; secondPart++){
                newPlayers[newIndex] = players[secondPart];
                newIndex++;
            }
        }
        else{
            System.out.println("HOP EN AZ 2 OYUNCU!");
        }

        players = newPlayers;
        newPlayers = null;
        setIndexRemovePlayer(-1);
        editPlayerPanel.setIndexRemovePlayer(-1);
        setPlayerNumber(playerNumber - 1);
        playerScreenPanel.setPlayerNumber(getPlayerNumber());
        addPlayerPanel.setPlayerNumber(getPlayerNumber());
        playerScreenPanel.setPlayerNumber(getPlayerNumber());
        editPlayerPanel.setPlayerNumber(getPlayerNumber());
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
        players = null;
        setCurrentPlayerNumber(1);
        setPlayerNumber(0);
        addPlayerPanel.setCurrentPlayerNumber(1);
        addPlayerPanel.setPlayerNumber(0);
        return playerSelection;
    }

    public String getAddPlayer(){
        if(getPlayersEdited()) {
            addPlayerPanel.setPlayersEdited(true);
            addPlayerPanel.remove(addPlayerPanel.getBackJButton());
            addPlayerPanel.remove(addPlayerPanel.getContinueJButton());
            addPlayerPanel.add(addPlayerPanel.getOkayJButton());
        }
        if(getIndexEditPlayer() >= 0) {
            addPlayerPanel.setEditIndex(getIndexEditPlayer());
            editPlayerPanel.setIndexEditPlayer(-1);
            addPlayerPanel.setHead("Player#" + (getIndexEditPlayer() +1));
        }
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

    public String getEditPlayer(){
        editPlayerPanel = new EditPlayerPanel(this);
        super.add(editPlayerPanel, editPlayer);
        return editPlayer;
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