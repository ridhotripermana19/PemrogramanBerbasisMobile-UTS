package com.tugastengahsemeter.triwiboworidhopermana.viewmodel

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tugastengahsemeter.triwiboworidhopermana.model.Course
import com.tugastengahsemeter.triwiboworidhopermana.repository.Repository

class CourseViewModel(private val repository: Repository<Course, MutableLiveData<List<Course>>, Unit>) :
    ViewModel() {
    fun addData(data: Course) = repository.setData(data)
    fun getData(): LiveData<List<Course>> = repository.getData()
    fun navigate(view: View, optionalData: Course?, navigateBack: Boolean) =
        repository.navigate(
            view = view,
            optionalData = optionalData,
            navigateBack = navigateBack
        )
}