package com.infinitefarmer.volley;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by devamsrivastava on 27/06/16.
 */
public abstract class DataCallback {
    public void onError(String message, Integer... statuscode) {

    }

    public void onResponse(JSONArray response) {

    }

    public void onError(String message){}

    public void onResponse(JSONObject response) {

    }
}
