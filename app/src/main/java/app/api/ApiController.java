package app.api;

import java.io.IOException;

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

    private MagicTheGathering service;

    public ApiController() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MagicTheGathering.class);
    }

    public Response<Cards> GetCards(int page, int pageSize) throws IOException {
        Call<Cards> cards = service.getCards(page, pageSize);
        return cards.execute();
    }
}
