
package app.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Card_ {

    private String name;
    private String manaCost;
    private int cmc;
    private List<String> colors = new ArrayList<String>();
    private List<String> colorIdentity = new ArrayList<String>();
    private String type;
    private List<String> types = new ArrayList<String>();
    private List<String> subtypes = new ArrayList<String>();
    private String rarity;
    private String set;
    private String setName;
    private String text;
    private String flavor;
    private String artist;
    private String power;
    private String toughness;
    private String layout;
    private int multiverseid;
    private String imageUrl;
    private List<String> printings = new ArrayList<String>();
    private String originalText;
    private String originalType;
    private List<Legality> legalities = new ArrayList<Legality>();
    private String id;
    private boolean reserved;
    private List<Ruling> rulings = new ArrayList<Ruling>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Card_() {
    }

    /**
     * 
     * @param imageUrl
     * @param set
     * @param type
     * @param colorIdentity
     * @param id
     * @param rulings
     * @param name
     * @param layout
     * @param power
     * @param manaCost
     * @param artist
     * @param toughness
     * @param types
     * @param subtypes
     * @param text
     * @param colors
     * @param printings
     * @param rarity
     * @param flavor
     * @param reserved
     * @param originalType
     * @param legalities
     * @param cmc
     * @param originalText
     * @param multiverseid
     * @param setName
     */
    public Card_(String name, String manaCost, int cmc, List<String> colors, List<String> colorIdentity, String type, List<String> types, List<String> subtypes, String rarity, String set, String setName, String text, String flavor, String artist, String power, String toughness, String layout, int multiverseid, String imageUrl, List<String> printings, String originalText, String originalType, List<Legality> legalities, String id, boolean reserved, List<Ruling> rulings) {
        this.name = name;
        this.manaCost = manaCost;
        this.cmc = cmc;
        this.colors = colors;
        this.colorIdentity = colorIdentity;
        this.type = type;
        this.types = types;
        this.subtypes = subtypes;
        this.rarity = rarity;
        this.set = set;
        this.setName = setName;
        this.text = text;
        this.flavor = flavor;
        this.artist = artist;
        this.power = power;
        this.toughness = toughness;
        this.layout = layout;
        this.multiverseid = multiverseid;
        this.imageUrl = imageUrl;
        this.printings = printings;
        this.originalText = originalText;
        this.originalType = originalType;
        this.legalities = legalities;
        this.id = id;
        this.reserved = reserved;
        this.rulings = rulings;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The manaCost
     */
    public String getManaCost() {
        return manaCost;
    }

    /**
     * 
     * @param manaCost
     *     The manaCost
     */
    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    /**
     * 
     * @return
     *     The cmc
     */
    public int getCmc() {
        return cmc;
    }

    /**
     * 
     * @param cmc
     *     The cmc
     */
    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    /**
     * 
     * @return
     *     The colors
     */
    public List<String> getColors() {
        return colors;
    }

    /**
     * 
     * @param colors
     *     The colors
     */
    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    /**
     * 
     * @return
     *     The colorIdentity
     */
    public List<String> getColorIdentity() {
        return colorIdentity;
    }

    /**
     * 
     * @param colorIdentity
     *     The colorIdentity
     */
    public void setColorIdentity(List<String> colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The types
     */
    public List<String> getTypes() {
        return types;
    }

    /**
     * 
     * @param types
     *     The types
     */
    public void setTypes(List<String> types) {
        this.types = types;
    }

    /**
     * 
     * @return
     *     The subtypes
     */
    public List<String> getSubtypes() {
        return subtypes;
    }

    /**
     * 
     * @param subtypes
     *     The subtypes
     */
    public void setSubtypes(List<String> subtypes) {
        this.subtypes = subtypes;
    }

    /**
     * 
     * @return
     *     The rarity
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * 
     * @param rarity
     *     The rarity
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * 
     * @return
     *     The set
     */
    public String getSet() {
        return set;
    }

    /**
     * 
     * @param set
     *     The set
     */
    public void setSet(String set) {
        this.set = set;
    }

    /**
     * 
     * @return
     *     The setName
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 
     * @param setName
     *     The setName
     */
    public void setSetName(String setName) {
        this.setName = setName;
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

    /**
     * 
     * @return
     *     The flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * 
     * @param flavor
     *     The flavor
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * 
     * @return
     *     The artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * 
     * @param artist
     *     The artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * 
     * @return
     *     The power
     */
    public String getPower() {
        return power;
    }

    /**
     * 
     * @param power
     *     The power
     */
    public void setPower(String power) {
        this.power = power;
    }

    /**
     * 
     * @return
     *     The toughness
     */
    public String getToughness() {
        return toughness;
    }

    /**
     * 
     * @param toughness
     *     The toughness
     */
    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    /**
     * 
     * @return
     *     The layout
     */
    public String getLayout() {
        return layout;
    }

    /**
     * 
     * @param layout
     *     The layout
     */
    public void setLayout(String layout) {
        this.layout = layout;
    }

    /**
     * 
     * @return
     *     The multiverseid
     */
    public int getMultiverseid() {
        return multiverseid;
    }

    /**
     * 
     * @param multiverseid
     *     The multiverseid
     */
    public void setMultiverseid(int multiverseid) {
        this.multiverseid = multiverseid;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The printings
     */
    public List<String> getPrintings() {
        return printings;
    }

    /**
     * 
     * @param printings
     *     The printings
     */
    public void setPrintings(List<String> printings) {
        this.printings = printings;
    }

    /**
     * 
     * @return
     *     The originalText
     */
    public String getOriginalText() {
        return originalText;
    }

    /**
     * 
     * @param originalText
     *     The originalText
     */
    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    /**
     * 
     * @return
     *     The originalType
     */
    public String getOriginalType() {
        return originalType;
    }

    /**
     * 
     * @param originalType
     *     The originalType
     */
    public void setOriginalType(String originalType) {
        this.originalType = originalType;
    }

    /**
     * 
     * @return
     *     The legalities
     */
    public List<Legality> getLegalities() {
        return legalities;
    }

    /**
     * 
     * @param legalities
     *     The legalities
     */
    public void setLegalities(List<Legality> legalities) {
        this.legalities = legalities;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The reserved
     */
    public boolean isReserved() {
        return reserved;
    }

    /**
     * 
     * @param reserved
     *     The reserved
     */
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    /**
     * 
     * @return
     *     The rulings
     */
    public List<Ruling> getRulings() {
        return rulings;
    }

    /**
     * 
     * @param rulings
     *     The rulings
     */
    public void setRulings(List<Ruling> rulings) {
        this.rulings = rulings;
    }

}
