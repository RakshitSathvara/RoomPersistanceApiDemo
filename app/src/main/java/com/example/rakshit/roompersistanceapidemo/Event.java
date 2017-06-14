package com.example.rakshit.roompersistanceapidemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rakshit on 13-06-2017.
 */

@Entity
public class Event {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String description;

}
