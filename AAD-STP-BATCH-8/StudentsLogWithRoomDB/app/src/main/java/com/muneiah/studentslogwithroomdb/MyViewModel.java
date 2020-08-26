package com.muneiah.studentslogwithroomdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    StudentRepo stuRepo;
    LiveData<List<Students_entity>> liveData_model;
    public MyViewModel(@NonNull Application application) {
        super(application);
        stuRepo=new StudentRepo(application);
        liveData_model=stuRepo.liveData();
    }
    public void insert(Students_entity entity){
        stuRepo.insert(entity);
    }
    public void update(Students_entity entity){
        stuRepo.update(entity);
    }
    public void delete(Students_entity entity){
        stuRepo.delete(entity);
    }
    public LiveData<List<Students_entity>> liveData(){
        return liveData_model;
    }
}
