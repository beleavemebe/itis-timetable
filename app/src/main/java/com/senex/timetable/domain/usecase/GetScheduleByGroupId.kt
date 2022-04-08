package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.local.ScheduleRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetScheduleByGroupId @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
) {
    operator fun invoke(groupId: Long) = scheduleRepository.getByGroupId(groupId).map {
        it ?: throw IllegalArgumentException("Schedule for groupId: $groupId not found")
    }
}