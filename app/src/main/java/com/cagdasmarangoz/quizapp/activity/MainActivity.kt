package com.cagdasmarangoz.quizapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.cagdasmarangoz.quizapp.R
import com.cagdasmarangoz.quizapp.databinding.ActivityMainBinding
import com.cagdasmarangoz.quizapp.domain.QuestionModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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

                val intent = Intent(this@MainActivity, QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)
            }
            bottomMenuId.setItemSelected(R.id.home)
            bottomMenuId.setOnItemSelectedListener {
                if (it == R.id.board) {
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))
                }
            }
        }
    }

    private fun questionList(): MutableList<QuestionModel> {
        val question: MutableList<QuestionModel> = mutableListOf()
        question.add(
            QuestionModel(
                1,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "a",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                2,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_2",
                null
            )
        )
        question.add(
            QuestionModel(
                3,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_3",
                null
            )
        )
        question.add(
            QuestionModel(
                4,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                5,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                6,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                7,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                8,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                9,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                10,
                "Dünyanın en büyük okyanusu hangisidir?",
                "Atlantik Okyanusu",
                "Hint Okyanusu",
                "Arktik Okyanusu",
                "asifik Okyanusu",
                "d",
                5,
                "q_1",
                null
            )
        )
        return question
    }
}