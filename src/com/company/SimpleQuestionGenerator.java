package com.company;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator{

    @Override
    public List<Question> generateQuestion(){

        List<Question> questions = new ArrayList<Question>();

        questions.add(new Question("Czy Polska leży w Europie?",true));
        questions.add(new Question("Czy Europa leży na świecie?",true));
        questions.add(new Question("Czy robaki jedzą ślimaki?",false));
        questions.add(new Question("Czy chłopaki mają siusiaki?",true));
        questions.add(new Question("Czy 2+2*2=7",true));
        questions.add(new Question("Czy wieża Eiffla jest w Markach",false));
        return questions;
    }



}
