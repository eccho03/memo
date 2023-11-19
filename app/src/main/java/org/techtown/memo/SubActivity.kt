package org.techtown.memo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.techtown.memo.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.subTextTv.text = intent.getStringExtra("memo")
    }
}