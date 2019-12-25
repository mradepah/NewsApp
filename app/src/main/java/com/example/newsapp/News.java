package com.example.newsapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class News {

    //    Set Member Variables
    private String mNewsTitle;
    private long mNewsDate;
    private String mNewsUrl;
    private String mNewsAuthor;
    private String mNewsSection;

    //    Initialise the news constructor
    public News(String NewsTitle, long NewsDate, String NewsUrl, String NewsAuthor, String NewsSection) {
        mNewsTitle = NewsTitle;
        mNewsDate = NewsDate;
        mNewsUrl = NewsUrl;
        mNewsAuthor = NewsAuthor;
        mNewsSection = NewsSection;
    }

    //    Define  getters and setters
    public String getNewsTitle() {
        return mNewsTitle;
    }

    public void setTitle(String NewsTitle) {
        mNewsTitle = NewsTitle;
    }

    public long getNewsDate() {
        return mNewsDate;
    }

    public void setNewsDate(long newsDateInMilliseconds) {
        mNewsDate = newsDateInMilliseconds;
    }

    public String getNewsUrl() {
        return mNewsUrl;
    }

    public void setNewsUrl(String Newsurl) {
        mNewsUrl = Newsurl;
    }

    public String getNewsAuthor() {
        return mNewsAuthor;
    }

    public void setNewsAuthor(String NewsAuthor) {
        mNewsAuthor = NewsAuthor;
    }

    public String getNewsSection() {
        return mNewsSection;
    }

    public void setNewsSection(String NewsSection) {
        mNewsSection = NewsSection;
    }

    @Override
    public String toString() {
        return " title " + getNewsTitle();

    }

    public long getTimeInMilliseconds() {
        return mNewsDate;
    }

    //    define the formatting method
    private String formattedDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

}

