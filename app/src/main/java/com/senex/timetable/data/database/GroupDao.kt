package com.senex.timetable.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.senex.timetable.data.models.group.Group

@Dao
interface GroupDao: BaseDao<Group> {
    @Query("SELECT * FROM groups WHERE id = :id")
    suspend fun get(id: Long): Group?

    @Query("SELECT * FROM groups")
    fun getAll(): LiveData<List<Group>>

    @Query("DELETE FROM groups WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM groups")
    suspend fun deleteAll()
}