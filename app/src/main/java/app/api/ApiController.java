package app.api;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import app.HttpUtils;
import app.exceptions.ApiControllerException;

/**
 * Created by 23878410v on 17/10/16.
 */

public class ApiController {

    private static final String BASE_URL = "https://api.magicthegathering.io/v1";

    @Nullable
    public static ArrayList<Card> GetAllCards(int page, int pageSize) throws ApiControllerException {
        Uri builturi = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("cards")
                .appendQueryParameter("page", ""+page)
                .appendQueryParameter("pageSize", ""+pageSize)
                .build();

        JSONObject json = doCall(builturi.toString());
        if(json != null){
            return parseCards(json);
        }

        return null;
    }

    @Nullable
    private static JSONObject doCall(String url) throws ApiControllerException {
        try {
            String JsonResponse = HttpUtils.get(url);
            JSONObject json = new JSONObject(JsonResponse);
            if(json.has("status")){
                throw new ApiControllerException(json.getString("status"),json.getString("message"));
            }
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static ArrayList<Card> parseCards(JSONObject json){
        ArrayList<Card> test = new ArrayList<>();
            try {
                JSONArray cards = json.getJSONArray("cards");
                for (int i = 0; i <  cards.length(); i++) {
                    test.add(new Card(cards.getJSONObject(i)));
                }
                return test;
            } catch (JSONException e) {
                Log.e("InitialData::getCards", e.toString());
            } catch (NoSuchFieldException e) {
                Log.e("InitialData::getCards", e.toString());
            } catch (IllegalAccessException e) {
                Log.e("InitialData::getCards", e.toString());
            }
        return null;
    }

}
