package com.tugastengahsemeter.triwiboworidhopermana.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugastengahsemeter.triwiboworidhopermana.R
import com.tugastengahsemeter.triwiboworidhopermana.model.Course
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.CourseViewModel

class ListCourseAdapter(private val viewModel: CourseViewModel, val keyBundle: String) : RecyclerView.Adapter<CourseViewHolder>() {
    private var listCourses: List<Course> = ArrayList()

    fun setListCourses(listCourses: List<Course>) {
        this.listCourses = listCourses
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder =
        CourseViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_course, parent, false
            )
        )

    override fun getItemCount(): Int = listCourses.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(course = listCourses[position], viewModel = viewModel)
    }
}