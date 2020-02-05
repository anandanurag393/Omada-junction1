package com.omada.junction;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;


public class BottomToolbarButton extends AppCompatImageView{

    int activeImage;
    int idleImage;
    int screenPointer;
    boolean state;

    public BottomToolbarButton(Context c, AttributeSet attrs){
        super(c, attrs);
        state = false;
    }

    public void setToolbarParams(int activeImage, int idleImage, int screenPointer){

        this.activeImage = activeImage;
        this.idleImage = idleImage;
        this.screenPointer = screenPointer;
        this.setImageResource(idleImage);
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

    public void carryOutAction(){
        //tell main activity to change fragment from here
        Context con = getContext();
        while(con instanceof ContextWrapper){
            if(con instanceof Junction){
                ((Junction)con).setActiveScreen(screenPointer);
            }
            con = ((ContextWrapper) con).getBaseContext();
        }
    }
}
