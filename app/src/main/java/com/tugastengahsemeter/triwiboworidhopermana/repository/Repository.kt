package com.tugastengahsemeter.triwiboworidhopermana.repository

import android.os.Bundle
import android.view.View

abstract class Repository<P1, P2, P3> {
    abstract fun setData(data: P1)
    abstract fun getData() : P2
    abstract fun navigate(view: View?,  optionalData: P1?, navigateBack: Boolean) : P3
}