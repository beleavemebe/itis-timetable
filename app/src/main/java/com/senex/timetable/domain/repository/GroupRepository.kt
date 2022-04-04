package com.senex.timetable.domain.repository

import com.senex.timetable.domain.entities.group.Group

interface GroupRepository: BaseRepository<Group> {
    suspend fun get(id: Long): Group?

    suspend fun getAll(): List<Group>

    suspend fun delete(id: Long)

    suspend fun deleteAll()
}