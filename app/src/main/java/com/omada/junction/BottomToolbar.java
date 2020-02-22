package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

//TODO
//set screenpointer, active and idle images for buttons

public class BottomToolbar extends FrameLayout{

    int pressedButtonId;

    public BottomToolbar(Context c, AttributeSet attrs){
        super(c, attrs);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.bottom_toolbar_layout, this);

        BottomToolbarButton exploreButton = findViewById(R.id.explore_button);
        exploreButton.setToolbarParams(0, 0, 0);

        BottomToolbarButton junctionButton = findViewById(R.id.junction_button);
        junctionButton.setToolbarParams(0, 0, 0);

        BottomToolbarButton moreButton = findViewById(R.id.more_button);
        moreButton.setToolbarParams(0, 0, 0);

        junctionButton.carryOutAction();
        junctionButton.changeImage();
        pressedButtonId = junctionButton.getId();

        this.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(v.getId() == pressedButtonId){
                    return;
                }

                boolean valid = true;
                switch(v.getId()){
                    case R.id.explore_button:
                        pressedButtonId = R.id.explore_button;
                        break;
                    case R.id.junction_button:
                        pressedButtonId = R.id.junction_button;
                        break;
                    case R.id.more_button:
                        pressedButtonId = R.id.more_button;
                        break;
                    default:
                        valid = false;
                        break;
                }

                if(valid){
                    ((BottomToolbarButton)v).carryOutAction(); //tells button to tell activity to change fragment
                    ((BottomToolbarButton)v).changeImage(); //changes button to active
                }
            }
        });

    }
}
