package com.aplantas.taskalica.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aplantas.taskalica.data.models.TodoData

@Database(entities = [TodoData::class], version= 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase:RoomDatabase() {

    abstract fun toDoDao():ToDoDao

    companion object{

        //stavlja bazu na null
        @Volatile
        private var INSTANCE:ToDoDatabase? = null


        fun getDatabase(context: Context):ToDoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            //kreira se baza
            //samo jedan thread kreira bazu podataka
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoDatabase::class.java,
                        "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}