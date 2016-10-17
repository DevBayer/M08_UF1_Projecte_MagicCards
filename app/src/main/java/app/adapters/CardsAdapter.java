package app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.api.Card;
import lluis.bayersoler.com.magiccards.R;

public class CardsAdapter extends ArrayAdapter<Card> {
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

        return convertView;
    }
}