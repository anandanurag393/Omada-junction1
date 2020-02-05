package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class CardScroller extends ScrollView {

    LinearLayout contentLayout;

    public CardScroller(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.card_scroller_layout, this, false);

    }

    public void addCard() {     //arguments here
        JunctionCard card = new JunctionCard(getContext(), null);
    }

}
