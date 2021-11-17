package com.example.course_online.ui.onBoarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.course_online.R

class ViewPagerAdapter(
    private var context: Context,
    private var onBoardingList: List<OnBoardingData>
) : PagerAdapter() {
    override fun getCount(): Int {
        return onBoardingList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.onboardingscreen, null)
        val image: ImageView
        val title: TextView
        val desc: TextView

        image = view.findViewById(R.id.img_view)
        title = view.findViewById(R.id.tv_title)
        desc = view.findViewById(R.id.tv_desc)

        image.setImageResource(onBoardingList[position].image)
        title.text = onBoardingList[position].title
        desc.text = onBoardingList[position].desc
        container.addView(view)
        return view
    }
}