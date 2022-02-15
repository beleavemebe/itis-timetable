package com.senex.timetable.data.database

import androidx.room.*
import com.senex.timetable.data.models.Group

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Group): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg notes: Group)

    @Update
    suspend fun update(note: Group)

    @Delete
    suspend fun delete(note: Group)

    @Query("DELETE FROM groups WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("SELECT * FROM groups WHERE id = :id")
    suspend fun get(id: Long): Group?

    @Query("SELECT * FROM groups")
    suspend fun getAll(): List<Group>

    @Query("DELETE FROM groups")
    suspend fun deleteAll()
}