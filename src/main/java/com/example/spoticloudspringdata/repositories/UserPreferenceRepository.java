package com.example.spoticloudspringdata.repositories;

import com.example.spoticloudspringdata.entities.UserPreferences;
import com.example.spoticloudspringdata.entities.compositeId.UserPreferencesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreferences, UserPreferencesId> {
}
