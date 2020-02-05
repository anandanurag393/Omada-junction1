package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class JunctionCard extends LinearLayout {

    public JunctionCard(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.card_layout, this, false);
    }
}
