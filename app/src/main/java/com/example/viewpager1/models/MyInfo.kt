package com.example.viewpager1.models

import com.example.viewpager1.R

object MyInfo {

     val list = ArrayList<MyData>()

    fun loadData() {
        list.add(
            MyData(
                R.drawable.fon1,
                "Xush kelibsiz",
                "Kim ko'rubdur, ko'ngul,ahli jahondan yaxshilig'\n,Kimki ondin yaxshi yo'q,ko'z tutma ondin yaxshilig'"
            )
        )
        list.add(
            MyData(
                R.drawable.fon2,
                "Hikoyalar dunyosi",
                "Gar zamonni nayf qilsam ayb qilma, ey rafiq, Ko'rmadim hargiz netoyin, bu zamondin yaxshilig'!"
            )
        )
        list.add(
            MyData(
                R.drawable.fon3,
                "Kitob ortidan",
                "Dilrabolardan yomoliq keldi mahzun ko'ngluma, Kelmadi jonimg'a hech oromli jondin yaxshilig.'"
            )
        )
        list.add(
            MyData(
                R.drawable.fon4,
                "Bizga qo'shiling",
                "Ey ko'ngul, chun yaxshidin ko'rdung yamonliq asru ko'p, Emdi ko'z tutmoq ne ma'ni har yaxshilig'?"
            )
        )
    }
}