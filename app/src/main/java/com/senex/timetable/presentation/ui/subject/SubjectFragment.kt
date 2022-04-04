package com.senex.timetable.presentation.ui.subject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentSubjectBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class SubjectFragment : DaggerFragment() {
    private var _binding: FragmentSubjectBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: SubjectViewModel by viewModels(factoryProducer = { factory })

    private val args: SubjectFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        runBlocking {
            viewModel.setSubject(args.subjectId)
        }

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSubjectBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        initToolbar()

        val subject = viewModel.subject
        idText.text = subject.id.toString()

        viewModel.subjectVisibilityChangeListener = { isVisible ->
            if (isVisible) {
                showSubjectButton.visibility = View.INVISIBLE
                hideSubjectButton.visibility = View.VISIBLE
            } else {
                showSubjectButton.visibility = View.VISIBLE
                hideSubjectButton.visibility = View.INVISIBLE
            }
        }

        hideSubjectButton.setOnClickListener {
            viewModel.setSubjectVisibility(isVisible = false)
        }

        showSubjectButton.setOnClickListener {
            viewModel.setSubjectVisibility(isVisible = true)
        }
    }

    private fun FragmentSubjectBinding.initToolbar() {
        groupsToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_open_schedule_fragment -> {
                    navigateToGroupsFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToGroupsFragment() =
        findNavController().popBackStack()
}