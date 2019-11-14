package com.example.assignment9;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "log_table")
public class RoomEntity {

    @NonNull
    @PrimaryKey
    private String username;
    private String password;
    private String timestamp;

    public RoomEntity(String username, String password, String timestamp) {
        this.username = username;
        this.password = password;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
