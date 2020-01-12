package client;

import java.util.ArrayList;

/**
 * Class that encapsulates user details in a user object.
 */
public class User {

    private int userID;
    private String nickname;
    private transient long points;
    private int gamesLost;
    private int gamesWon;
    private transient ArrayList<GameDetails> gameHistory;

    /**
     * Constructor for client.User class.
     * @param userID id of the user (as stored in database)
     * @param nickname the name of the user that appears in game
     * @param points number of points the user has
     * @param gamesLost number of games lost
     * @param gamesWon number of games won
     */
    public User(int userID, String nickname, long points, int gamesLost, int gamesWon) {
        this.userID = userID;
        this.points = points;
        this.nickname = nickname;
        this.gamesLost = gamesLost;
        this.gamesWon = gamesWon;
        this.gameHistory = new ArrayList<>();
    }

    public User(){}

    public int getUserID() {
        return userID;
    }

    public void setUserId(int userID) {
        this.userID = userID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getPoints() {
        return points;
    }

    public void addPoints(long newPoints) {
        this.points += newPoints;
    }

    public ArrayList<GameDetails> getGameHistory() {
        return gameHistory;
    }

    public void addGame(GameDetails newGame) {
        this.gameHistory.add(newGame);
    }

    public void addLostGame() {
        this.gamesLost++;
    }

    public void addWonGame() {
        this.gamesWon++;
    }

    public int getNumOfLostGames() {
        return  this.gamesLost;
    }

    public void setNumOfLostGames(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getNumOfWonGames() {
        return  this.gamesWon;
    }

    public void setNumOfWonGames(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getNumOfGamesPlayed() {
        return  this.gamesLost + this.gamesWon;
    }

}
