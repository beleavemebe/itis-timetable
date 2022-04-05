package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.SubjectRepository
import javax.inject.Inject

class GetSubjectById @Inject constructor(
    private val subjectRepository: SubjectRepository
) {
    suspend operator fun invoke(id: Long) =
        subjectRepository.get(id)
}