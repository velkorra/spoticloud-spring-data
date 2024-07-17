package com.example.spoticloudspringdata.exceptions;

public class TrackNotFoundException extends RuntimeException{
    public TrackNotFoundException(int id){
        super("Could not find track with id " + id);
    }
}
