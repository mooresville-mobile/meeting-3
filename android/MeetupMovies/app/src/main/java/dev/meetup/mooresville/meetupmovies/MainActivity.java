package dev.meetup.mooresville.meetupmovies;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DownloadCompleteListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.movieRecyclerView);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MovieAdapter(new ArrayList<Movie>());
        mRecyclerView.setAdapter(mAdapter);

        if (isNetworkConnected()) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();

            startDownload();
        } else {
            showNetworkConnectionError();
        }
    }

    private void startDownload() {
        Uri uri = new Uri.Builder()
                .scheme("https")
                .path("api.themoviedb.org")
                .appendPath("3")
                .appendPath("search")
                .appendPath("movie")
                .appendQueryParameter("api_key", "99651ffbdb70f6a2d891f47ea9928677")
                .appendQueryParameter("language", "en-US")
                .appendQueryParameter("query", "frozen")
                .appendQueryParameter("page", "1")
                .appendQueryParameter("include_adult", "false")
                .build();
        new DownloadMovieTask(this).execute(uri.toString());
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();
    }

    private void showNetworkConnectionError() {
        new AlertDialog.Builder(this)
                .setTitle("No Internet Connection")
                .setMessage("It looks like your internet connection is off. Please turn it " +
                        "on and try again")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void downloadComplete(ArrayList<Movie> movies) {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mAdapter.updateMovies(movies);
    }
}
