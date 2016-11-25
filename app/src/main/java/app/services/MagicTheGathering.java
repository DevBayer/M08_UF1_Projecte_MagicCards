package app.services;

import java.util.ArrayList;
import java.util.Map;

import app.models.Card;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 23878410v on 21/10/16.
 */

public interface MagicTheGathering {

    @GET("cards")
    Call<Map<String, ArrayList<Card>>> getCards(@Query("page") int page, @Query("pageSize") int pageSize);

}
