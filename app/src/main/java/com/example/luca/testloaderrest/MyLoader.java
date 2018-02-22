package com.example.luca.testloaderrest;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Luca on 13/02/2018.
 */

public class MyLoader extends AsyncTaskLoader<String> {
    private List<String> Utenti;
    private TextView displayTextView;
    private String saveTextView;

    public MyLoader(Context context) {
        super(context);
    }

    @Override
    public String loadInBackground() {
        RestClient.get("Users.json", null, new MainActivity.JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                if(statusCode== 200){
                    Log.i("statusC","status:");
                    Utenti = JsonParser.getAllUsers(response);
                    for(int i = 0; i<Utenti.size();i++){
                        displayTextView.setText(displayTextView.getText() + " " + Utenti.get(i) + " , ");

                    }
                    saveTextView = displayTextView.getText().toString();
                }
            }
            @Override
            public void onFailure(int statusCode, PreferenceActivity.Header[] headers, String responseBody, Throwable error){
                Log.i("restFB","Error");
            }
        });
        return saveTextView;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
