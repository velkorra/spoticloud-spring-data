package com.example.spoticloudspringdata.entities;

import com.example.spoticloudspringdata.entities.compositeId.UserReleaseId;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String email;
    private String password;
    private Timestamp dateRegistered;
    private Boolean isDeleted = Boolean.FALSE;
    private Set<UserPlaylist> userPlaylists;
    private Set<UserRelease> userReleases;
    private Set<UserPreferences> userPreferences;

    public User(String username, String email, String password, Timestamp dateRegistered, Set<UserPlaylist> userPlaylists, Set<UserRelease> userReleases, Set<UserPreferences> userPreferences) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateRegistered = dateRegistered;
        this.userPlaylists = userPlaylists;
        this.userReleases = userReleases;
        this.userPreferences = userPreferences;
        this.isDeleted = false;
    }

    protected User() {

    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "date_registered", insertable = false, updatable = false)
    public Timestamp getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserPlaylist> getUserPlaylists() {
        return userPlaylists;
    }

    public void setUserPlaylists(Set<UserPlaylist> userPlaylists) {
        this.userPlaylists = userPlaylists;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserRelease> getUserReleases() {
        return userReleases;
    }

    public void setUserReleases(Set<UserRelease> userReleases) {
        this.userReleases = userReleases;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserPreferences> getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(Set<UserPreferences> userPreferences) {
        this.userPreferences = userPreferences;
    }

    @Transient
    public Set<Release> getReleases() {
        return getUserReleases().stream().map(UserRelease::getRelease).collect(Collectors.toSet());
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "is_deleted", updatable = false, insertable = false)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return id == users.id && Objects.equals(username, users.username) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(dateRegistered, users.dateRegistered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, dateRegistered);
    }
}
