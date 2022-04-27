package com.senex.timetable.presentation.ui.hidden

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.senex.timetable.databinding.FragmentHiddenSubjectsBinding
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.common.initNavToolbar

class HiddenSubjectsFragment : BindingFragment<FragmentHiddenSubjectsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHiddenSubjectsBinding =
        FragmentHiddenSubjectsBinding::inflate

    override fun FragmentHiddenSubjectsBinding.onViewCreated() {
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }
}