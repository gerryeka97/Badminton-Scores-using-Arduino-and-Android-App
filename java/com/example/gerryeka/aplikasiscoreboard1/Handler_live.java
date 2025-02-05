package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.logging.Handler;

/**
 * Created by gerry eka on 10/10/2019.
 */

public class Handler_live {

    public static Handler_live mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private Handler_live(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();

    }


    public RequestQueue getRequestQueue() {

        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }

        return requestQueue;
    }
    public static synchronized Handler_live getmInstance(Context context){

        if (mInstance == null){
            mInstance = new Handler_live(context);
        }
        return mInstance;
    }
    public <T>void addtoRequestQue(Request<T> request){
        requestQueue.add(request);
    }

}
