package com.aplantas.taskalica.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aplantas.taskalica.data.models.TodoData

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData():LiveData<List<TodoData>>


    //suspend znači da se vrti kao korutina na background threadu......Condflict strategy se koristi ako dođe do dupliciranja itemsa
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(todoData: TodoData)


}