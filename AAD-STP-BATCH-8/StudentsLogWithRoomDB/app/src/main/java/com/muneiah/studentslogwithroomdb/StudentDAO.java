package com.muneiah.studentslogwithroomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    public void insert(Students_entity entity);
    @Update
    public void update(Students_entity entity);
    @Delete
    public void delete(Students_entity entity);
    @Query("SELECT * FROM STUDENT_TABLE")
    public LiveData<List<Students_entity>> retrive();//Live data room
 //   public List<Students_entity> retrive();//normal room
}
