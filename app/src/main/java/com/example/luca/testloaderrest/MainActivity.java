package com.example.luca.testloaderrest;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{
    private List<String> Utenti;
    private TextView displayTextView;
    private LoaderManager mLoaderManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTextView = findViewById(R.id.mTextView);
        mLoaderManager = getLoaderManager();
        if(mLoaderManager.getLoader(1)!=null){
            mLoaderManager.initLoader(1,null,this);
        }
    }

    public void MyAsyncTask(View view) {
        mLoaderManager.initLoader(1,null,this);

    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new MyLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        displayTextView.setText(data);

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

    abstract static class JsonHttpResponseHandler extends RestClient.AsyncHttpResponseHandler {
        public abstract void onSuccess(int statusCode, PreferenceActivity.Header[] headers, JSONObject response);

        public abstract void onFailure(int statusCode, PreferenceActivity.Header[] headers, String responseBody, Throwable error);
    }
}
