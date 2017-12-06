package dev.meetup.mooresville.meetupmovies;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

class Movie {

    private String title;
    private Double voteAverage;
    private String overview;
    private Date releaseDate;

    @SerializedName("poster_path")
    private String posterURLString;

    Movie(String title,
            Double voteAverage,
            String overview,
            String posterURLString,
            Date releaseDate) {
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.posterURLString = posterURLString;
        this.releaseDate = releaseDate;
    }

    String getTitle() {
        return title;
    }

    Double getVoteAverage() {
        return voteAverage;
    }

    String getOverview() {
        return overview;
    }

    String getPosterURLString() {
        return posterURLString;
    }

    Date getReleaseDate() {
        return releaseDate;
    }
}
