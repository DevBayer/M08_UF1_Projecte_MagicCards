package app;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import app.api.Card;

/**
 * Created by Lluís Bayer Soler on 14/10/16.
 */

public class InitialData {

    Context app;
    JSONObject json;
    private String jsonString;


    public InitialData(InputStreamReader file){
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(app.getAssets().open( "initial_data.json" )));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            this.jsonString = line;
            this.json = new JSONObject(jsonString);
        } catch(final Throwable tx) {
            Log.e("InitialData::loadFile()", tx.toString());
        }
    }


    public ArrayList<String> getCards(){
        ArrayList<String> test = new ArrayList<>();
        if(json != null) {
            try {
                Iterator<?> keys = json.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    if (json.get(key) instanceof JSONObject) {
                        JSONObject xx = new JSONObject(json.get(key).toString());
                        Log.d("res1", xx.getString("something"));
                        Log.d("res2", xx.getString("something2"));
                        test.add( xx.getString("name") );
                    }
                }
                return test;
            } catch (JSONException e) {
                Log.e("InitialData::getCards()", e.getMessage());
            }
        }
        return new ArrayList<>();
    }

}
