package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;

public class TopToolbarButton extends AppCompatButton implements View.OnClickListener {

    private boolean state; //true means selected

    public int DP_to_PX(int dp_value){
       return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp_value, getResources().getDisplayMetrics());
    }

    public TopToolbarButton(Context c, AttributeSet attrs, String text){
        super(c, attrs);
        state = false;
        setText(text);
        setTextColor(getResources().getColor(R.color.JunctionPurple));

        setPadding(0, 0, 0,0); //set padding here
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ((ViewGroup.MarginLayoutParams)params).setMargins(0, 0, 0, 0); //set margins here

        setLayoutParams(params);

    }

    @Override
    public void onClick(View v){
        if(!state){
            setBackground(getResources().getDrawable(R.drawable.active_button_purple));
            setTextColor(getResources().getColor(R.color.White));
        }
        else{
            setBackground(getResources().getDrawable(R.drawable.idle_button_white));
            setTextColor(getResources().getColor(R.color.JunctionLightGray));
        }
        state = !state;
    }
}
