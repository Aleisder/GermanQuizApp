package com.example.quizapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.QuizViewModel
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {

    private var _binding: FragmentFinishBinding? = null
    private val binding get() = _binding!!

    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvResult.text = getString(
                R.string.title_result,
                viewModel.getCorrectAnswers(),
                viewModel.getAllTasksAmount()
            )

            btReturnToStart.setOnClickListener {
                findNavController().navigate(R.id.action_finishFragment_to_startFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.restartViewModel()
        _binding = null
    }

}