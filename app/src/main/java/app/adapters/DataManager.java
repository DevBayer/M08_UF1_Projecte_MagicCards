package app.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.content.CursorLoader;
import android.text.TextUtils;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.models.Card;
import app.providers.MagicTheGatheringContentProvider;
import lluis.bayersoler.com.magiccards.R;
import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Bayer on 15/11/2016.
 */

public class DataManager {
    private static UriHelper URI_HELPER = UriHelper.with(MagicTheGatheringContentProvider.AUTHORITY);
    private static Uri CARD_URI = URI_HELPER.getUri(Card.class);

    public static int getCountCards(Context context){
        Cursor cards = cupboard().withContext(context).query(CARD_URI, Card.class).getCursor();
        return cards.getCount();
    }

    public static void saveCards(List<Card> cards, Context context) {
        cupboard().withContext(context).put(CARD_URI, Card.class, cards);
    }

    public static void deleteCards(Context context) {
        cupboard().withContext(context).delete(CARD_URI, "_id > ?", "0");
    }

    public static CursorLoader getCursorLoader(Context context) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        Set<String> _defaultrarities = new HashSet<String>();
        _defaultrarities.addAll(Arrays.asList(context.getResources().getStringArray(R.array.app_preference_rarity_list_values)));
        Set<String> rarities = preferences.getStringSet("rarity", _defaultrarities);

        Set<String> _defaultcolors = new HashSet<String>();
        _defaultcolors.addAll(Arrays.asList(context.getResources().getStringArray(R.array.app_preference_colors_list_values)));
        Set<String> colors = preferences.getStringSet("colors", _defaultcolors);

        String selection = "";
        String[] selectionArgs = new String[rarities.size() + colors.size()];

        selection += "(";
        int i = 0;
        for (String rarity: rarities) {
            selection += " rarity=? OR";
            selectionArgs[i] = rarity;
            i++;
        }
        selection = selection.substring(0, selection.length()-2);
        selection += ") AND (";
        for (String color: colors) {
            selection += " colorIdentity LIKE ? OR";
            selectionArgs[i] = "%"+color+"%";
            i++;
        }
        selection = selection.substring(0, selection.length()-2);
        selection += ")";
        System.out.println(selection);

        return new CursorLoader(context, CARD_URI, null, selection, selectionArgs, null);
    }
}