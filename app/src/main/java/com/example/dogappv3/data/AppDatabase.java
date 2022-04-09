package com.example.dogappv3.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.dogappv3.model.DogBreed;

@Database(entities = {DogBreed.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
//    public abstract ContactDao contactDao();

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
//            instance = Room.databaseBuilder(context,
//                    AppDatabase.class, "contactapp").build();
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, "contactapp")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}