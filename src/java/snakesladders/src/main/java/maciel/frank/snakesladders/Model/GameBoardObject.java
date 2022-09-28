package maciel.frank.snakesladders.Model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class GameBoardObject {
  private int currentPlayer;
  private ArrayList<PlayerObject> playerList;
  private DieObject dieOne;
  private DieObject dieTwo;
  private ArrayList<SnakeObject> snakeList;
  private ArrayList<LadderObject> ladderList;
  private int diceSum;
  private int winner;

  // Constructors
  public GameBoardObject(){

  }

  public GameBoardObject(int dieOneSides, int dieTwoSides, ArrayList<SnakeObject> snakeList, ArrayList<LadderObject> ladderList){
    setPlayerList();
    dieOne = new DieObject(dieOneSides);
    dieTwo = new DieObject(dieTwoSides);
    this.snakeList = snakeList;
    this.ladderList = ladderList;
    currentPlayer = 0;
    winner = 0;
  }


    //SETTERS
  public void setWinner(int winner){
    this.winner = winner;
  }
  public void setPlayerList(){
    playerList = new ArrayList<>();
    playerList.add(new PlayerObject(1));
    playerList.add(new PlayerObject(2));
    playerList.add(new PlayerObject(3));
    playerList.add(new PlayerObject(4));
  }
  public void setPlayerList(ArrayList<PlayerObject> playerList) {
    this.playerList = playerList;
  }
  public void setDiceSum(int diceSum){
    this.diceSum = diceSum;
  }
  public void setDieOne(DieObject dieOne) {
    this.dieOne = dieOne;
  }
  public void setDieTwo(DieObject dieTwo) {
    this.dieTwo = dieTwo;
  }
  public void setSnakeList(ArrayList<SnakeObject> snakeList){
    this.snakeList = snakeList;
  }
  public void setLadderList(ArrayList<LadderObject> ladderList){
    this.ladderList = ladderList;
  }
  public void setCurrentPlayer(int currentPlayer){
    this.currentPlayer = currentPlayer;
  }


  //GETTERS
  public int getWinner(){
    return this.winner;
  }
  public ArrayList<PlayerObject> getPlayerList(){
    return playerList;
  }

  public ArrayList<LadderObject> getLadderList() {
    return ladderList;
  }

  public ArrayList<SnakeObject> getSnakeList() {
    return snakeList;
  }

  public int getDiceSum(){
  return diceSum;
}

  public DieObject getDieOne() {
  return dieOne;
  }

  public DieObject getDieTwo() {
    return dieTwo;
  }

  public int getCurrentPlayer() {
    return currentPlayer;
  }




}
