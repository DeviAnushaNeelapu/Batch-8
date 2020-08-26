package com.muneiah.studentslogwithroomdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepo {
    StudentDataBase studentDb;
    LiveData<List<Students_entity>> listLiveData;
    public StudentRepo(Application ap){
        studentDb=StudentDataBase.getData(ap);
        listLiveData=studentDb.studentDAO().retrive();
    }
    public class MyAsyncTaskForUpdate extends AsyncTask<Students_entity,Void,Void>{

        @Override
        protected Void doInBackground(Students_entity... students_entities) {
            studentDb.studentDAO().update(students_entities[0]);
            return null;
        }
    }

    public class MyAsyncTaskForInsert extends AsyncTask<Students_entity,Void,Void>{

        @Override
        protected Void doInBackground(Students_entity... students_entities) {
            studentDb.studentDAO().insert(students_entities[0]);
            return null;
        }
    }
    public class MyAsyncTaskForDelete extends AsyncTask<Students_entity,Void,Void>{

        @Override
        protected Void doInBackground(Students_entity... students_entities) {
            studentDb.studentDAO().delete(students_entities[0]);
            return null;
        }
    }
    public LiveData<List<Students_entity>> liveData(){
        return listLiveData;
    }

    public void insert(Students_entity entity){
         new MyAsyncTaskForInsert().execute(entity);
    }
    public void update(Students_entity entity){
        new MyAsyncTaskForUpdate().execute(entity);
    }
    public void delete(Students_entity entity){
        new MyAsyncTaskForDelete().execute(entity);
    }

}
