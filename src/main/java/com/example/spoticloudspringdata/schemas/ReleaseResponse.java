package com.example.spoticloudspringdata.schemas;

import com.example.spoticloudspringdata.entities.Release;
import com.example.spoticloudspringdata.entities.Track;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public class ReleaseResponse {
    private String name;
    private Date dateReleased;
    private String language;
    private String type;
    private String description;
    private String genre;
    private String totalDuration;
    private int totalTracks;

    public ReleaseResponse(Release release) {
        this.name = release.getName();
        this.dateReleased = release.getDateReleased();
        this.language = release.getLanguage();
        this.type = release.getType();
        this.description = release.getDescription();
        this.genre = release.getGenre().getName();
        Set<Track> tracks = release.getTracks();
        int duration = tracks.stream().map(Track::getDuration).reduce(0, Integer::sum);
        int minutes = duration / 60;
        int seconds = duration % 60;
        this.totalDuration = String.format("%d:%02d", minutes, seconds);
        this.totalTracks = tracks.size();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(int totalTracks) {
        this.totalTracks = totalTracks;
    }
}
