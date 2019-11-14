package com.example.assignment9;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {
    private LogRepository repository;
    private List<RoomEntity> allEntities;

    public RoomViewModel(@NonNull Application application) {
        super(application);
        repository = new LogRepository(application);
        allEntities = repository.getAllLogs();
    }

    public void insert(RoomEntity roomEntity){
        repository.insert(roomEntity);
    }

    public void update(RoomEntity roomEntity){
        repository.update(roomEntity);
    }

    public void delete(RoomEntity roomEntity){
        repository.delete(roomEntity);
    }

    public List<RoomEntity> getAllEntities() {
        return allEntities;
    }
}
