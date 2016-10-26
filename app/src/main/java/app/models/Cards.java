
package app.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Cards {

    private List<Card> cards = new ArrayList<Card>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cards() {
    }

    /**
     * 
     * @param cards
     */
    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * 
     * @return
     *     The cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * 
     * @param cards
     *     The cards
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
