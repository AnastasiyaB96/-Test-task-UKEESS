package com.belaia.anastasia.testtaskukeess

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.belaia.anastasia.testtaskukeess.data.EventsRepository
import com.belaia.anastasia.testtaskukeess.databinding.FragmentEventsBinding

class EventsFragment : Fragment() {
    private var _binding: FragmentEventsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = EventsRepository.getAllPeopleData()
        val adapter = EventsAdapter(data)
        binding.eventsRecyclerView.adapter = adapter
    }
}