package com.tugastengahsemeter.triwiboworidhopermana.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tugastengahsemeter.triwiboworidhopermana.model.Course
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.CourseViewModel
import kotlinx.android.synthetic.main.list_item_course.view.*

class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        course: Course,
        viewModel: CourseViewModel
    ) {
        with(itemView) {
            tv_courseName.text = course.name
            tv_detail.setOnClickListener {
                viewModel.navigate(view = it, optionalData = course, navigateBack = false)
            }
        }
    }
}