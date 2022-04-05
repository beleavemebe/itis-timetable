package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.ScheduleDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.model.schedule.ScheduleInfo
import com.senex.timetable.domain.repository.ScheduleRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleDao: ScheduleDao,
) : ScheduleRepository {

    override suspend fun insert(item: ScheduleInfo) =
        scheduleDao.insert(item.transform())

    override suspend fun insertAll(vararg items: ScheduleInfo) =
        scheduleDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: ScheduleInfo) =
        scheduleDao.update(item.transform())

    override suspend fun delete(item: ScheduleInfo) =
        scheduleDao.delete(item.transform())

    override suspend fun get(id: Long) =
        scheduleDao.get(id)?.transform()

    override suspend fun deleteById(id: Long) =
        scheduleDao.delete(id)

    override suspend fun getByGroupId(groupId: Long) =
        scheduleDao.getByGroupId(groupId)?.transform()

    override fun getAll() =
        scheduleDao.getAll().map { list -> list.map { it.transform() } }

    override suspend fun deleteAll() =
        scheduleDao.deleteAll()
}