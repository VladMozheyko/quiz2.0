package com.example.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.model.Question;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txt_question;
    private TextView txt_score;
    ArrayList<Question> questions = new ArrayList<>();

    private Random random = new Random();

    int count;                                                     // Счетчик вопросов

    int score;                                                    // Балы
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                    // Подключение разметки в активити
        init();
    }
    private void init(){
        txt_question = findViewById(R.id.txt_question);
        txt_score = findViewById(R.id.txt_score);
        count = 0;
        score = 0;
        // Создаем вопросы
        questions.add(new Question("Валюта в России рубль? ", true));
        questions.add(new Question("Столица Франции Париж? ", true));
        questions.add(new Question("Нил самая длинная река в мире? ", false));
        txt_question.setText(questions.get(count).getStr());
        txt_score.setText("Ваш счет: " + score);
    }


    /**
     * Метод, который вызывается при нажатии на элемент
     * @param view
     */
    public void onClick(View view) {
        int id = view.getId();                                     // Идентификатор элемента, на который нажали

        // TODO Решить индексацию вопроса по остатку от деления
        // TODO Оптимизировать код
        if(id == R.id.btn_true){
            if(questions.get(count).isAnswer()){
                score++;
            }
            else {
                score--;
            }
            txt_score.setText("Ваш счет: " + score);
            count++;
            if(count == questions.size()){
                count = 0;
            }
            txt_question.setText(questions.get(count).getStr());
        }
        else if(id == R.id.btn_false){
            if(!questions.get(count).isAnswer()){
                score++;
            }
            else {
                score--;
            }
            txt_score.setText("Ваш счет: " + score);
            count++;
            if(count == questions.size()){
                count = 0;
            }
            txt_question.setText(questions.get(count).getStr());

        }
        else if (id == R.id.btn_next) {
            count++;
            if(count == questions.size()){
                Toast.makeText(this, "Дошли до конца", Toast.LENGTH_LONG).show();
                count = 0;
            }
            txt_question.setText(questions.get(count).getStr());

        }
        else if (id == R.id.btn_prev) {
            count--;
            if(count == 0){
                Toast.makeText(this, "Дошли до конца", Toast.LENGTH_LONG).show();
                count = questions.size()-1;
            }
            txt_question.setText(questions.get(count).getStr());

        } else if (id == R.id.btn_generate) {
            count = random.nextInt(questions.size());
            txt_question.setText(questions.get(count).getStr());
        }
    }
}