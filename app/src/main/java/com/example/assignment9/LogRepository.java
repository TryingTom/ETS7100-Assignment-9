package com.example.assignment9;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

public class LogRepository {
    private RoomDao roomDao;
    private List<RoomEntity> allLogs;

    public LogRepository(Application application) {
        RoomLogDB database = RoomLogDB.getInstance(application);
        roomDao = database.roomDao();
        allLogs = roomDao.getAllNotes();
    }

    public void insert (RoomEntity roomEntity){
        new InsertLogAsyncTask(roomDao).execute(roomEntity);
    }

    public void update (RoomEntity roomEntity){
        new UpdateLogAsyncTask(roomDao).execute(roomEntity);
    }

    public void delete (RoomEntity roomEntity){
        new DeleteLogAsyncTask(roomDao).execute(roomEntity);
    }

    public List<RoomEntity> getAllLogs(){
        return allLogs;
    }

    private static class UpdateLogAsyncTask extends AsyncTask<RoomEntity, Void, Void> {
        private RoomDao roomDao;

        private UpdateLogAsyncTask(RoomDao roomDao){
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(RoomEntity... roomEntities){
            roomDao.update(roomEntities[0]);
            return null;
        }

    }

    private static class DeleteLogAsyncTask extends AsyncTask<RoomEntity, Void, Void> {
        private RoomDao roomDao;

        private DeleteLogAsyncTask(RoomDao roomDao){
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(RoomEntity... roomEntities){
            roomDao.delete(roomEntities[0]);
            return null;
        }

    }


    private static class InsertLogAsyncTask extends AsyncTask<RoomEntity, Void, Void> {
        private RoomDao roomDao;

        private InsertLogAsyncTask(RoomDao roomDao){
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(RoomEntity... roomEntities){
            roomDao.insert(roomEntities[0]);
            return null;
        }

    }
}
