package com.example.rakshit.roompersistanceapidemo;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Locale;

public class MainActivity extends LifecycleActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();

        fetchData();
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void fetchData() {
        StringBuilder sb = new StringBuilder();
        List<Event> youngUsers = db.eventDao().findAll();
        for (Event youngUser : youngUsers) {
            Log.e("id", "fetchData: " + youngUser.id );
            Log.e("id", "fetchData: " + youngUser.name );
            Log.e("id", "fetchData: " + youngUser.description);
        }
        Log.e("DATA", "fetchData: " + sb);
    }

    private void populateDb() {

        DatabaseInitializer.populateSync(db);
    }

}
