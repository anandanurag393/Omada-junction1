package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

public class BottomToolbar extends LinearLayout {

    public BottomToolbar(Context c, AttributeSet attrs){
        super(c, attrs);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.bottom_toolbar_layout, this);

        Button explore_b = findViewById(R.id.explore_button);
        Button junct_b = findViewById(R.id.junction_button);
        Button more_b = findViewById(R.id.more_button);

    }

}
