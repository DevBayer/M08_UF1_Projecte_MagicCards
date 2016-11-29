package lluis.bayersoler.com.magiccards;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alexvasilkov.events.Events;
import app.adapters.CardsCursorAdapter;
import app.adapters.DataManager;
import app.api.ApiController;
import app.models.Card;
import app.services.ApiService;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private ListView CardList;
    private CardsCursorAdapter adapter;
    private SharedPreferences preferences;
    private ProgressDialog dialog;
    private Snackbar snack;

    @Override
    public void onStart() {
        super.onStart();
        Events.register(this);
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

        dialog = new ProgressDialog(getContext());
        snack = Snackbar.make(null, null, Snackbar.LENGTH_INDEFINITE).setDuration(Snackbar.LENGTH_INDEFINITE);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMessage("Descargando...");

        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        Intent i = new Intent(getContext(),ApiService.class);
        getActivity().startService(i);

        CardList = (ListView) fragment.findViewById(R.id.CardList);

        adapter = new CardsCursorAdapter(getContext(), Card.class);
        CardList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Card card = (Card) parent.getItemAtPosition(position);

                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("card", card);
                startActivity(intent);
            }
        });

        CardList.setAdapter(adapter);

        getLoaderManager().initLoader(0, null, this);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.fragment_main_menu, menu);
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
        }else if(id == R.id.action_settings) {
            Intent vista = new Intent(getContext(), SettingsActivity.class);
            startActivity(vista);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("page", 1);
        editor.apply();
        DataManager.deleteCards(getContext());

        Intent i = new Intent(getContext(),ApiService.class);
        getActivity().startService(i);
    }

    @Events.Subscribe("start-downloading-data")
    void onStartDownloadData() {
        Log.d("XXXX", "onStartDownloadData");
        dialog.show();
    }

    @Events.Subscribe("finish-downloading-data")
    void onStopDownloadData() {
        Log.d("XXXX", "onStopDownloadData");
        dialog.dismiss();
    }

    @Events.Subscribe("progress-downloading-data")
    void onProgressDownloadData(int total, int actual) {
        Log.d("XXXX", "onProgressDownloadData");
        dialog.setMax(total);
        dialog.setProgress(actual);
        if(!dialog.isShowing()){
            snack.setText("Descargando "+actual+"/"+total);
                    if(!snack.isShown()) {
                        snack.show();
                    }
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return DataManager.getCursorLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }
}
