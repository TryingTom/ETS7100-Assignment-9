package com.example.assignment9;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = RoomEntity.class, version = 1)
public abstract class RoomLogDB extends RoomDatabase {

    private static RoomLogDB instance;

    public abstract RoomDao roomDao();

    public static synchronized RoomLogDB getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RoomLogDB.class, "log_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        // onOpen could work too? maybe
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private RoomDao roomDao;

        private PopulateDbAsyncTask(RoomLogDB db){
            roomDao = db.roomDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            roomDao.insert(new RoomEntity("Username1", "Password1", "Timestamp1"));
            return null;
        }
    }
}
