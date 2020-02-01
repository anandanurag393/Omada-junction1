package com.example.omada;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class MainActivity2 extends Activity {
    Button b[];
    ImageView im[];
    Drawable ic[],ii[];
    Boolean state[],state2[];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=new Button[5];
        im=new ImageView[3];
        ic=new Drawable[3];
        ii=new Drawable[3];
       for(int i=0;i<3;i++)
       {
           ic[i]=getResources().getDrawable(R.drawable.ic_launcher_background);
           ii[i]=getResources().getDrawable(R.drawable.ic_launcher_foreground);
       }

        state=new Boolean[5];
        state2=new Boolean[3];
        setContentView(R.layout.activity_main2);
        b[0]=findViewById(R.id.button1);
        b[1]=findViewById(R.id.button2);
        b[2]=findViewById(R.id.button3);
        b[3]=findViewById(R.id.button4);
        b[4]=findViewById(R.id.button5);
        im[0]=findViewById(R.id.search);
        im[1]=findViewById(R.id.feed);
        im[2]=findViewById(R.id.hamburgerButton);

       for(int i=0;i<5;i++)
           state[i]=false;
            state[0]=true;
       for(int i=0;i<3;i++)
           state2[i]=false;
       state2[1]=true;

       for(int i=0;i<3;i++)
           im[i].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   imageStateChanged(v);
               }
           });


       for(int i=0;i<5;i++)
           b[i].setOnClickListener( new Button.OnClickListener(){
               @Override
               public void onClick(View v) {
                   buttonChangeState(v);
               }
           });
        }

    private void imageStateChanged(View v) {
        for(int i=0;i<3;i++)
            state2[i]=false;
        int id=1;
        switch (v.getId()) {

            case R.id.search:
                id = 0;
                break;
            case R.id.feed:
                id = 1;
                break;
            case R.id.hamburgerButton:
                id = 2;
                break;
        }
       state2[id]=true;
        for(int i=0;i<3;i++)
        if(state2[i])
            im[i].setImageDrawable(ic[i]);
        else
            im[i].setImageDrawable(ii[i]);
    }

    private void buttonChangeState(View v) {
        for(int i=0;i<5;i++)
            state[i]=false;
        int id=0;
       switch (v.getId()) {
           case R.id.button1:
               id = 0;
               break;
           case R.id.button2:
               id = 1;
               break;
           case R.id.button3:
               id = 2;
               break;
           case R.id.button4:
               id = 3;
               break;
           case R.id.button5:
               id = 4;
               break;
       }
        state[id]=true;
        for(int i=0;i<5;i++)
            if(state[i])
                b[i].setBackground(getResources().getDrawable(R.drawable.button_rounded_2));
            else
                b[i].setBackground(getResources().getDrawable(R.drawable.roundedbutton));
    }


}

