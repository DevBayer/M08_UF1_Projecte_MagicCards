package app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

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
        Glide.with(getContext()).load(card.getImageUrl()).crossFade().into(cardImage);

        TextView manaCost = (TextView) convertView.findViewById(R.id.txtManaCost);
        manaCost.setText(card.getCmc()+" Mana Cost");

        TextView Power = (TextView) convertView.findViewById(R.id.txtPower);
        Power.setText(card.getPower()+" Power");

        TextView Toughness = (TextView) convertView.findViewById(R.id.txtToughness);
        Toughness.setText(card.getToughness()+" Toughness");


        return convertView;
    }
}