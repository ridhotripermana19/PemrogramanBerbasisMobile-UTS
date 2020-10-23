package com.tugastengahsemeter.triwiboworidhopermana.repository

import android.view.View
import androidx.navigation.Navigation
import com.tugastengahsemeter.triwiboworidhopermana.model.User
import com.tugastengahsemeter.triwiboworidhopermana.ui.fragment.WelcomeFragmentDirections

class WelcomeRepository : Repository<User, User, View.OnClickListener>() {

    lateinit var user: User

    override fun setData(data: User) {
        user = data
    }

    override fun getData(): User {
        return user
    }

    override fun navigate(
        view: View?,
        optionalData: User?,
        navigateBack: Boolean
    ): View.OnClickListener {
        return Navigation.createNavigateOnClickListener(WelcomeFragmentDirections.actionWelcomeFragmentToListCourseFragment())
    }
}