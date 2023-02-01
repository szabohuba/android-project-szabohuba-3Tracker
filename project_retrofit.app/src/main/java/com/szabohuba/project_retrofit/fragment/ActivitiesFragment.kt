package com.szabohuba.project_retrofit.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.szabohuba.project_retorfit.databinding.FragmentActivitiesBinding
import com.szabohuba.project_retrofit.viewmodel.ActivitiesViewModel

class ActivitiesFragment : Fragment() {

    private var _binding: FragmentActivitiesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this)[ActivitiesViewModel::class.java]

        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textActivities
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}