package lluis.bayersoler.com.magiccards;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.io.InputStreamReader;
import java.util.ArrayList;
import app.InitialData;
import app.adapters.CardsAdapter;
import app.api.ApiController;
import app.api.Card;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ArrayList<Card> cards;
    private ListView CardList;
    private CardsAdapter adapter;

    public MainActivityFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_main, container, false);

        InputStreamReader file = new InputStreamReader(getResources().openRawResource(R.raw.initial_json));
        InitialData iData = new InitialData(file);
        cards = iData.getCards();

        CardList = (ListView) fragment.findViewById(R.id.CardList);

        adapter = new CardsAdapter(getContext(), cards);

        CardList.setAdapter(adapter);

        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void refresh() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }



    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Card>> {
        @Override
        protected ArrayList<Card> doInBackground(Void... voids) {

            ArrayList<Card> result;
                result = ApiController.GetAllCards(1, 25);

            //Log.d("DEBUG", result != null ? result.toString() : null);

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Card> cards) {
            adapter.clear();
            if(cards != null){
                for (Card card : cards) {
                    adapter.add(card);
                }
            }
        }
    }

}
