package com.example.rakshit.roompersistanceapidemo;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Rakshit on 13-06-2017.
 */

@Dao
public interface EventDao {

    @Query("SELECT * FROM Event")
    List<Event> findAll();

    @Insert(onConflict = REPLACE)
    void addEvent(Event event);

    @Query("DELETE FROM Event")
    void deleteAll();
}
