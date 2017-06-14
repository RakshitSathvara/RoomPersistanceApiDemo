package com.example.rakshit.roompersistanceapidemo;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Date;

/**
 * Created by Rakshit on 13-06-2017.
 */

public class DatabaseInitializer {

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static void populateWithTestData(AppDatabase db) {
        db.eventDao().deleteAll();

        Event event1 = addEvent(db, "Rakshit", "E-Btua");
        Event event2 = addEvent(db, "Rakshit", "E-Btua1");
        Event event3 = addEvent(db, "Rakshit", "E-Btu2");
        Event event4 = addEvent(db, "Rakshit", "E-Btu3");
        Event event5 = addEvent(db, "Rakshit", "E-Btu4");

        addEvent(db, "Rakshit", "final");

    }

    private static Event addEvent(final AppDatabase db, final String name, final String description) {
        Event event = new Event();
        event.name = name;
        event.description = description;
        db.eventDao().addEvent(event);
        return event;
    }
}
