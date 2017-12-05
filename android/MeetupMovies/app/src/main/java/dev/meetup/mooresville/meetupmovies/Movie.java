package dev.meetup.mooresville.meetupmovies;


import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String mTitle;
    private Double mVoteAverage;
    private String mOverview;
    private String mPosterURLString;
    private String mReleaseDate;

    public Movie() {
    }

    public Movie(String title,
            Double voteAverage,
            String overview,
            String posterURLString,
            String releaseDate) {
        mTitle = title;
        mVoteAverage = voteAverage;
        mOverview = overview;
        mPosterURLString = posterURLString;
        mReleaseDate = releaseDate;
    }

    protected Movie(Parcel in) {
        mTitle = in.readString();
        mOverview = in.readString();
        mPosterURLString = in.readString();
        mReleaseDate = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getPosterURLString() {
        return mPosterURLString;
    }

    public void setPosterURLString(String posterURLString) {
        mPosterURLString = posterURLString;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mOverview);
        parcel.writeString(mPosterURLString);
        parcel.writeString(mReleaseDate);
    }
}
