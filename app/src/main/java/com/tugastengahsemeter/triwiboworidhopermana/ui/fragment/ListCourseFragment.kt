package com.tugastengahsemeter.triwiboworidhopermana.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.tugastengahsemeter.triwiboworidhopermana.R
import com.tugastengahsemeter.triwiboworidhopermana.adapter.ListCourseAdapter
import com.tugastengahsemeter.triwiboworidhopermana.repository.ListCourseRepository
import com.tugastengahsemeter.triwiboworidhopermana.ui.activity.WelcomeActivity
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.CourseViewModel
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.list_course_fragment.*


class ListCourseFragment : Fragment() {
    companion object {
        const val EXTRA_USER = "extra_user"
        lateinit var viewModel: CourseViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_course_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeTitle(customTitle = resources.getString(R.string.listCourseTitle))
        viewModel = configViewModel(
            arg = ListCourseRepository(),
            viewModelClass = CourseViewModel::class.java
        )
        val adapter = setListAdapter(recyclerView = rv_course, viewModel = viewModel)
        fetchListCourse(viewModel = viewModel, adapter = adapter)
        buttonAddClicked(viewModel = viewModel)
    }

    private fun changeTitle(customTitle: String) {
        WelcomeActivity.activity.title = customTitle
    }

    private fun <T, C : ViewModel> configViewModel(arg: T, viewModelClass: Class<C>): C {
        val factory = ViewModelFactory(arg = arg)
        return ViewModelProvider(this, factory).get(viewModelClass)
    }

    private fun setListAdapter(
        recyclerView: RecyclerView,
        viewModel: CourseViewModel
    ): ListCourseAdapter {
        val adapter = ListCourseAdapter(viewModel = viewModel, keyBundle = EXTRA_USER)
        recyclerView.adapter = adapter
        return adapter
    }

    private fun fetchListCourse(viewModel: CourseViewModel, adapter: ListCourseAdapter) {
        viewModel.getData().observe(viewLifecycleOwner, Observer {
            adapter.setListCourses(listCourses = it)
        })
    }

    private fun buttonAddClicked(viewModel: CourseViewModel) {
        btn_addCourse.setOnClickListener {
            viewModel.navigate(view = it, optionalData = null, navigateBack = false)
        }
    }
}