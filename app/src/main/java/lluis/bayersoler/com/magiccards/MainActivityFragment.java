package lluis.bayersoler.com.magiccards;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import app.adapters.CardsCursorAdapter;
import app.adapters.DataManager;
import app.api.ApiController;
import app.models.Card;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private ListView CardList;
    private CardsCursorAdapter adapter;
    private int page;
    private int pageSize;
    private boolean sync_loadmore = false;
    private SharedPreferences preferences;
    private ProgressDialog dialog;

    public MainActivityFragment() {

    }


    @Override
    public void onStart() {
        super.onStart();
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
        dialog.setMessage("Actualizando...");

        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        this.page = preferences.getInt("page", 1);
        this.pageSize = preferences.getInt("pageSize", 100);

        //if(DataManager.getCountCards(getContext()) == 0){ // Evitem fer una consulta cada cop que es recrea la vista...
        if(preferences.getBoolean("firstTime", true)){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("firstTime", false);
            editor.apply();
            refresh();
        }

        CardList = (ListView) fragment.findViewById(R.id.CardList);

        CardList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if(firstVisibleItem+visibleItemCount == totalItemCount && totalItemCount!=0)
                {
                    if(sync_loadmore == false)
                    {
                        sync_loadmore = true;
                        loadNextPage();
                    }
                }

            }
        });

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
        LoadMoreTask task = new LoadMoreTask(1, preferences.getInt("pageSize", 100));
        task.execute();
    }

    private void loadNextPage() {
        page = page+1;
        LoadMoreTask task = new LoadMoreTask(page, pageSize);
        task.execute();
    }

    private class LoadMoreTask extends AsyncTask<Void, Void, Void> {
        private int page;
        private int pageSize;

        public LoadMoreTask(int page, int pageSize) {
            this.page = page;
            this.pageSize = pageSize;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ApiController api = new ApiController();
            try {
                if(api.totalcount == 0 || api.totalcount > page) {
                    ArrayList<Card> response = api.GetCards(page, pageSize);
                    if (response != null) {
                        DataManager.saveCards(response, getContext());
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("page", page);
                        editor.apply();
                    }
                }
            } catch (IOException e ){
                // handle error
                Log.e("LoadMoreTask::bg", e.getMessage());
            }
            sync_loadmore = false;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return DataManager.getCursorLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if(data.getCount() == 0){
            loadNextPage();
        }
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }
}
