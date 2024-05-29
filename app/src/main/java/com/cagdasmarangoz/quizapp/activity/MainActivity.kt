package com.cagdasmarangoz.quizapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cagdasmarangoz.quizapp.R
import com.cagdasmarangoz.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            singleBtn.setOnClickListener {

            }
            bottomMenuId.setItemSelected(R.id.home)
            bottomMenuId.setOnItemSelectedListener {
                if (it == R.id.board) {
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))
                }
            }
        }
    }
}