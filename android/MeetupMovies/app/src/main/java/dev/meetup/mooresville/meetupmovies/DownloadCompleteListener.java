package dev.meetup.mooresville.meetupmovies;


import java.util.ArrayList;

public interface DownloadCompleteListener {
    void downloadComplete(ArrayList<Movie> movies);
}
