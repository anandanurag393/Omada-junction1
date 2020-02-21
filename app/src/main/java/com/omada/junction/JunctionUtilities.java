package com.omada.junction;

import android.content.Context;
import android.util.TypedValue;

public class JunctionUtilities {

    //static utility functions like number converters, etc go here

    public static float DP_to_PX(Context context, float dp_value){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp_value, context.getResources().getDisplayMetrics());
    }

}
