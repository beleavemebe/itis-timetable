package com.senex.timetable.di

import com.senex.timetable.data.repository.local.*
import com.senex.timetable.domain.repository.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindDailyScheduleRepository(
        dailyScheduleRepositoryImpl: DailyScheduleRepositoryImpl,
    ): DailyScheduleRepository

    @Singleton
    @Binds
    abstract fun bindGroupRepository(
        groupRepositoryImpl: GroupRepositoryImpl,
    ): GroupRepository

    @Singleton
    @Binds
    abstract fun bindHiddenSubjectRepository(
        hiddenSubjectRepositoryImpl: HiddenSubjectRepositoryImpl,
    ): HiddenSubjectRepository

    @Singleton
    @Binds
    abstract fun bindScheduleRepository(
        scheduleRepositoryImpl: ScheduleRepositoryImpl,
    ): ScheduleRepository

    @Singleton
    @Binds
    abstract fun bindSubjectRepository(
        subjectRepositoryImpl: SubjectRepositoryImpl,
    ): SubjectRepository
}