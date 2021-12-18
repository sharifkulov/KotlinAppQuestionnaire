package com.example.helloworld


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private lateinit var trueButton: Button
private lateinit var falseButton: Button
private lateinit var nextButton: Button
private lateinit var questionTextView: TextView
private val questionBank= listOf(
    Question(R.string.question_australia, true),
    Question(R.string.question_oceans, true),
    Question(R.string.question_mideast, false),
    Question(R.string.question_africa, false),
    Question(R.string.question_americas, true),
    Question(R.string.question_asia, true))
private var currentIndex = 0

private fun updateQuestion() {
    val questionTextResId = questionBank[currentIndex].questionResId
    questionTextView.setText(questionTextResId)
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)
        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = questionBank[currentIndex].correctAnswer
            val messageResId = if (userAnswer == correctAnswer) {
                "Правильный ответ"
            } else {
                "Неправильный ответ"
            }
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        }
        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)

        }
        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)


        }
        val questionTextResId = questionBank[currentIndex].questionResId
        questionTextView.setText(questionTextResId)
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].questionResId
            questionTextView.setText(questionTextResId)
        }


    }
}
