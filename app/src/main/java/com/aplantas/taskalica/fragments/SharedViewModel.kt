package com.aplantas.taskalica.fragments

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import com.aplantas.taskalica.data.models.Priority

class SharedViewModel(application: Application):AndroidViewModel(application) {


     fun verifyDataFromUser(title:String, description:String):Boolean{
        return if (TextUtils.isEmpty(title)|| TextUtils.isEmpty(description)){
            false
        }else !(title.isEmpty()||description.isEmpty())

    }

     fun parsePriority(priority: String): Priority {
        return when (priority) {

            "Important" -> {
                Priority.IMPORTANT}
            "Normal"-> {
                Priority.NORMAL}
            "Irrelevant"->{
                Priority.IRRELEVANT}
            else -> Priority.NORMAL

        }
    }
}