package com.example.spoticloudspringdata.repositories;

import com.example.spoticloudspringdata.entities.UserPlaylist;
import com.example.spoticloudspringdata.entities.compositeId.UserPlaylistId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlaylistRepository extends JpaRepository<UserPlaylist, UserPlaylistId> {
}
