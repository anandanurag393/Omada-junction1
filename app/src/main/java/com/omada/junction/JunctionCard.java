package com.omada.junction;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class JunctionCard extends LinearLayout {

    public JunctionCard(Context context){
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.card_layout, this, false);
    }
}
