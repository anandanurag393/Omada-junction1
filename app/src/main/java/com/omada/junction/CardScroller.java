package com.omada.junction;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class CardScroller extends ScrollView {

    LinearLayout contentLayout;

    private static final int SWIPE_MIN_DISTANCE = 5;
    private static final int SWIPE_THRESHOLD_VELOCITY = 300;
    private GestureDetector gestureDetector;

    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;

    private int activeCard = 0;
    private int cardsList = 6;  //number of cards

    private int featureHeight;

    public CardScroller(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.card_scroller_layout, this, true);

        featureHeight = (int)getResources().getDimension(R.dimen.card_height) + 2*(int)getResources().getDimension(R.dimen.card_top_margin); //TODO adjust for margins and padding

        contentLayout = findViewById(R.id.card_scroller_linearlayout);
        //change properties of content layout here

        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();


        contentLayout.addView(new JunctionCard(getContext(), null));
        contentLayout.addView(new JunctionCard(getContext(), null));
        contentLayout.addView(new JunctionCard(getContext(), null));
        contentLayout.addView(new JunctionCard(getContext(), null));
        contentLayout.addView(new JunctionCard(getContext(), null));

    }

    @Override
    public void onAttachedToWindow(){

        super.onAttachedToWindow();

        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //If the user swipes
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                }
                if(event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL ){
                    int scrollY = getScrollY();
                    activeCard = ((scrollY + (featureHeight/2))/featureHeight);
                    int scrollTo = activeCard * featureHeight;
                    smoothScrollTo(0, scrollTo);
                    return true;
                }
                else{
                    return false;
                }
            }
        });
        gestureDetector = new GestureDetector(getContext(), new MyGestureDetector());

        addCards();
    }

    public void addCards(){

        //TODO
        //load cards and set cardsList here
    }

    public void changeContents(int contentIdentifier){
        //TODO
        //change cards based on input from top toolbar button sent via contentId
    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            try {
                //down to up
                if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    activeCard = (activeCard < (cardsList - 1))? activeCard + 1 : cardsList -1;
                    smoothScrollTo(0, activeCard * featureHeight);
                    return true;
                }
                //up to down
                else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    activeCard = (activeCard > 0) ? activeCard - 1 : 0;
                    smoothScrollTo(0, activeCard * featureHeight);
                    return true;
                }

            } catch (Exception e) {
                Log.e("Fling", "There was an error processing the Fling event:" + e.getMessage());
            }
            return false;
        }
    }


}

