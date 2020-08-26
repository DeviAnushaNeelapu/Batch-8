package com.muneiah.studentslogwithroomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Students_entity.class,version = 1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
    public abstract StudentDAO studentDAO();
    static StudentDataBase dataBase;
    //For Live Data
    public static synchronized StudentDataBase getData(Context ctx){
        dataBase= Room.databaseBuilder(ctx,StudentDataBase.class,"ap")
                .allowMainThreadQueries().build();
        return dataBase;
    }

}
