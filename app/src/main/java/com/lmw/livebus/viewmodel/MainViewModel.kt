package com.lmw.livebus.viewmodel

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lmw.livebus.bean.User
import com.lmw.livebus.constant.Keys
import com.lmw.livebus.lib.LMWLiveBus
import java.util.*

class MainViewModel : ViewModel() {
    var data: MutableLiveData<User> = MutableLiveData()

    fun changeValue() {
        var user = User()
        user.id = "" + Random().nextInt(100)
        data?.value = user
        LMWLiveBus.getInstance().withSticky(Keys.EVENT_MAIN_TO_SECOND_VALUE).value = user
    }

    fun changeValue2() {
        var user = User()
        user.name = "" + Random().nextInt(100)
        data?.value = user
    }
}