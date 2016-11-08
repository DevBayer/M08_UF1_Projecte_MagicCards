package app.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.models.Card;
import lluis.bayersoler.com.magiccards.R;

public class CardsAdapter extends ArrayAdapter<Card> {

    public CardsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public CardsAdapter(Context context, List<Card> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenim el objecte Cards (segons la posició en la que es troba)
        Card card = getItem(position);

        // Comprovem que la View no estigui reutilitzada, i la inflem
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cardlist_row, parent, false);
        }

        // Carreguem la vista cardName que es el TextView
        TextView cardName = (TextView) convertView.findViewById(R.id.cardName);
        cardName.setText(card.getName());

        // Carreguem la vista cardType que es el TextView
        TextView cardType = (TextView) convertView.findViewById(R.id.cardType);
        cardType.setText(card.getType());

        // Carreguem la vista cardImage que es el ImageView i utilitzem Glide
        ImageView cardImage = (ImageView) convertView.findViewById(R.id.cardImage);
        cardImage.setScaleType(ImageView.ScaleType.CENTER);
        Glide.with(getContext())
                .load(card.getImageUrl())
                .dontAnimate()
                .placeholder(R.drawable.card)
                .into(cardImage);


        /*
            W -> YELLOW (Sol)
            U -> BLUE (water)
            B -> GREY (calavera)
            R -> RED (fire)
            G -> GREEN (tree)
        */


        TextView manaCost = (TextView) convertView.findViewById(R.id.txtManaCost);
        //manaCost.setText(card.getCmc()+" Mana Cost");

        String manastr = "";
        if(card.getManaCost() != null){
            Pattern pattern = Pattern.compile("([A-Z0-9])+");
            Matcher matcher = pattern.matcher(card.getManaCost());
            while (matcher.find()) {
                for (int i = 0; i < matcher.groupCount(); i++) {
                    System.out.println(i+" ->> "+matcher.group(i));
                }
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
                    //manastr += matcher.group();
            }
            manaCost.setText(manastr);

            manaCost.setText(Html.fromHtml(manastr, new Html.ImageGetter(){

                @Override
                public Drawable getDrawable(String source) {
                    Drawable drawable;
                    int dourceId =
                            getContext()
                                    .getResources()
                                    .getIdentifier(source, "drawable", getContext().getPackageName());

                    drawable =
                            getContext()
                                    .getResources()
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

                    drawable.setBounds(
                            0,
                            0,
                            32, //drawable.getIntrinsicWidth(),
                            32); //drawable.getIntrinsicHeight());

                    return drawable;
                }

            }, null));


        }


        TextView PowerToughness = (TextView) convertView.findViewById(R.id.txtPowerToughness);
        PowerToughness.setText(card.getPower()+"/"+card.getToughness());


        return convertView;
    }
}