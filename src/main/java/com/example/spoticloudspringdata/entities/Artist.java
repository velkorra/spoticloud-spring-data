package com.example.spoticloudspringdata.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist extends BaseEntity{
    private String name;
    private String type;
    private String description;
    private String country;
    private int genreId;
    private Genre genre;
    private Set<ReleaseArtist> releaseArtists;

    public Artist(String name, String type, String description, String country, int genreId, Genre genre, Set<ReleaseArtist> releaseArtists) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.country = country;
        this.genreId = genreId;
        this.genre = genre;
        this.releaseArtists = releaseArtists;
    }

    protected Artist() {

    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @OneToMany(mappedBy = "artist")
    public Set<ReleaseArtist> getReleaseArtists() {
        return releaseArtists;
    }

    public void setReleaseArtists(Set<ReleaseArtist> releaseArtists) {
        this.releaseArtists = releaseArtists;
    }
}
