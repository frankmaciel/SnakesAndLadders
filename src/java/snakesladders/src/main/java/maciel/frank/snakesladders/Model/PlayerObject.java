package maciel.frank.snakesladders.Model;

public class PlayerObject {

    private int playerID;
    private int currentPosition;

    public PlayerObject(int playerID){
        this.playerID = playerID;
        currentPosition = 0;
    }

    public void setCurrentPosition(int currentPosition){
        this.currentPosition = currentPosition;
    }
    public void incrementCurrentPosition(int incrementPosition){
    this.currentPosition += incrementPosition;
  }
    public void decrementCurrentPosition(int decrementPosition){this.currentPosition -= decrementPosition;}
    public int getPlayerID(){
        return playerID;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }


}
