package com.tugastengahsemeter.triwiboworidhopermana.ui.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tugastengahsemeter.triwiboworidhopermana.R
import com.tugastengahsemeter.triwiboworidhopermana.repository.WelcomeRepository
import com.tugastengahsemeter.triwiboworidhopermana.ui.fragment.ListCourseFragment
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.ViewModelFactory
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.WelcomeViewModel

class WelcomeActivity : AppCompatActivity() {

    companion object {
        lateinit var welcomeViewModel: WelcomeViewModel
        lateinit var activity: WelcomeActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        activity = this
        title = resources.getString(R.string.welcome)
        welcomeViewModel = configViewModel(
            arg = WelcomeRepository(),
            viewModelClass = WelcomeViewModel::class.java
        )
    }

    private fun <T, C : ViewModel> configViewModel(arg: T, viewModelClass: Class<C>): C {
        val factory = ViewModelFactory(arg = arg)
        return ViewModelProvider(this, factory).get(viewModelClass)
    }
}