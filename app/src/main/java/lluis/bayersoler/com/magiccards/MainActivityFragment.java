package lluis.bayersoler.com.magiccards;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import app.InitialData;
import app.api.Card;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private JSONObject data;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> cards;

    public MainActivityFragment() {
        InputStreamReader file = new InputStreamReader(getResources().openRawResource(R.raw.initial_json));
        InitialData iData = new InitialData(file);
        cards = iData.getCards();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_main, container, false);

        ListView CardList = (ListView) fragment.findViewById(R.id.CardList);
        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.cardlist_row,
                R.id.CardList,
                cards
        );

        Log.d("test", cards.toString());

        CardList.setAdapter(adapter);

        return fragment;
    }
}
