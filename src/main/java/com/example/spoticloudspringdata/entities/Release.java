package com.example.spoticloudspringdata.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Release extends BaseEntity {
    private String name;
    private Date dateReleased;
    private String language;
    private String type;
    private int genreId;
    private String description;
    private Genre genre;
    private Set<ReleaseArtist> releaseArtists;
    private Set<Track> tracks;

    public Release(String name, Date dateReleased, String language, String type, int genreId, String description, Genre genre) {
        this.name = name;
        this.dateReleased = dateReleased;
        this.language = language;
        this.type = type;
        this.genreId = genreId;
        this.description = description;
        this.genre = genre;
    }

    protected Release() {

    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "date_released")
    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @OneToMany(mappedBy = "release")
    public Set<ReleaseArtist> getReleaseArtists() {
        return releaseArtists;
    }

    @OneToMany(mappedBy = "release")
    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public void setReleaseArtists(Set<ReleaseArtist> releaseArtists) {
        this.releaseArtists = releaseArtists;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        return id == release.id && genreId == release.genreId && Objects.equals(name, release.name) && Objects.equals(dateReleased, release.dateReleased) && Objects.equals(language, release.language) && Objects.equals(type, release.type) && Objects.equals(description, release.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateReleased, language, type, genreId, description);
    }
}
