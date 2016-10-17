package app.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 23878410v on 14/10/16.
 */

public class Card {
    private String name;
    private JSONArray names;
    private String manaCost;
    private int cmc;
    private JSONArray colors;
    private String type;
    private JSONArray subtypes;
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
    private JSONArray rulings;
    private JSONArray foreignNames;
    private JSONArray printings;
    private String originalText;
    private String originalType;
    private String id;


    public Card(String name, JSONArray names, String manaCost, int cmc, JSONArray colors, String type, JSONArray subtypes, String rarity, String set, String text, String artist, String number, int power, int toughness, String layout, float multiverseid, String imageUrl, JSONArray rulings, JSONArray foreignNames, JSONArray printings, String originalText, String originalType, String id) {
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

    public Card(JSONObject jsonObject) throws JSONException, NoSuchFieldException, IllegalAccessException {

        /**
         * Manera dinámica,
         * Observació: podría ser millor crear un String[] amb el nom dels atributs,
         * (o si tenim algún atribut que no surt al JSON, fer un filtre per als que començin amb "_")
         */
        for (Field a: Card.class.getDeclaredFields()) {
            if(jsonObject.has(a.getName())){
                if(a.getType().equals(String.class)){
                    Log.d("Card::String", a.getName());
                    a.set(this, jsonObject.getString(a.getName()));
                }else if(a.getType().equals(Integer.class)){
                    Log.d("Card::Integer", a.getName());
                    a.set(this, Integer.parseInt(jsonObject.getString(a.getName())));
                }else if(a.getType().equals(JSONArray.class)){
                    Log.d("Card::JSONArray", a.getName());
                    a.set(this, jsonObject.get(a.getName()));
                }else if(a.getType().equals(Float.class)){
                    Log.d("Card::Float", a.getName());
                    a.set(this, Float.parseFloat(jsonObject.getString(a.getName())));
                }else{
                    Log.d("no parsed:", a.getName());
                }
            }
        }

        /**
         * Manera "estática"(antiga)
        this.name = jsonObject.getString("name");
        this.names = jsonObject.optJSONArray("names");
        this.manaCost = jsonObject.getString("manaCost");
        this.cmc = Integer.parseInt(jsonObject.getString("cmc"));
        this.colors = jsonObject.optJSONArray("colors");
        this.type = jsonObject.getString("type");
        this.subtypes = jsonObject.optJSONArray("subtypes");
        this.rarity = jsonObject.getString("rarity");
        this.set = jsonObject.getString("set");
        this.text = jsonObject.getString("text");
        this.artist = jsonObject.getString("artist");
        if(jsonObject.has("number")){
            this.number = jsonObject.getString("number");
        }
        if(jsonObject.has("power")) {
            this.power = Integer.parseInt(jsonObject.getString("power"));
        }
        this.toughness = Integer.parseInt(jsonObject.getString("toughness"));
        this.layout = jsonObject.getString("layout");
        this.multiverseid = Float.parseFloat(jsonObject.getString("multiverseid"));
        this.imageUrl = jsonObject.getString("imageUrl");
        this.rulings = jsonObject.optJSONArray("rulings");
        this.foreignNames = jsonObject.optJSONArray("foreignNames");
        this.printings = jsonObject.optJSONArray("printings");
        this.originalText = jsonObject.getString("originalText");
        this.originalType = jsonObject.getString("originalType");
        this.id = jsonObject.getString("id");
         */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONArray getNames() {
        return names;
    }

    public void setNames(JSONArray names) {
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

    public JSONArray getColors() {
        return colors;
    }

    public void setColors(JSONArray colors) {
        this.colors = colors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JSONArray getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(JSONArray subtypes) {
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

    public JSONArray getRulings() {
        return rulings;
    }

    public void setRulings(JSONArray rulings) {
        this.rulings = rulings;
    }

    public JSONArray getForeignNames() {
        return foreignNames;
    }

    public void setForeignNames(JSONArray foreignNames) {
        this.foreignNames = foreignNames;
    }

    public JSONArray getPrintings() {
        return printings;
    }

    public void setPrintings(JSONArray printings) {
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

    public Bitmap getImageBitmap() throws MalformedURLException, IOException {
        URL url = new URL(this.imageUrl);
        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        return bmp;
    }
}
