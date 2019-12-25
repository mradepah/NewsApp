package com.example.newsapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    public static final int NEWS_LOADER_ID = 1;
    public static final String GUARDIAN_REQUEST_URL =
            "http://content.guardianapis.com/search?q=debates&api-key=test";

    // Initialise views and adapters
    ListView ListView;
    TextView TextView;
    NewsAdapter Adapter;
    ProgressBar ProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Get connection information
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        assert manager != null;
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        ListView = findViewById(R.id.newslist);
        ProgressBar = findViewById(R.id.progressBar);
        TextView = findViewById(R.id.title_text_view);

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            ProgressBar.setVisibility(View.GONE);
            TextView.setVisibility(View.VISIBLE);
            TextView.setText(R.string.no_internet_text);
        }
    }

//    Override Loader Method to be used

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(this, GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
        Adapter = new NewsAdapter(this, (ArrayList<News>) data);
        ProgressBar.setVisibility(View.GONE);
        ListView.setAdapter(Adapter);
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }
}
