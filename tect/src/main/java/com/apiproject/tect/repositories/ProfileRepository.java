package com.apiproject.tect.repositories;

import com.apiproject.tect.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("profileRepository")
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}