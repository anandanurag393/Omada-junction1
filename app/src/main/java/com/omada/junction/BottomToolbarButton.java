package com.omada.junction;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;


public class BottomToolbarButton extends AppCompatButton {

    int activeImage;
    int idleImage;
    int screenPointer;
    boolean state;

    public BottomToolbarButton(Context c, AttributeSet attrs){
        super(c, attrs);
        state = false;
    }

    @Override
    public void onAttachedToWindow(){
        super.onAttachedToWindow();

        this.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (((BottomToolbar) getParent()).changeScreen(getId())) {
                            carryOutAction();
                            changeImage();
                        }
                    }
                }
        );
    }

    public void setToolbarParams(int activeImage, int idleImage, int screenPointer){

        this.activeImage = activeImage;
        this.idleImage = idleImage;
        this.screenPointer = screenPointer;
        this.setBackgroundColor(getResources().getColor(R.color.JunctionLightGray));
    }

    public void changeImage(){
        state = !state;
        if(state){
            this.setBackgroundColor(getResources().getColor(R.color.JunctionPurple));
        }
        else{
            this.setBackgroundColor(getResources().getColor(R.color.JunctionLightGray));
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
