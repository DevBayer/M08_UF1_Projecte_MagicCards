package app.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.alexvasilkov.events.Events;

import java.io.IOException;
import java.util.ArrayList;

import app.adapters.DataManager;
import app.api.ApiController;
import app.models.Card;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class ApiService extends IntentService {
    public ApiService() {
        super("ApiService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            int page, totalItems;
            page = preferences.getInt("page", 1);
            ApiController api = new ApiController();
            try {
                api.getTotalCount();
            }catch(IOException e){

            }
            if(preferences.getBoolean("firstTime", true)){
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("firstTime", false);
                editor.apply();
                totalItems = 0;
            }else{
                totalItems = DataManager.getCountCards(this);
            }
            if(api.totalcount != 0 && totalItems >= api.totalcount) {
                return;
            }
            Events.post("start-downloading-data");
            try {
                if(api.totalcount >= totalItems) {
                    do {
                        totalItems += doRequest(api, page, 100);
                        Events.create("progress-downloading-data").param(api.totalcount / 100, page).post();
                        page++;
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("page", page);
                        editor.apply();
                    } while (api.totalcount > totalItems);
                }
            } catch (IOException e ){
                Log.e("LoadMoreTask::bg", e.getMessage());
            }
            Events.post("stop-downloading-data");
        }
    }

    private int doRequest(ApiController api, int page, int pageSize) throws IOException{
        ArrayList<Card> response = api.GetCards(page, pageSize);
        if (response != null) {
            DataManager.saveCards(response, this);
            return response.size();
        }
        return 0;
    }

}
