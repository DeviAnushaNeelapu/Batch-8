package com.muneiah.studentslogwithroomdb;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Students_entity {
    @ColumnInfo(name = "name")
    @NonNull
    String name;
    @PrimaryKey
    @ColumnInfo(name = "rollnumber")
    @NonNull
    String rollNumber;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(@NonNull String rollNumber) {
        this.rollNumber = rollNumber;
    }
}
