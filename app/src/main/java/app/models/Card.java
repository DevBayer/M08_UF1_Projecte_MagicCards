
package app.models;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Card implements Serializable {

    private String name;
    private String manaCost;
    private Double cmc;
    private List<String> colorIdentity = new ArrayList<String>();
    private String type;
    private List<String> types = new ArrayList<String>();
    private String rarity;
    private String text;
    private String flavor;
    private String artist;
    private String power;
    private String toughness;
    private String imageUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Card() {
    }

    /**
     *
     * @param imageUrl
     * @param type
     * @param colorIdentity
     * @param id
     * @param name
     * @param power
     * @param manaCost
     * @param artist
     * @param toughness
     * @param types
     * @param subtypes
     * @param text
     * @param rarity
     * @param flavor
     * @param cmc
     */
    public Card(String name, String manaCost, Double cmc, List<String> colorIdentity, String type, List<String> types, String rarity, String text, String flavor, String artist, String power, String toughness, String imageUrl) {
        this.name = name;
        this.manaCost = manaCost;
        this.cmc = cmc;
        this.type = type;
        this.rarity = rarity;
        this.text = text;
        this.flavor = flavor;
        this.artist = artist;
        this.power = power;
        this.toughness = toughness;
        this.imageUrl = imageUrl;
        this.colorIdentity = colorIdentity;
        this.types = types;
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
    public Double getCmc() {
        return cmc;
    }

    /**
     * 
     * @param cmc
     *     The cmc
     */
    public void setCmc(Double cmc) {
        this.cmc = cmc;
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
    public void _setColorIdentity(List<String> colorIdentity) {
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

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    /**
     *
     * Icons: W -> YELLOW (Sol), U -> BLUE (water), B -> GREY (calavera), R -> RED (fire), G -> GREEN (tree)
     * @param textView
     * @param cost
     */
    @BindingAdapter("manaCost")
    public static void setManaCost(final TextView textView, String cost){
        if(cost != null){
            String manastr = "";
            Pattern pattern = Pattern.compile("([A-Z0-9])+");
            Matcher matcher = pattern.matcher(cost);
            while (matcher.find()) {
                if(matcher.group().matches("[0-9]+")){
                    manastr += matcher.group();
                }else{
                    if(matcher.group().equals("W")){
                        manastr += "<img src='weather_sunny' />";
                    }else if(matcher.group().equals("U")){
                        manastr += "<img src='water' />";
                    }else if(matcher.group().equals("B")){
                        manastr += "<img src='skull' />";
                    }else if(matcher.group().equals("R")){
                        manastr += "<img src='pine_tree' />";
                    }
                }
            }
            textView.setText(manastr);

            textView.setText(Html.fromHtml(manastr, new Html.ImageGetter(){

                @Override
                public Drawable getDrawable(String source) {
                    Drawable drawable;
                    Context context = textView.getContext();
                    int dourceId = context.getResources()
                                    .getIdentifier(source, "drawable", context.getPackageName());
                    drawable = context.getResources()
                                    .getDrawable(dourceId);

                    if(source.equals("water")){
                        drawable.setColorFilter(Color.parseColor("#33CCFF"), PorterDuff.Mode.SRC_ATOP);
                    }else if(source.equals("weather_sunny")){
                        drawable.setColorFilter(Color.parseColor("#FF6633"), PorterDuff.Mode.SRC_ATOP);
                    }else if(source.equals("webhook")){
                        drawable.setColorFilter(Color.parseColor("#B82E00"), PorterDuff.Mode.SRC_ATOP);
                    }else if(source.equals("skull")){
                        drawable.setColorFilter(Color.parseColor("#3D3D3D"), PorterDuff.Mode.SRC_ATOP);
                    }else if(source.equals("pine_tree")){
                        drawable.setColorFilter(Color.parseColor("#33CC00"), PorterDuff.Mode.SRC_ATOP);
                    }

                    drawable.setBounds(0, 0, 32, 32);

                    return drawable;
                }

            }, null));
        }else{
            textView.setText("");
        }
    }

    public String getPowerToughness(){
        String power = this.getPower();
        String toughness = this.getPower();
        if(power == null) power = ""+0;
        if(toughness == null) toughness = ""+0;
        if(power.equals("0") && toughness.equals("0")){
            return "";
        }else {
            return power + "/" + toughness;
        }
    }

}
