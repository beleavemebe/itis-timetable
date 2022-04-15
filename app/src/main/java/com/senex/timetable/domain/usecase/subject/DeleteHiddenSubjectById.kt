package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.repository.local.HiddenSubjectRepository
import javax.inject.Inject

class DeleteHiddenSubjectById @Inject constructor(
    private val hiddenSubjectRepository: HiddenSubjectRepository
) {
    suspend operator fun invoke(id: Long) = hiddenSubjectRepository.deleteById(id)
}