package app;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import app.models.Card;
import app.models.Cards;

/**
 * Created by Lluís Bayer Soler on 14/10/16.
 */

public class InitialData {
    private String jsonString = "";


    public InitialData(InputStreamReader file){
        try {
            BufferedReader r = new BufferedReader(file);
            String line;
            while ((line = r.readLine()) != null) {
                jsonString += line;
            }
        } catch(final Throwable tx) {
            Log.e("InitialData::loadFile()", tx.toString());
        }
    }


    public List<Card> getCards(){
        Gson gson = new Gson();
        Cards response = gson.fromJson(jsonString, Cards.class);
        return response.getCards();
    }

}
