package app;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import app.api.Card;

/**
 * Created by Lluís Bayer Soler on 14/10/16.
 */

public class InitialData {

    JSONObject json;
    private String jsonString = "";


    public InitialData(InputStreamReader file){
        try {
            BufferedReader r = new BufferedReader(file);
            String line;
            while ((line = r.readLine()) != null) {
                jsonString += line;
            }
            this.json = new JSONObject(jsonString);
        } catch(final Throwable tx) {
            Log.e("InitialData::loadFile()", tx.toString());
        }
    }


    public ArrayList<Card> getCards(){
        ArrayList<Card> test = new ArrayList<>();
        if(json != null) {
            try {
                JSONArray cards = json.getJSONArray("cards");
                for (int i = 0; i <  cards.length(); i++) {
                    test.add(new Card(cards.getJSONObject(i)));
                }

                Log.d("getCards() debugging", ""+test.size());
                return test;
            } catch (JSONException e) {
                Log.e("InitialData::getCards", e.toString());
            } catch (NoSuchFieldException e) {
                Log.e("InitialData::getCards", e.toString());
            } catch (IllegalAccessException e) {
                Log.e("InitialData::getCards", e.toString());
            }
        }
        return new ArrayList<>();
    }

}
