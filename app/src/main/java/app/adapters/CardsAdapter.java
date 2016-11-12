package app.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
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
import lluis.bayersoler.com.magiccards.databinding.CardlistRowBinding;

public class CardsAdapter extends ArrayAdapter<Card> {
    public CardsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public CardsAdapter(Context context, List<Card> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CardlistRowBinding binding;
        // Obtenim el objecte Cards (segons la posició en la que es troba)
        Card card = getItem(position);

        // Comprovem que la View no estigui reutilitzada, i la inflem
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.cardlist_row, parent, false);
            convertView = binding.getRoot();
        }else{
            binding = (CardlistRowBinding) convertView.getTag();
        }

        binding.setCard(card);
        convertView.setTag(binding);

        return convertView;
    }
}