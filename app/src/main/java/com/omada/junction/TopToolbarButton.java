package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;

public class TopToolbarButton extends AppCompatButton implements View.OnClickListener {

    private boolean state; //true means selected

    public TopToolbarButton(Context c, AttributeSet attrs, String text){
        super(c, attrs);
        state = false;
        setText(text);
        setTextColor(getResources().getColor(R.color.JunctionPurple));

        setPadding(0, 0, 0,0); //set padding here
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0); //set margins here

        setLayoutParams(params);

    }

    @Override
    public void onClick(View v){

        if(state)
            return;
        setBackground(getResources().getDrawable(R.drawable.active_button_purple));
        setTextColor(getResources().getColor(R.color.White));
        state = !state;
    }
}
