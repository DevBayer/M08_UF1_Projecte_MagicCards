package app.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import app.api.ApiController;
import app.api.Card;
import app.exceptions.ApiControllerException;
import lluis.bayersoler.com.magiccards.R;

public class CardsAdapter extends ArrayAdapter<Card> {

    private ImageView cardImage;

    public CardsAdapter(Context context, ArrayList<Card> cards) {
        super(context, 0, cards);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtenim el objecte Card (segons la posició en la que es troba)
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
        cardImage = (ImageView) convertView.findViewById(R.id.cardImage);
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