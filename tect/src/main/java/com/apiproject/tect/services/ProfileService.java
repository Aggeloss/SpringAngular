package com.apiproject.tect.services;

import com.apiproject.tect.entities.Profile;

import java.util.List;

public interface ProfileService {

    public Iterable<Profile> findAll();

    public Profile find(int id);

    public Profile save(Profile product);

    public Profile update(Profile product);

    public void delete(int id);
}