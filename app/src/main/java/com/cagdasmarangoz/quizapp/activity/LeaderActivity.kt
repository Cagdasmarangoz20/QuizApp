package com.cagdasmarangoz.quizapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cagdasmarangoz.quizapp.R
import com.cagdasmarangoz.quizapp.databinding.ActivityLeaderBinding
import com.cagdasmarangoz.quizapp.domain.UserModel

class LeaderActivity : AppCompatActivity() {

    lateinit var binding: ActivityLeaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader)

    }

    private fun loadData(): MutableList<UserModel> {
        val users: MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1, "shopia", "person1", 4850))
        users.add(UserModel(2, "Daniel", "person2", 4560))
        users.add(UserModel(3, "James", "person3", 2356))
        users.add(UserModel(4, "John smiht", "person4", 3544))
        users.add(UserModel(5, "emly", "person5", 1235))
        users.add(UserModel(6, "David Brovn", "person6", 2365))
        users.add(UserModel(7, "Selena Gomez", "person7", 4999))
        users.add(UserModel(8, "Sarah", "person8", 4562))
        users.add(UserModel(9, "Michael", "person9", 1254))
        users.add(UserModel(10, "alex", "person9", 1945))
        return users
    }
}