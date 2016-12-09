package app.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import app.models.*;
import app.services.MagicTheGathering;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 23878410v on 17/10/16.
 */

public class ApiController {
    private static final String BASE_URL = "https://api.magicthegathering.io/v1/";
    public int totalcount = 0;

    private MagicTheGathering service;

    public ApiController() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MagicTheGathering.class);
        totalcount = 32048;
    }

    public ArrayList<Card> GetCards(int page, int pageSize) throws IOException {
        Call<Map<String, ArrayList<Card>>> cardsCall = service.getCards(page, pageSize);

        Response<Map<String, ArrayList<Card>>> response = cardsCall.execute();

        if(!response.isSuccessful()) return null;

        totalcount = Integer.parseInt(response.headers().get("Total-count"));

        Map<String, ArrayList<Card>> cards = response.body();

        return cards.get("cards");
    }
}
