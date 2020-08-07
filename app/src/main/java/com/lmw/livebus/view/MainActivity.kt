package com.lmw.livebus.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lmw.livebus.R
import com.lmw.livebus.bean.User
import com.lmw.livebus.constant.Keys
import com.lmw.livebus.databinding.ActivityMainBinding
import com.lmw.livebus.lib.LMWLiveBus
import com.lmw.livebus.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        var model = ViewModelProviders.of(this).get(MainViewModel::class.java)
        dataBinding.viewModel = model
        dataBinding.lifecycleOwner = this

        LMWLiveBus.getInstance().with(Keys.EVENT_MAIN_TO_SECOND_VALUE, User::class.java)
            .observe(this, Observer {
                model?.changeValue2()
            })

        btnChange?.setOnClickListener {
            model?.changeValue()
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}