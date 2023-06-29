package game;

import java.util.List;

public class Player {
    private final int Id;
    private List<Card> playerDeck;
    private boolean uno;

    public Player(int id){
        this.uno = false;
        this.Id = id;
    }

    public void setPlayerDeck(List<Card> playerDeck) { this.playerDeck = playerDeck; }

    public List<Card> getPlayerDeck() { return playerDeck; }

    public int getId() { return Id; }

    public boolean isUno() { return uno; }

    public void setUno(boolean uno) { this.uno = uno; }
}
