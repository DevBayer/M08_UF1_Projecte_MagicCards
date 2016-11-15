package app.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import java.util.List;

import app.models.Card;
import app.providers.MagicTheGatheringContentProvider;
import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Bayer on 15/11/2016.
 */

public class DataManager {
    private static UriHelper URI_HELPER = UriHelper.with(MagicTheGatheringContentProvider.AUTHORITY);
    private static Uri CARD_URI = URI_HELPER.getUri(Card.class);

    public static void saveCards(List<Card> cards, Context context) {
        cupboard().withContext(context).put(CARD_URI, Card.class, cards);
    }

    public static void deleteCards(Context context) {
        cupboard().withContext(context).delete(CARD_URI, "_id > ?", "0");
    }

    public static CursorLoader getCursorLoader(Context context) {
        return new CursorLoader(context, CARD_URI, null, null, null, null);
    }
}