package com.plcoding.quizapp

object Constants {


    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getquestions() : ArrayList<Questions>{
        val questionList = ArrayList<Questions>()

        val que1 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentine","Australia","Pakistan","NewZeland",
            1


        )
        questionList.add(que1)

        val que2 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Australia","Armenia","Pakistan","NewZeland",
            1


        )
        questionList.add(que2)

        val que3 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentine","India","Belgium","NewZeland",
            3


        )
        questionList.add(que3)

        val que4 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentine","Brazil","Pakistan","NewZeland",
            2


        )
        questionList.add(que4)

        val que5 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Argentine","China","Pakistan","Denmark",
            4


        )
        questionList.add(que5)

        val que6 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Russia","Fiji","India","NewZeland",
            2


        )
        questionList.add(que6)

        val que7 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany","France","Isreal","NewZeland",
            1


        )
        questionList.add(que7)

        val que8 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Argentine","India","Nepal","NewZeland",
            2


        )
        questionList.add(que8)

        val que9 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentine","Australia","Pakistan","Kuwait",
            4


        )
        questionList.add(que9)

        val que10 = Questions(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentine","Australia","Pakistan","NewZeland",
            4


        )
        questionList.add(que10)



        return questionList

    }
}