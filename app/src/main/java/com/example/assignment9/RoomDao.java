package com.example.assignment9;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomDao {

    //RoomEntity dummy= new RoomEntity("Nyt menee", "ja lujaa", "Tiedän hyvin mitä olen tekemässä");
    //String username = dummy.getUsername();

    @Insert
    void insert(RoomEntity roomEntity);

    @Update
    void update(RoomEntity roomEntity);

    @Delete
    void delete(RoomEntity roomEntity);

    @Query("SELECT * FROM log_table ORDER BY timestamp DESC")
    List<RoomEntity> getAllNotes();

    // etsi käyttäjä? Miten saa muuttujan heitettyä tuohon?
    //@Query("SELECT * FROM log_table WHERE EXISTS(SELECT 1 FROM log_table WHERE username=" + username + ")")
    //List<RoomEntity> checkIfUser();

    // etsi kaikki käyttäjän loggaukset?
    //@Query("SELECT * FROM log_table WHERE EXISTS(SELECT * FROM log_table WHERE username=" + username + ")")
    //List<RoomEntity> checkAllUserInfo();
}
