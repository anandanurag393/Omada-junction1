package com.omada.junction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;


public class BottomToolbarButton extends AppCompatImageView{

    int activeImage;
    int idleImage;
    boolean state;

    public BottomToolbarButton(Context c, AttributeSet attrs, int activeImage, int idleImage){
        super(c, attrs);

        state = false;

    }

    public void changeImage(){
        state = !state;
        if(state){
            this.setImageResource(activeImage);
        }
        else{
            this.setImageResource(idleImage);
        }
    }
}
