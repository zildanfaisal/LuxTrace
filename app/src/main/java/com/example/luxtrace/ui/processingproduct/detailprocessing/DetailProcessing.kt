package com.example.luxtrace.ui.processingproduct.detailprocessing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.luxtrace.R
import com.example.luxtrace.databinding.ActivityDetailProcessingBinding

class DetailProcessing : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProcessingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProcessingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        val fragmentManager = supportFragmentManager
        val unCompletedFragment = ProcessingUncompletedFragment()
        val fragment = fragmentManager.findFragmentByTag(ProcessingUncompletedFragment::class.java.simpleName)
        if (fragment !is ProcessingUncompletedFragment) {
            fragmentManager
                .beginTransaction()
                .add(R.id.container_view, unCompletedFragment, ProcessingUncompletedFragment::class.java.simpleName)
                .commit()
        }

    }
}