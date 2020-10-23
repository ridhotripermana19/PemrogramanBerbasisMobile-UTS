package com.tugastengahsemeter.triwiboworidhopermana.repository

import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.tugastengahsemeter.triwiboworidhopermana.model.Course
import com.tugastengahsemeter.triwiboworidhopermana.ui.fragment.ListCourseFragment
import com.tugastengahsemeter.triwiboworidhopermana.ui.fragment.ListCourseFragmentDirections

class ListCourseRepository : Repository<Course, MutableLiveData<List<Course>>, Unit>(){

    private val listData: MutableList<Course> = mutableListOf()
    private val course: MutableLiveData<List<Course>> = MutableLiveData()

    override fun setData(data: Course) {
        listData.add(data)
        course.value = listData
    }

    override fun getData(): MutableLiveData<List<Course>> = course

    override fun navigate(view: View?, optionalData: Course?, navigateBack: Boolean) {
        when {
            navigateBack -> Navigation.findNavController(view!!).popBackStack()
            else -> {
                when {
                    optionalData != null -> {
                        val action = ListCourseFragmentDirections.actionListCourseFragmentToDetailCourseFragment(optionalData)
                        Navigation.findNavController(view!!).navigate(action)
                    }
                    else -> {
                        val action = ListCourseFragmentDirections.actionListCourseFragmentToAddCourseFragment()
                        Navigation.findNavController(view!!).navigate(action)
                    }
                }
            }
        }
    }


}