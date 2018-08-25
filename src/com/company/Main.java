package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class Main extends JFrame implements ActionListener {

    private QuestionGenerator questionGenerator;

    public QuestionGenerator getQuestionGenerator() {
        return questionGenerator;
    }

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }


    private int currentQuestion;

    private List<Question>questionList = new ArrayList<Question>();

    public Main(){
        setQuestionGenerator(new SimpleQuestionGenerator());
        questionList = questionGenerator.generateQuestion();
        setSize(500,500);
        setTitle("Milionaires");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JButton yesButton = new JButton("Tak");
        JButton noButton = new JButton("Nie");
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        label = new JLabel(questionList.get(currentQuestion).getContent(), 0);
        setLayout(new GridLayout(3,1));
        add(label);
        add(yesButton);
        add(noButton);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });



    }

    private JLabel label;

    private  int numberOfPoints;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        System.out.println(button.getText());


        if (button.getText().equals("Nie")
                && questionList.get(currentQuestion).isCorrect()) {
            numberOfPoints++;
        }

        if (button.getText().equals("Tak")
                && questionList.get(currentQuestion).isCorrect()) {
            numberOfPoints++;
        }

        currentQuestion++;

        if (currentQuestion > questionList.size() - 1) {
            JOptionPane.showMessageDialog(this, "Zdobyłeś " + numberOfPoints + " punktów");
        }else { label.setText(questionList.get(currentQuestion).getContent());
        }

        label.setText(questionList.get(currentQuestion).getContent());
        System.out.println("Kliknięto mnie");
    }
}
