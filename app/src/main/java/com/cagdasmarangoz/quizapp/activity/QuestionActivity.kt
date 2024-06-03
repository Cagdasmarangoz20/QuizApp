package com.cagdasmarangoz.quizapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cagdasmarangoz.quizapp.Adapter.QuestionAdapterr
import com.cagdasmarangoz.quizapp.Adapter.QuestionAnswer
import com.cagdasmarangoz.quizapp.Adapter.QuestionAnswerType
import com.cagdasmarangoz.quizapp.databinding.ActivityQuestionBinding
import com.cagdasmarangoz.quizapp.domain.QuestionModel

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    var position: Int = 0
    var receivedList: MutableList<QuestionModel> = mutableListOf()
    val question: QuestionModel get() = receivedList.get(position)
    val answers: List<QuestionAnswer> get() = question.answers()
    var allScore = 0
    private val mAdapter = QuestionAdapterr(::onItemClick)


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        receivedList = intent.getParcelableArrayListExtra<QuestionModel>("list")!!.toMutableList()

        binding.apply {
            backBtn.setOnClickListener { finish() }
            progressBar.progress = 1
            questionTxt.text = receivedList[position].question
            val drawableResourceId: Int = binding.root.resources.getIdentifier(
                receivedList[position].picPath, "drawable", binding.root.context.packageName
            )
            Glide.with(this@QuestionActivity)
                .load(drawableResourceId)
                .centerCrop()
                .apply(RequestOptions.bitmapTransform(RoundedCorners(60)))
                .into(pic)
            loadAnswers()

            rightArrow.setOnClickListener {
                if (progressBar.progress == 10) {
                    val intent = Intent(this@QuestionActivity, ScoreActivity::class.java)
                    intent.putExtra("score", allScore)
                    startActivity(intent)
                    return@setOnClickListener
                }
                position++
                progressBar.progress = progressBar.progress + 1
                questionNumber.text = "Question" + progressBar.progress + "/10"
                questionTxt.text = receivedList[position].question

                val drawableRequestId: Int = binding.root.resources.getIdentifier(
                    receivedList[position].picPath, "drawable", binding.root.context.packageName
                )
                Glide.with(this@QuestionActivity)
                    .load(drawableRequestId)
                    .centerCrop()
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(60)))
                    .into(pic)
                loadAnswers()

            }
            leftArrow.setOnClickListener {
                if (progressBar.progress == 1) {

                    return@setOnClickListener
                }

                progressBar.progress = progressBar.progress - 1
                questionNumber.text = "Question" + progressBar.progress + "/10"
                questionTxt.text = receivedList[position].question

                val drawableRequestId: Int = binding.root.resources.getIdentifier(
                    receivedList[position].picPath, "drawable", binding.root.context.packageName
                )
                Glide.with(this@QuestionActivity)
                    .load(drawableRequestId)
                    .centerCrop()
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(60)))
                    .into(pic)
                loadAnswers()
            }
        }

    }

    private fun loadAnswers() {
        mAdapter.submitList(answers)
        binding.questionList.apply {
            layoutManager = LinearLayoutManager(this@QuestionActivity)
            adapter = mAdapter
            itemAnimator = null
        }
    }

    var isAnswered = false

    private fun onItemClick(questionAnswer: QuestionAnswer) {
        if (isAnswered) return
        isAnswered = true
        val correctAnswer = answers.find { question.isCorrect(it) }

        val newList = mAdapter.currentList.map {
            if (it == questionAnswer && questionAnswer == correctAnswer) {
                it.copy(type = QuestionAnswerType.CORRECT)
            } else if (it == questionAnswer && questionAnswer != correctAnswer) {
                it.copy(type = QuestionAnswerType.WRONG)
            } else if (it != questionAnswer && it == correctAnswer) {
                it.copy(type = QuestionAnswerType.CORRECT)
            }else {
                it.copy(type = QuestionAnswerType.NONE)
            }
        }

        mAdapter.submitList(newList)

    }
}