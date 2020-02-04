package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class BottomToolbar extends LinearLayout implements View.OnClickListener{

    int pressedButtonId;

    public BottomToolbar(Context c, AttributeSet attrs){
        super(c, attrs);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.bottom_toolbar_layout, this);

        BottomToolbarButton exploreButton = findViewById(R.id.explore_button);
        BottomToolbarButton junctionButton = findViewById(R.id.junction_button);
        BottomToolbarButton moreButton = findViewById(R.id.more_button);

        junctionButton.changeImage();

        pressedButtonId = junctionButton.getId();

    }

    public void onClick(View v){
        if(v.getId()==pressedButtonId){
            return;
        }
        else{
            ((BottomToolbarButton)findViewById(pressedButtonId)).changeImage();
            pressedButtonId = v.getId();

        }
    }

}
