
package app.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Card {

    private List<Card_> cards = new ArrayList<Card_>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Card() {
    }

    /**
     * 
     * @param cards
     */
    public Card(List<Card_> cards) {
        this.cards = cards;
    }

    /**
     * 
     * @return
     *     The cards
     */
    public List<Card_> getCards() {
        return cards;
    }

    /**
     * 
     * @param cards
     *     The cards
     */
    public void setCards(List<Card_> cards) {
        this.cards = cards;
    }

}
