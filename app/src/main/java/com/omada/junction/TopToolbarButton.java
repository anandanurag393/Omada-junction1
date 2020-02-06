package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;

public class TopToolbarButton extends AppCompatButton {

    private boolean state; //true means selected

    public TopToolbarButton(Context c, AttributeSet attrs, String text){
        super(c, attrs);
        state = true;
        setText(text);
        setTextColor(getResources().getColor(R.color.JunctionPurple));

        setPadding(0, 0, 0,0); //set padding here
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0); //set margins here

        setLayoutParams(params);

        changeImage();

    }

    public void changeImage(){

        if(state) {
            setBackground(getResources().getDrawable(R.drawable.active_button_purple));
            setTextColor(getResources().getColor(R.color.White));
        }
        else{
            setBackground(getResources().getDrawable(R.drawable.idle_button_white));
            setTextColor(getResources().getColor(R.color.JunctionLightGray));
        }
        state = !state;
    }

    public void carryOutAction(){
        //TODO
        //change the layout in content_area
    }
}
