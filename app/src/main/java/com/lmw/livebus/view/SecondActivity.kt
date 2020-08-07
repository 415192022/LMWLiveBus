package com.lmw.livebus.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lmw.livebus.R
import com.lmw.livebus.bean.User
import com.lmw.livebus.constant.Keys
import com.lmw.livebus.databinding.ActivitySecondBinding
import com.lmw.livebus.lib.LMWLiveBus
import com.lmw.livebus.viewmodel.SecondViewModel
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBinding: ActivitySecondBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_second)
        var model = ViewModelProviders.of(this).get(SecondViewModel::class.java)
        dataBinding.viewModel = model
        dataBinding.lifecycleOwner = this

        LMWLiveBus.getInstance().withSticky(Keys.EVENT_MAIN_TO_SECOND_VALUE, User::class.java)
            .observe(this, Observer {
                model?.data?.value = it
            })

        btnChange?.setOnClickListener {
            var user = User()
            user.id = "" + Random().nextInt(2)
            LMWLiveBus.getInstance().with(Keys.EVENT_MAIN_TO_SECOND_VALUE, User::class.java)
                .postValue(user)
            finish()
        }
    }
}