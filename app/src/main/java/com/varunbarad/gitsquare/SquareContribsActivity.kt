package com.varunbarad.gitsquare

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.varunbarad.gitsquare.databinding.ActivitySquareContribsBinding

class SquareContribsActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivitySquareContribsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_square_contribs)
    }
}
