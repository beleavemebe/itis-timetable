package com.senex.timetable.data.model.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.domain.entities.group.Group
import com.senex.timetable.domain.entities.schedule.DailySchedule
import com.senex.timetable.domain.entities.schedule.DailyScheduleEntity
import com.senex.timetable.domain.entities.schedule.ScheduleEntity

data class Schedule(
    @Embedded
    val schedule: ScheduleEntity,
    @Relation(
        parentColumn = "group_id",
        entityColumn = "id",
    )
    val group: Group,
    @Relation(
        entity = DailyScheduleEntity::class,
        parentColumn = "id",
        entityColumn = "schedule_id",
    )
    val dailySchedules: List<DailySchedule>,
)