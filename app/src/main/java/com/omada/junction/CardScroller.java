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

        contentLayout = findViewById(R.id.card_scroller_linearlayout);
        //change properties of content layout here
    }

    public void addCard() {     //arguments here
        JunctionCard card = new JunctionCard(getContext(), null);
    }

}
