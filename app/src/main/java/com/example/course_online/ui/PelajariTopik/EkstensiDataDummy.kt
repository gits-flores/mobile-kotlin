package com.example.course_online.ui.PelajariTopik

import com.example.course_online.R

fun listOfTopik(): List<Topik> {
    val topik = mutableListOf<Topik>()

    topik.add(
        Topik(
            R.drawable.ic_onboard_one,
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nunc massa, vestibulum ut orci at, varius ornare purus. Aliquam erat volutpat. Mauris elementum sit amet est placerat vestibulum. Aenean magna turpis, consectetur nec vulputate eget, mollis id nibh. Donec venenatis iaculis augue, in blandit neque posuere convallis. Pellentesque facilisis maximus nunc non luctus. Aliquam sollicitudin luctus blandit",
            1
        )
    )

    topik.add(
        Topik(
            R.drawable.ic_onboard_two,
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nunc massa, vestibulum ut orci at, varius ornare purus. Aliquam erat volutpat. Mauris elementum sit amet est placerat vestibulum. Aenean magna turpis, consectetur nec vulputate eget, mollis id nibh. Donec venenatis iaculis augue, in blandit neque posuere convallis. Pellentesque facilisis maximus nunc non luctus. Aliquam sollicitudin luctus blandit",
            2
        )
    )

    topik.add(
        Topik(
            R.drawable.ic_onboard_three,
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nunc massa, vestibulum ut orci at, varius ornare purus. Aliquam erat volutpat. Mauris elementum sit amet est placerat vestibulum. Aenean magna turpis, consectetur nec vulputate eget, mollis id nibh. Donec venenatis iaculis augue, in blandit neque posuere convallis. Pellentesque facilisis maximus nunc non luctus. Aliquam sollicitudin luctus blandit",
            3
        )
    )

    topik.add(
        Topik(
            R.drawable.blank_image,
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nunc massa, vestibulum ut orci at, varius ornare purus. Aliquam erat volutpat. Mauris elementum sit amet est placerat vestibulum. Aenean magna turpis, consectetur nec vulputate eget, mollis id nibh. Donec venenatis iaculis augue, in blandit neque posuere convallis. Pellentesque facilisis maximus nunc non luctus. Aliquam sollicitudin luctus blandit",
            4
        )
    )

    topik.add(
        Topik(
            R.drawable.ic_personal_growth,
            "Menembus Rintangan untuk Belajar dan Menemukan Potensi Tersembunyi Anda",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nunc massa, vestibulum ut orci at, varius ornare purus. Aliquam erat volutpat. Mauris elementum sit amet est placerat vestibulum. Aenean magna turpis, consectetur nec vulputate eget, mollis id nibh. Donec venenatis iaculis augue, in blandit neque posuere convallis. Pellentesque facilisis maximus nunc non luctus. Aliquam sollicitudin luctus blandit",
            5
        )
    )

    return topik
}