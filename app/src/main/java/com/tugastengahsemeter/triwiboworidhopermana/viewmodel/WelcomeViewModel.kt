package com.tugastengahsemeter.triwiboworidhopermana.viewmodel

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import com.tugastengahsemeter.triwiboworidhopermana.model.User
import com.tugastengahsemeter.triwiboworidhopermana.repository.Repository

class WelcomeViewModel(private val repository: Repository<User, User, View.OnClickListener>) : ViewModel() {
    fun setDataUser(data: User) = repository.setData(data = data)
    fun getDataUser() = repository.getData()
    fun navigate(view: View?, optionalData: User?, navigateBack: Boolean) = repository.navigate(view = view,  optionalData = optionalData, navigateBack = navigateBack)
}