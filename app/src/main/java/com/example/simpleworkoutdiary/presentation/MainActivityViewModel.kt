package com.example.simpleworkoutdiary.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.simpleworkoutdiary.data.Workout
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlinx.datetime.Clock
import java.util.*

class MainActivityViewModel: ViewModel() {

    private val workoutSubject = BehaviorSubject.create<Workout>()

    /*
    val workout:Workout
        get() = workoutSubject.value!!

    val exerciseSubject = BehaviorSubject.create<String?>()
    var exercise:String?
        get() = exerciseSubject.value!!
        set(value) {
            exerciseSubject.onNext(value)
        }

    var setsSubject = BehaviorSubject.create<Int?>()
    var sets:Int?
        get() = setsSubject.value!!
        set(value) {
            setsSubject.onNext(value)
        }

    var repsSubject = BehaviorSubject.create<Int?>()
    var reps:Int
        get() = repsSubject.value!!
        set(value) {
            repsSubject.onNext(value)
        }


     */

    fun saveWorkout(){
        workoutSubject.subscribe(
            {
                //Сохранение записи в бд
            },
            {
                //Show error dialog
            }
        )
    }

    fun validateFields( exercise:String,
                        sets:String,
                        reps:String)
    {
        val workout = Workout()
        if (exercise != "") workout.exercise = exercise
        if (sets != "") workout.sets = sets.toInt()
        if (reps != "") workout.reps = reps.toInt()
        workoutSubject.onNext(workout)
    }


}