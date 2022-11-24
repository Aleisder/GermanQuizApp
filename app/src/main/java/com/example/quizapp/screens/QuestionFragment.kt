package com.example.quizapp.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.QuizViewModel
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuestionBinding
import com.example.quizapp.model.Task

class QuestionFragment : Fragment() {

    private val viewModel: QuizViewModel by activityViewModels()

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentTask = viewModel.getCurrentTask()

        setQuizByTask(currentTask)

        viewModel.taskNumber.observe(viewLifecycleOwner) {
            binding.progressBar.progress =
                (it.toDouble() / viewModel.getAllTasksAmount() * 100).toInt()
            binding.tvProgress.text = getString(
                R.string.title_progress,
                it,
                viewModel.getAllTasksAmount()
            )
        }




        binding.btNextQuestion.setOnClickListener {

            viewModel.dropLastQuestion()

            val pickedAnswer = binding.rgVariants.checkedRadioButtonId

            val picked = view.findViewById<RadioButton>(pickedAnswer)

            if (picked.text == currentTask.answer) {
                viewModel.increaseCorrectAnswersAmount()
            }

            if (viewModel.getRestTasksAmount() == 0) {
                findNavController().navigate(R.id.action_questionFragment_to_finishFragment)
            } else {
                viewModel.increaseTaskNumber()
                findNavController().navigate(R.id.action_questionFragment_self)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setQuizByTask(task: Task) {
        binding.apply {

            tvQuestion.text = task.question

            rbVariant1.text = task.variants[0]
            rbVariant2.text = task.variants[1]
            rbVariant3.text = task.variants[2]
            rbVariant4.text = task.variants[3]

        }
    }

}