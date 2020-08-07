package com.lmw.livebus.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lmw.livebus.bean.User
import com.lmw.livebus.lib.LMWLiveBus
import java.util.*

class SecondViewModel : ViewModel() {
    var data: MutableLiveData<User> = MutableLiveData()
}