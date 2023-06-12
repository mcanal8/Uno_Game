package game;

import java.util.List;

public class Player {
    private final int Id;
    private List<Card> playerDeck;

    public Player(int id){
        this.Id = id;
    }

    public void setPlayerDeck(List<Card> playerDeck) { this.playerDeck = playerDeck; }

    public List<Card> getPlayerDeck() { return playerDeck; }

    public int getId() { return Id; }
}
