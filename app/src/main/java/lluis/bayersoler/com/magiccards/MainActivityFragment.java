package lluis.bayersoler.com.magiccards;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStreamReader;

import app.adapters.CardsAdapter;
import app.api.ApiController;
import app.models.Cards;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ListView CardList;
    private CardsAdapter adapter;
    private int page;
    private int pageSize;
    private boolean sync_loadmore = false;

    public MainActivityFragment() {
        this.page = 1;
        this.pageSize = 10;
    }


    @Override
    public void onStart() {
        super.onStart();
        refresh();
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

        adapter = new CardsAdapter(getContext(), 0);
        CardList.setAdapter(adapter);
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
        page = 1;
        LoadMoreTask task = new LoadMoreTask(page, 100);
        task.execute();
    }

    private void loadNextPage() {
        page = page+1;
        LoadMoreTask task = new LoadMoreTask(page, pageSize);
        task.execute();
    }

    private class LoadMoreTask extends AsyncTask<Void, Void, Response<Cards>> {
        private int page;
        private int pageSize;

        public LoadMoreTask(int page, int pageSize) {
            this.page = page;
            this.pageSize = pageSize;
        }

        @Override
        protected Response<Cards> doInBackground(Void... voids) {
            ApiController api = new ApiController();
            try {
                Response<Cards> response = api.GetCards(page, pageSize);
                return response;
            } catch (IOException e ){
                // handle error
                Log.e("LoadMoreTask::bg", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Response<Cards> cards) {
            if(cards.isSuccessful()){
                adapter.addAll(cards.body().getCards());
                sync_loadmore = false;
            }else{
                try {
                    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(getActivity());
                    dialogo1.setTitle("Error con la petición");
                    dialogo1.setMessage(cards.errorBody().string());
                    dialogo1.show();
                }catch(IOException e){
                    Log.e("LoadMoreTask::Pe", e.getMessage());
                }
            }
        }
    }

}
