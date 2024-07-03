package com.example.elkdocsassignment

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat


class EdgeLightingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val redColor = ContextCompat.getColor(context, R.color.red)
    private val blueColor = ContextCompat.getColor(context, R.color.blue)

    private val gradientPaint = Paint().apply {
        style = Paint.Style.STROKE
    }

    private var startX = 0f
    private var startY = 0f
    private var endX = width.toFloat()
    private var endY = height.toFloat()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateGradient()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()
        canvas.drawRect(0f, 0f, width, height, gradientPaint)
    }

    private fun updateGradient() {
        gradientPaint.shader = LinearGradient(
            startX, startY, endX, endY,
            redColor, blueColor,
            Shader.TileMode.REPEAT
        )
        invalidate()
    }

    fun updateGradientPosition(fraction: Float) {
        startX = width * fraction
        startY = height * fraction
        endX = width * (1 - fraction)
        endY = height * (1 - fraction)
        updateGradient()
    }

    fun updateStrokeWidth(width: Float) {
        gradientPaint.strokeWidth = width
    }

}
