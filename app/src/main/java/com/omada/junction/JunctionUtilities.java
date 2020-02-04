package com.omada.junction;

import android.content.Context;
import android.util.TypedValue;

public class JunctionUtilities {

    //static utility functions like number converters, etc go here

    public static int DP_to_PX(Context context, int dp_value){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp_value, context.getResources().getDisplayMetrics());
    }

}
