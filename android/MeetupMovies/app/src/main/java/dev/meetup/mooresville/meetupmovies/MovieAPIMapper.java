package dev.meetup.mooresville.meetupmovies;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieAPIMapper {

    public static ArrayList<Movie> retrieveMoviesFromResponse(String response) throws
            JSONException {
        if (null == response) {
            return new ArrayList<>();
        }
        JSONObject resultObject = new JSONObject(response);
        ArrayList<Movie> movies = new ArrayList<>();

        JSONArray jsonArray = resultObject.getJSONArray("results");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (null != jsonObject) {
                Movie movie = new Movie();
                if (jsonObject.has("title")) {
                    movie.setTitle(jsonObject.getString("title"));
                }
                if (jsonObject.has("vote_average")) {
                    movie.setVoteAverage(jsonObject.getDouble("vote_average"));
                }
                if (jsonObject.has("release_date")) {
                    movie.setReleaseDate(jsonObject.getString("release_date"));
                }
                if (jsonObject.has("overview")) {
                    movie.setOverview(jsonObject.getString("overview"));
                }
                if (jsonObject.has("poster_path")) {
                    movie.setPosterURLString(jsonObject.getString("poster_path"));
                }
                movies.add(movie);
            }
        }
        return movies;
    }
}
