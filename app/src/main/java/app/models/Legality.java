
package app.models;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Legality {

    private String format;
    private String legality;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Legality() {
    }

    /**
     * 
     * @param legality
     * @param format
     */
    public Legality(String format, String legality) {
        this.format = format;
        this.legality = legality;
    }

    /**
     * 
     * @return
     *     The format
     */
    public String getFormat() {
        return format;
    }

    /**
     * 
     * @param format
     *     The format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * 
     * @return
     *     The legality
     */
    public String getLegality() {
        return legality;
    }

    /**
     * 
     * @param legality
     *     The legality
     */
    public void setLegality(String legality) {
        this.legality = legality;
    }

}
