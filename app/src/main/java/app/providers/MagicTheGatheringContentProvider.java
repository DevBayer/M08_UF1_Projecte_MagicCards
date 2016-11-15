package app.providers;

import app.models.Card;
import lluis.bayersoler.com.magiccards.BuildConfig;
import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by 23878410v on 15/11/16.
 */

public class MagicTheGatheringContentProvider extends CupboardContentProvider {


    public static final String AUTHORITY =BuildConfig.APPLICATION_ID + ".provider";

    static {
        cupboard().register(Card.class);
    }

    protected MagicTheGatheringContentProvider() {
        super(AUTHORITY, 1);
    }
}
