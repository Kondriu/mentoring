package com.mentoring.ui.google.pages.gmail.objects;

public class SearchResultsItemText {
    private String url;
    private String description;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SearchResultsItemText{" +
                "url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
