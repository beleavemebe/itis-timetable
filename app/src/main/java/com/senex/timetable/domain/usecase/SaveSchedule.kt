package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.repository.local.ScheduleRepository
import javax.inject.Inject

class SaveSchedule @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    private val saveGroup: SaveGroup,
    private val saveDailyScheduleList: SaveDailyScheduleList,
) {
    suspend operator fun invoke(schedule: Schedule) {
        // Do not change the order
        saveGroup(schedule.group)
        saveDailyScheduleList(schedule.dailySchedules)
        scheduleRepository.insert(schedule.scheduleInfo)
    }
}