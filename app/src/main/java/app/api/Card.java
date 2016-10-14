package app.api;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by 23878410v on 14/10/16.
 */

public class Card {
    private String name;
    private ArrayList<String> names;
    private String manaCost;
    private int cmc;
    private ArrayList<String> colors;
    private String type;
    private ArrayList<String> subtypes;
    private String rarity;
    private String set;
    private String text;
    private String artist;
    private String number;
    private int power;
    private int toughness;
    private String layout;
    private float multiverseid;
    private String imageUrl;
    private JSONObject rulings;
    private JSONObject foreignNames;
    private ArrayList<String> printings;
    private String originalText;
    private String originalType;
    private String id;


    public Card(String name, ArrayList<String> names, String manaCost, int cmc, ArrayList<String> colors, String type, ArrayList<String> subtypes, String rarity, String set, String text, String artist, String number, int power, int toughness, String layout, float multiverseid, String imageUrl, JSONObject rulings, JSONObject foreignNames, ArrayList<String> printings, String originalText, String originalType, String id) {
        this.name = name;
        this.names = names;
        this.manaCost = manaCost;
        this.cmc = cmc;
        this.colors = colors;
        this.type = type;
        this.subtypes = subtypes;
        this.rarity = rarity;
        this.set = set;
        this.text = text;
        this.artist = artist;
        this.number = number;
        this.power = power;
        this.toughness = toughness;
        this.layout = layout;
        this.multiverseid = multiverseid;
        this.imageUrl = imageUrl;
        this.rulings = rulings;
        this.foreignNames = foreignNames;
        this.printings = printings;
        this.originalText = originalText;
        this.originalType = originalType;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(ArrayList<String> subtypes) {
        this.subtypes = subtypes;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public float getMultiverseid() {
        return multiverseid;
    }

    public void setMultiverseid(float multiverseid) {
        this.multiverseid = multiverseid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public JSONObject getRulings() {
        return rulings;
    }

    public void setRulings(JSONObject rulings) {
        this.rulings = rulings;
    }

    public JSONObject getForeignNames() {
        return foreignNames;
    }

    public void setForeignNames(JSONObject foreignNames) {
        this.foreignNames = foreignNames;
    }

    public ArrayList<String> getPrintings() {
        return printings;
    }

    public void setPrintings(ArrayList<String> printings) {
        this.printings = printings;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
