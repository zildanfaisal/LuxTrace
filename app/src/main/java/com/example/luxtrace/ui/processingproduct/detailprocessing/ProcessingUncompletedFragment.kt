package com.example.luxtrace.ui.processingproduct.detailprocessing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.luxtrace.R

class ProcessingUncompletedFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_processing_uncompleted, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDone:Button = view.findViewById(R.id.btnDone)
        btnDone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnDone) {
            val completedFragment = ProcessingCompletedFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.container_view, completedFragment, ProcessingCompletedFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

}