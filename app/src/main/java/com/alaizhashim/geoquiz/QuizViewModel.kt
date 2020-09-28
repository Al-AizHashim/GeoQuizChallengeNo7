package com.alaizhashim.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

private const val TAG="QuizViewModel"
class QuizViewModel:ViewModel() {
    var arrayOfRandomIndex = Array<Int>(6) { 0 }
    init {
        for (value in 0..5) {
            when(value){
                0,1 -> {
                    arrayOfRandomIndex[value] = Random.nextInt(0, 6)
                    //to avoid repeating the question
                    if (value==1){
                        while (arrayOfRandomIndex[value]==arrayOfRandomIndex[value-1]){
                            arrayOfRandomIndex[value] = Random.nextInt(0, 6)
                        }
                    }
                }
                2,3 ->{
                    arrayOfRandomIndex[value]= Random.nextInt(6,12)
                    //to avoid repeating the question
                    if (value==3){
                        while (arrayOfRandomIndex[value]==arrayOfRandomIndex[value-1]){
                            arrayOfRandomIndex[value] = Random.nextInt(6,12)
                        }
                    }

                }
                4,5 ->{
                    arrayOfRandomIndex[value]= Random.nextInt(12, 18)
                    //to avoid repeating the question
                    if (value==5){
                        while (arrayOfRandomIndex[value]==arrayOfRandomIndex[value-1]){
                            arrayOfRandomIndex[value] = Random.nextInt(12, 18)
                        }
                    }

                }
            }
        }
    }
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8,false ),
        Question(R.string.question_9, false),
        Question(R.string.question_10,false ),
        Question(R.string.question_11,true ),
        Question(R.string.question_12,false ),
        Question(R.string.question_13,true ),
        Question(R.string.question_14, false),
        Question(R.string.question_15,true ),
        Question(R.string.question_16, true),
        Question(R.string.question_17,false ),
        Question(R.string.question_18, false)
    )
    //var arraySize=questionBank.size
    var currentIndex =0
    var score=0
    var isCheater = false
    val currentQuestionAnswer: Boolean
    get() = questionBank[arrayOfRandomIndex[currentIndex]].answer
    val currentQuestionText: Int
        get() = questionBank[arrayOfRandomIndex[currentIndex]].textResId
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % arrayOfRandomIndex.size
    }



}