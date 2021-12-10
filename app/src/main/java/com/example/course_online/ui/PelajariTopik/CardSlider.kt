package com.example.course_online.ui.PelajariTopik

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class CardSlider: ViewPager2.PageTransformer{

    companion object{
        private const val TAG = "CardSlider"
        private const val MIN_SCALE = 0.90f
        private const val MIN_ALPHA = 0.5f

        private const val DEFAULT_TRANSLATION_X = 0.0f
        private const val DEFAULT_TRANSLATION_FACTOR = 1.2f

        private const val DEFAULT_SCALE = 1f
        private const val DEFAULT_ALPHA = 1f
    }

    override fun transformPage(page: View, position: Float) {

        ViewCompat.setElevation(page, -abs(position))

        val pageWidth = page.width

        if (position < 0) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.translationX = DEFAULT_TRANSLATION_X
            page.scaleX = DEFAULT_SCALE
            page.scaleY = DEFAULT_SCALE
            page.alpha = DEFAULT_ALPHA + position

        } else if (position <= 1) {
            val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
//            val vertMargin = pageHeight * (1 - scaleFactor) / 2
//            val horzMargin = pageWidth * (1 - scaleFactor) / 2
            if (position < 0) {
                val scaleX = 1 + 0.1f * position
                page.setTranslationX((pageWidth / DEFAULT_TRANSLATION_FACTOR) * position)
                page.setScaleY(scaleX)
            } else {
                val scaleX = 1 - 0.1f * position
                page.setScaleY(scaleX)
                page.setTranslationX(-(pageWidth / DEFAULT_TRANSLATION_FACTOR) * position)
            }
            page.setScaleX(scaleFactor)
            page.setScaleY(scaleFactor)

            // Fade the page relative to its size.
            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA))
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.translationX = DEFAULT_TRANSLATION_X
            page.scaleX = DEFAULT_SCALE
            page.scaleY = DEFAULT_SCALE
            page. alpha = DEFAULT_ALPHA
        }
    }
}