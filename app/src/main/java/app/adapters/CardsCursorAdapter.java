package app.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.models.Card;
import lluis.bayersoler.com.magiccards.R;
import lluis.bayersoler.com.magiccards.databinding.CardlistRowBinding;

/**
 * Created by Bayer on 15/11/2016.
 */

public class CardsCursorAdapter extends CupboardCursorAdapter<Card> {

    public CardsCursorAdapter(Context context, Class<Card> entityClass) {
        super(context, entityClass);
    }

    @Override
    public void bindView(View view, Context context, Card model) {
        CardlistRowBinding binding = DataBindingUtil.getBinding(view);
        binding.setCard(model);
    }

    @Override
    public View newView(Context context, Card model, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        CardlistRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.cardlist_row, parent, false);
        return binding.getRoot();
    }
}