package com.omada.junction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

//TODO
//set screenpointer, active and idle images for buttons

public class BottomToolbar extends FrameLayout{

    int pressedButtonId;
    BottomToolbarButton exploreButton, junctionButton, moreButton;

    public BottomToolbar(Context c, AttributeSet attrs){
        super(c, attrs);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.bottom_toolbar_layout, this);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onAttachedToWindow(){

        super.onAttachedToWindow();

        exploreButton = findViewById(R.id.explore_button);
        exploreButton.setToolbarParams(0, 0, 0);

        junctionButton = findViewById(R.id.junction_button);
        junctionButton.setToolbarParams(0, 0, 1);

        moreButton = findViewById(R.id.more_button);
        moreButton.setToolbarParams(0, 0, 2);

        moreButton.carryOutAction();
        moreButton.changeImage();
        pressedButtonId = moreButton.getId();

    }

    /*
    @Override
    public boolean onInterceptTouchEvent(MotionEvent e){

        if(e.getAction() != MotionEvent.ACTION_UP || e.getAction() != MotionEvent.ACTION_CANCEL){
            return false;
        }

        //TODO
        //use event attributes to check which button is clicked

        //TODO
        //carry out action on that button

        return false;
    }
    */

    public boolean changeScreen(int id){

        if(id == pressedButtonId){
            return false;
        }

        ((BottomToolbarButton)findViewById(pressedButtonId)).changeImage();
        pressedButtonId = id;
        return true;
    }
}
