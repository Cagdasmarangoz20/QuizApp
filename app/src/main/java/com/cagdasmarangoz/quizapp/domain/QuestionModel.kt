package com.cagdasmarangoz.quizapp.domain

import android.os.Parcel
import android.os.Parcelable
import com.cagdasmarangoz.quizapp.Adapter.QuestionAnswer
import com.cagdasmarangoz.quizapp.Adapter.QuestionAnswerType

data class QuestionModel(
    val id: Int,
    val question: String?,
    val answer_1: String?,
    val answer_2: String?,
    val answer_3: String?,
    val answer_4: String?,
    val correctAnswer: String?,
    val score: Int,
    val picPath: String?,
    var clickedAnswer: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(question)
        parcel.writeString(answer_1)
        parcel.writeString(answer_2)
        parcel.writeString(answer_3)
        parcel.writeString(answer_4)
        parcel.writeString(correctAnswer)
        parcel.writeInt(score)
        parcel.writeString(picPath)
        parcel.writeString(clickedAnswer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionModel> {
        override fun createFromParcel(parcel: Parcel): QuestionModel {
            return QuestionModel(parcel)
        }

        override fun newArray(size: Int): Array<QuestionModel?> {
            return arrayOfNulls(size)
        }
    }

    fun answers(): List<QuestionAnswer> = listOf(
        QuestionAnswer(
            position = 0,
            answer = answer_1.orEmpty(),
            type = QuestionAnswerType.NONE
        ),
        QuestionAnswer(
            position = 1,
            answer = answer_3.orEmpty(),
            type = QuestionAnswerType.NONE
        ),
        QuestionAnswer(
            position = 2,
            answer = answer_3.orEmpty(),
            type =  QuestionAnswerType.NONE
        ),
        QuestionAnswer(
            position = 3,
            answer = answer_4.orEmpty(),
            type =  QuestionAnswerType.NONE
        ),

        )

    fun isCorrect(answer: QuestionAnswer): Boolean {
        val position = when (correctAnswer) {
            "a" -> 0
            "b" -> 1
            "c" -> 2
            "d" -> 3
            else -> null
        }
        return position == answer.position
    }

}
