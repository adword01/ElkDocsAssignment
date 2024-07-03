package com.example.elkdocsassignment

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.elkdocsassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example animation
        startEdgeLightingAnimation()

    }

    private fun startEdgeLightingAnimation() {
        // Gradient position animation
        val gradientAnimator = ValueAnimator.ofFloat(0f, 1f)
        gradientAnimator.duration = 3000 // 3 seconds
        gradientAnimator.repeatMode = ValueAnimator.REVERSE
        gradientAnimator.repeatCount = ValueAnimator.INFINITE
        gradientAnimator.addUpdateListener { animation ->
            binding.edgeLightingView.updateGradientPosition(animation.animatedValue as Float)
        }
        gradientAnimator.start()

        // Stroke width animation
        val strokeWidthAnimator = ValueAnimator.ofFloat(10f, 30f)
        strokeWidthAnimator.duration = 1000 // 1 second
        strokeWidthAnimator.repeatMode = ValueAnimator.REVERSE
        strokeWidthAnimator.repeatCount = ValueAnimator.INFINITE
        strokeWidthAnimator.addUpdateListener { animation ->
            binding.edgeLightingView.updateStrokeWidth(animation.animatedValue as Float)
        }
        strokeWidthAnimator.start()
    }
}