package com.tugastengahsemeter.triwiboworidhopermana.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.tugastengahsemeter.triwiboworidhopermana.R
import com.tugastengahsemeter.triwiboworidhopermana.model.Course
import com.tugastengahsemeter.triwiboworidhopermana.ui.activity.WelcomeActivity
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.CourseViewModel
import kotlinx.android.synthetic.main.fragment_add_course.*

class AddCourseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCustomTitle(resources.getString(R.string.addCourseTitle))
        val viewModel = ListCourseFragment.viewModel
        val activity = WelcomeActivity.activity
        btnSaveClicked(viewModel = viewModel, activity = activity)
    }

    private fun setCustomTitle(customTitle: String) {
        WelcomeActivity.activity.title = customTitle
    }

    private fun btnSaveClicked(viewModel: CourseViewModel, activity: WelcomeActivity) {
        btn_saveCouse.setOnClickListener {
            viewModel.addData(
                Course(
                    name = et_courseName.text.toString(),
                    encounter = et_encounter.text.toString().toInt(),
                    dueDate = et_dueDate.text.toString()
                )
            )
            viewModel.navigate(
                view = it,
                optionalData = null,
                navigateBack = true
            )
            val inputManager = WelcomeActivity.activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(requireView().windowToken, 0)
        }
    }
}