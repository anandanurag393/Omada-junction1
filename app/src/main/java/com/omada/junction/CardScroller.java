package com.omada.junction;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ScrollView;

public class CardScroller extends ScrollView {

    public CardScroller(Context context){
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.card_scroller_layout, this, false);
    }

}
