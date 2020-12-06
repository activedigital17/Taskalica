package com.aplantas.taskalica.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aplantas.taskalica.data.ToDoDatabase
import com.aplantas.taskalica.data.models.TodoData
import com.aplantas.taskalica.data.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application):AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository:ToDoRepository
    private val getAllData : LiveData<List<TodoData>>

    init {
        repository=ToDoRepository(toDoDao)
        getAllData = repository.getAllData

    }

    fun insertData(toDoData: TodoData) {

        viewModelScope.launch(Dispatchers.IO) {  repository.insertData(toDoData) }
    }


}