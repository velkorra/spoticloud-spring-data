package com.example.spoticloudspringdata.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    private int id;
    private String name;
    private Integer parentGenreId;
    private Set<Track> tracks;


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
    @Column(name = "parent_genre_id")
    public Integer getParentGenreId() {
        return parentGenreId;
    }

    public void setParentGenreId(Integer parentGenreId) {
        this.parentGenreId = parentGenreId;
    }

    @OneToMany(mappedBy = "genre")
    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id && Objects.equals(name, genre.name) && Objects.equals(parentGenreId, genre.parentGenreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parentGenreId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Genre ").append(id).append(" \"").append(name).append("\"");
        if (parentGenreId != null) {
            sb.append(", its parent genre is ").append("\"Genre ").append(parentGenreId).append("\"");
        }
        return sb.toString();
    }
}