
package app.models;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Ruling {

    private String date;
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ruling() {
    }

    /**
     * 
     * @param text
     * @param date
     */
    public Ruling(String date, String text) {
        this.date = date;
        this.text = text;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

}
