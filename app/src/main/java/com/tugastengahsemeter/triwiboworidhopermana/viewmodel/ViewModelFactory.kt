package com.tugastengahsemeter.triwiboworidhopermana.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tugastengahsemeter.triwiboworidhopermana.model.Course
import com.tugastengahsemeter.triwiboworidhopermana.model.User
import com.tugastengahsemeter.triwiboworidhopermana.repository.Repository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory<T>(private val arg: T) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(WelcomeViewModel::class.java) -> WelcomeViewModel(repository = arg as Repository<User, User, View.OnClickListener>) as T
            modelClass.isAssignableFrom(CourseViewModel::class.java) -> CourseViewModel(repository = arg as Repository<Course, MutableLiveData<List<Course>>, Unit>) as T
            else -> throw IllegalArgumentException("View Model Not Found!!!")
        }
    }
}