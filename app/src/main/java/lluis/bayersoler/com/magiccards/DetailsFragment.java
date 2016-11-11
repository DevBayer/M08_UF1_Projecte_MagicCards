package lluis.bayersoler.com.magiccards;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import app.models.Card;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
    private View fragment;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragment = inflater.inflate(R.layout.fragment_details, container, false);
        Intent i = getActivity().getIntent();
        if(i != null){
            Card card = (Card) i.getSerializableExtra("card");
            Log.d("CARDLOAD-> ",card.getName());
            if(card != null){
                loadCardView(card);
            }
        }
        return fragment;
    }

    private void loadCardView(Card card){
        TextView cardName = (TextView) fragment.findViewById(R.id.cardName);
        cardName.setText(card.getName());
        TextView cardType = (TextView) fragment.findViewById(R.id.cardType);
        cardType.setText(card.getType());
        TextView cardDescrption = (TextView) fragment.findViewById(R.id.cardDescrption);
        cardDescrption.setText(card.getFlavor());

        ImageView cardImage = (ImageView) fragment.findViewById(R.id.cardImage);
        Glide.with(getContext())
                .load(card.getImageUrl())
                .dontAnimate()
                .placeholder(R.drawable.card)
                .into(cardImage);
    }

}
