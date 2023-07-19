package com.example.myquiz

object Constants {

    const val USER_NAME: String= "user_name"
    const val total_ques : String= "total_ques"
    const val CORRECT_ANS: String= "correct_ans"


    fun getQuestions():ArrayList<Questions>{



        val quesList = ArrayList<Questions>()
        val ques1=Questions(
            1,"What country does this flag belongs?",R.drawable.usa1,"Australia",
            "New Zealand","United States of America","Spain",3
        )
        quesList.add(ques1)

        val ques2=Questions(
            2,"What country does this flag belongs?",R.drawable.brazil,"Brazil",
            "Cuba","India","Iraq",1
        )
        quesList.add(ques2)

        val ques3=Questions(
            3,"What country does this flag belongs?",R.drawable.vietnam,"China",
            "South Korea","Philippines","Vietnam",4
        )
        quesList.add(ques3)

        val ques4=Questions(
            4,"What country does this flag belongs?",R.drawable.iran,"Iraq",
            "Iran","Syria","Kuwait",2
        )
        quesList.add(ques4)

        val ques5=Questions(
            5,"What country does this flag belongs?",R.drawable.argentina,"Argentina",
            "Israel","Italy","Mexico",1
        )
        quesList.add(ques5)

        val ques6=Questions(
            6,"What country does this flag belongs?",R.drawable.uruguay,"Israel",
            "New Zealand","Uruguay","Afganistan",3
        )
        quesList.add(ques6)

        val ques7=Questions(
            7,"What country does this flag belongs?",R.drawable.russia,"France",
            "Russia","United States of America","Finland",2
        )
        quesList.add(ques7)

        val ques8=Questions(
            8,"What country does this flag belongs?",R.drawable.austria,"Turkey",
            "Croatia","Switzerland","Austria",4
        )
        quesList.add(ques8)

        val ques9=Questions(
            9,"What country does this flag belongs?",R.drawable.india,"India",
            "Iran","Pakistan","Mexico",1
        )
        quesList.add(ques9)


        val ques10=Questions(
            10,"What country does this flag belongs?",R.drawable.estonia,"Estonia",
            "Belarus","Lithuania","Latvia",1
        )
        quesList.add(ques10)


        val ques11=Questions(
            11,"What country does this flag belongs?",R.drawable.jordon,"Palastine",
            "Azerbaijan","Jordon","Israel",3
        )
        quesList.add(ques11)


        val ques12=Questions(
            12,"What country does this flag belongs?",R.drawable.kazakistan,"Norway",
            "Kazakstan","Armenia","Uzbekistan",2
        )
        quesList.add(ques12)

        return quesList


    }
}