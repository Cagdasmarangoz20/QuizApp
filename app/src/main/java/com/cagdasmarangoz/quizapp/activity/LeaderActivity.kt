package com.cagdasmarangoz.quizapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cagdasmarangoz.quizapp.Adapter.LeaderAdapter
import com.cagdasmarangoz.quizapp.R
import com.cagdasmarangoz.quizapp.databinding.ActivityLeaderBinding
import com.cagdasmarangoz.quizapp.domain.UserModel

class LeaderActivity : AppCompatActivity() {

    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        binding.apply {
            scoreTxt.text = loadData().get(0).score.toString()
            scoreTxt1.text = loadData().get(1).score.toString()
            scoreTxt2.text = loadData().get(2).score.toString()
            tileTop1Txt.text = loadData().get(0).name
            tileTop2Txt.text = loadData().get(1).name
            tileTop3Txt.text = loadData().get(2).name

            val drawableResourceId1: Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic,
                "drawable",
                binding.root.context.packageName
            )
            val drawableResourceId2: Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic,
                "drawable",
                binding.root.context.packageName
            )
            val drawableResourceId3: Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic,
                "drawable",
                binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)
            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic2)
            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)

            bottomMenuId.setItemSelected(R.id.board)
            bottomMenuId.setOnItemSelectedListener {
                if (it == R.id.home) {
                    startActivity(Intent(this@LeaderActivity, MainActivity::class.java))
                }
            }
            var list: MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)
            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }
        }

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