package app.providers;

import com.google.gson.Gson;

import app.models.Card;
import app.models.Legality;
import app.models.Ruling;
import lluis.bayersoler.com.magiccards.BuildConfig;
import nl.littlerobots.cupboard.tools.convert.ListFieldConverterFactory;
import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;
import nl.qbusict.cupboard.CupboardBuilder;
import nl.qbusict.cupboard.CupboardFactory;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by 23878410v on 15/11/16.
 */

public class MagicTheGatheringContentProvider extends CupboardContentProvider {


    public static final String AUTHORITY =BuildConfig.APPLICATION_ID + ".provider";



    static {
        CupboardFactory.setCupboard(new CupboardBuilder().
                registerFieldConverterFactory(new ListFieldConverterFactory(new Gson())).useAnnotations().build());
        cupboard().register(Legality.class);
        cupboard().register(Ruling.class);
        cupboard().register(Card.class);
    }

    protected MagicTheGatheringContentProvider() {
        super(AUTHORITY, 1);
    }



}
