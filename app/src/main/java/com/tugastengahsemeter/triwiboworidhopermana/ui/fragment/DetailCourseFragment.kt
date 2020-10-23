package com.tugastengahsemeter.triwiboworidhopermana.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tugastengahsemeter.triwiboworidhopermana.R
import com.tugastengahsemeter.triwiboworidhopermana.model.Course
import com.tugastengahsemeter.triwiboworidhopermana.ui.activity.WelcomeActivity
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.CourseViewModel
import kotlinx.android.synthetic.main.detail_course_fragment.*

class DetailCourseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_course_fragment, container, false)
    }

    private val args: DetailCourseFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setCustomTitle(resources.getString(R.string.courseDetailTitle))
        bindArgsToView(course = args.detailCourse)
        backButtonPressed(viewModel = ListCourseFragment.viewModel)
    }

    private fun setCustomTitle(customTitle: String) {
        WelcomeActivity.activity.title = customTitle
    }

    private fun backButtonPressed(viewModel: CourseViewModel) {
        btn_back.setOnClickListener {
            viewModel.navigate(view = it, optionalData = null, navigateBack = true)
        }
    }

    private fun bindArgsToView(course: Course?) {
        val detailCourse: Course? = course
        when {
            detailCourse != null -> {
                tv_detailCourseName.text = detailCourse.name
                tv_detailEncounter.text = detailCourse.encounter.toString()
                tv_detailDueDate.text = detailCourse.dueDate
            }
        }
    }
}