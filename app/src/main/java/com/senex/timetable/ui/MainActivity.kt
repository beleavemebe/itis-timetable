package com.senex.timetable.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senex.timetable.databinding.ActivityMainBinding
import com.senex.timetable.models.entities.DaySchedule
import com.senex.timetable.models.entities.GroupSchedule
import com.senex.timetable.models.entities.Subject
import com.senex.timetable.models.entities.SubjectType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}