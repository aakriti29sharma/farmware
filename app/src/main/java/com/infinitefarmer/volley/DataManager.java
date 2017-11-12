package com.infinitefarmer.volley;

import android.content.Context;

import com.infinitefarmer.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by guptaanirudh100 on 7/30/2017.
 */

public class DataManager {
    private final Context context;
    String url="";
    private String DataRequest = "http://16432e70.ngrok.io/agri";

    public DataManager(Context context){
        this.context=context;
    }

    public void getResults(DataCallback callback) {
        url = DataRequest + "/readusertype";
        DataRequest dataRequest = new DataRequest(context);
        JSONObject data = new JSONObject();
        JSONArray searchdata = new JSONArray();
        try {
            data.put("", "");
            searchdata.put(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dataRequest.getjsonOjectpost(url, searchdata, callback);

    }
    public void sendToken(String token, DataCallback callback) {
        url = DataRequest + "/addfcm";
        DataRequest dataRequest = new DataRequest(context);
        JSONObject data = new JSONObject();

        try {
            data.put("fcm_token", token);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        dataRequest.getjsonOjectpost(url, data, callback);

    }

    public void registerUser(User user, DataCallback callback){
        url = DataRequest + "/reg.php";
        DataRequest dataRequest = new DataRequest(context);
        JSONObject data = new JSONObject();

        try {
            data.put("type", "farmer");
            data.put("name","ihdi");
            data.put("phone", user.getPhone());
            data.put("age", user.getAge());
            data.put("aadhar", user.getAadhar());

        } catch (JSONException e) {
            e.printStackTrace();
        }
        dataRequest.getjsonOjectpost(url, data, callback);
    }

}
