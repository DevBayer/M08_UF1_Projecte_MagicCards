package app.services;

import app.models.Cards;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 23878410v on 21/10/16.
 */

public interface MagicTheGathering {

    @GET("cards")
    Call<Cards> getCards(@Query("page") int page, @Query("pageSize") int pageSize);

}
