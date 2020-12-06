package com.aplantas.taskalica.data.repository

import androidx.lifecycle.LiveData
import com.aplantas.taskalica.data.ToDoDao
import com.aplantas.taskalica.data.models.TodoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData:LiveData<List<TodoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: TodoData){
        toDoDao.insertData(toDoData)
    }
}