package com.cagdasmarangoz.quizapp.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.cagdasmarangoz.quizapp.R
import com.cagdasmarangoz.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        binding.apply {
            singleBtn.setOnClickListener {

            }
            bottomMenuId.setItemSelected(R.id.home)
            bottomMenuId.setOnItemSelectedListener {
                if (it == R.id.board) {

                }
            }
        }
    }
}