package com.sluiters.second.video.suilerSecondVideo.models;

public class SearchModel {

    //This model is necessary for the search service

    private String searchTerm;


    public SearchModel() {
    }

    public SearchModel(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public String toString() {
        return "SearchModel{" +
                "searchTerm='" + searchTerm + '\'' +
                '}';
    }

}
