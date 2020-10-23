package com.tugastengahsemeter.triwiboworidhopermana.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tugastengahsemeter.triwiboworidhopermana.R
import com.tugastengahsemeter.triwiboworidhopermana.model.User
import com.tugastengahsemeter.triwiboworidhopermana.ui.activity.WelcomeActivity
import com.tugastengahsemeter.triwiboworidhopermana.viewmodel.WelcomeViewModel
import kotlinx.android.synthetic.main.welcome_fragment.*


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.welcome_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = WelcomeActivity.welcomeViewModel
        setDataUser(viewModel = viewModel)
        bindDataUserToView(viewModel = viewModel)
        btnNextClicked(viewModel = viewModel)
    }

    private fun setDataUser(viewModel: WelcomeViewModel) {
        viewModel.setDataUser(
            User(
                name = "Triwibowo Ridho Permana",
                studentId = 165410164,
                email = "165410164.triwiboworidho@gmail.com"
            )
        )
    }

    private fun bindDataUserToView(viewModel: WelcomeViewModel) {
        val dataUser = viewModel.getDataUser()
        tv_name.text = dataUser.name
        tv_studentId.text = dataUser.studentId.toString()
        tv_email.text = dataUser.email
    }

    private fun btnNextClicked(viewModel: WelcomeViewModel) =
        btn_next.setOnClickListener(
            viewModel.navigate(
                view = null,
                optionalData = null,
                navigateBack = false
            )
        )
}