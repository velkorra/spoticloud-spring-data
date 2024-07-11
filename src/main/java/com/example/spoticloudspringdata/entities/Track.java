package com.example.spoticloudspringdata.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "track")
public class Track {

    private int id;
    private String name;
    private String language;
    private String type;
    private int artistId;
    private int genreId;
    private Integer releaseId;
    private int duration;
    private Boolean explicit;
    private Genre genre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "artist_id")
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "release_id")
    public Integer getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Integer releaseId) {
        this.releaseId = releaseId;
    }

    @Basic
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "explicit")
    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return id == track.id && artistId == track.artistId && genreId == track.genreId && duration == track.duration && Objects.equals(name, track.name) && Objects.equals(language, track.language) && Objects.equals(type, track.type) && Objects.equals(releaseId, track.releaseId) && Objects.equals(explicit, track.explicit) && Objects.equals(genre, track.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, language, type, artistId, genreId, releaseId, duration, explicit, genre);
    }

    @Override
    public String toString() {
        return STR."Track{id=\{id}, name='\{name}\{'\''}, language='\{language}\{'\''}, type='\{type}\{'\''}, artistId=\{artistId}, genreId=\{genreId}, releaseId=\{releaseId}, duration=\{duration}, explicit=\{explicit}, genre=\{genre}\{'}'}";
    }
}