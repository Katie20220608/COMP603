package Project2;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author Leo JIA
 * @Student ID: 20115737
 */
public class QnaAdminMenuView extends javax.swing.JFrame {

    public Model model;

    //Constructor for Qna Admin Menu
    public QnaAdminMenuView(Model model) {
        initComponents();
        this.model = model;
        this.setTitle("ENSE600/COMP603 Q&A APP Admin Menu");
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        setup();
    }

    //Setup GUI
    private void setup() {
        loadQuestions("All");

        topicFilter.add("All");
        topicFilter.add("General");
        topicFilter.add("Assignment 1");
        topicFilter.add("Assignment 2");
        topicFilter.add("Labs");
        topicFilter.add("Lectures");
        topicFilter.add("Other");

        topicSelector.add("General");
        topicSelector.add("Assignment 1");
        topicSelector.add("Assignment 2");
        topicSelector.add("Labs");
        topicSelector.add("Lectures");
        topicSelector.add("Other");
    }

    //Print questions onto GUI, sorted by topic
    private void loadQuestions(String topic) {
        questionList.clear();
        if (topic.contentEquals("All")) {
            for (Question q : model.questionData.questions.values()) {
                questionList.add(q.toString());
            }
        } else {
            for (Question q : model.questionData.questions.values()) {
                if (q.getTopic().contentEquals(topic)) {
                    questionList.add(q.toString());
                }
            }
        }

    }

    //Print unanswered questions onto GUI, sorted by topic
    private void loadUnansweredQuestions(String topic) {
        questionList.clear();
        if (topic.contentEquals("All")) {
            for (Question q : model.questionData.questions.values()) {
                if (q.answers.isEmpty()) {
                    questionList.add(q.toString());
                }
            }
        } else {
            for (Question q : model.questionData.questions.values()) {
                if (q.answers.isEmpty() && q.getTopic().contentEquals(topic)) {
                    questionList.add(q.toString());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        unansweredQuestionsFilter = new javax.swing.JCheckBox();
        askQuestion = new java.awt.Button();
        questionList = new java.awt.List();
        questionListLabel = new javax.swing.JLabel();
        filterLabel = new javax.swing.JLabel();
        topicFilter = new java.awt.Choice();
        topicSelector = new java.awt.Choice();
        filterButton = new java.awt.Button();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        profile = new javax.swing.JMenu();
        logOut = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setText("ENSE600/COMP603 Q&A APP");

        questionField.setText("Ask your question here");
        questionField.setMaximumSize(new java.awt.Dimension(135, 24));
        questionField.setMinimumSize(new java.awt.Dimension(135, 24));
        questionField.setPreferredSize(new java.awt.Dimension(135, 24));
        questionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionFieldMouseClicked(evt);
            }
        });

        unansweredQuestionsFilter.setText(" Unanswered");

        askQuestion.setActionCommand("askQuestion");
        askQuestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        askQuestion.setLabel("Ask");
        askQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                askQuestionActionPerformed(evt);
            }
        });

        questionList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        questionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionListMouseClicked(evt);
            }
        });

        questionListLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        questionListLabel.setText("Questions");

        filterLabel.setText("Filter:");

        filterButton.setLabel("Filter");
        filterButton.setMaximumSize(new java.awt.Dimension(57, 22));
        filterButton.setMinimumSize(new java.awt.Dimension(57, 22));
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        mainMenu.setText("Main Menu");
        mainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(mainMenu);

        profile.setText("Profile");
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        jMenuBar1.add(profile);

        logOut.setText("Logout");
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logOut);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topicSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(askQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(questionListLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filterLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(topicFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(unansweredQuestionsFilter)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2))
                        .addComponent(questionList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(titleLabel)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(askQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(topicSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(topicFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(filterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(unansweredQuestionsFilter)
                                    .addComponent(questionListLabel))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionList, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Main menu button clicked
    private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuMouseClicked
        //Refresh page
        questionField.setText("Ask your question here");
    }//GEN-LAST:event_mainMenuMouseClicked

    //Question field clicked
    private void questionFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionFieldMouseClicked
        //Clear default text
        if (questionField.getText().contains("Ask your question here")) {
            questionField.setText("");
        }
    }//GEN-LAST:event_questionFieldMouseClicked

    //Ask question button pressed
    private void askQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_askQuestionActionPerformed
        //Check for invalid questions
        if (questionField.getText().isEmpty() || questionField.getText().contains("Ask your question here")) {
            String msg = "Invalid question.";
            JOptionPane.showMessageDialog(null, msg, "Error", HEIGHT);
        } //Check for lengthy question
        else if (questionField.getText().length() > 119) {
            String msg = "Your question exceeds maximum allowed characters (120)";
            JOptionPane.showMessageDialog(null, msg, "Error", HEIGHT);
        } else { //Create new question, update QuestionData and write to DB
            String question = questionField.getText();
            String topic = (String) topicSelector.getSelectedItem();
            model.newQuestion(question, topic);
            loadQuestions((String) topicFilter.getSelectedItem());
            questionField.setText("");
        }
    }//GEN-LAST:event_askQuestionActionPerformed

    //If question pressed, load question view
    private void questionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionListMouseClicked
        String questionText = questionList.getSelectedItem();
        Question selectedQuestion = null;
        for (Question q : model.questionData.questions.values()) {
            if (q.toString().equals(questionText)) {
                selectedQuestion = q;
            }
        }
        if (selectedQuestion != null) {
            this.dispose();
            QnaQuestionAdminView qv = new QnaQuestionAdminView(this.model, selectedQuestion);
        }
    }//GEN-LAST:event_questionListMouseClicked

    //Filter button pressed
    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        if (unansweredQuestionsFilter.isSelected()) {
            loadUnansweredQuestions((String) topicFilter.getSelectedItem());
        } else {
            loadQuestions((String) topicFilter.getSelectedItem());
        }
    }//GEN-LAST:event_filterButtonActionPerformed

    //Log out button clicked
    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        String msg = "Are you sure you want to log out? ";
        int result = JOptionPane.showConfirmDialog(null, msg, "Confirm Log Out", HEIGHT);
        if (result == JOptionPane.YES_OPTION) {
            this.dispose();
            new App();
        }
    }//GEN-LAST:event_logOutMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        this.dispose();
        new QnaProfileView(model);
    }//GEN-LAST:event_profileMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button askQuestion;
    private java.awt.Button filterButton;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOut;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenu profile;
    private javax.swing.JTextField questionField;
    private java.awt.List questionList;
    private javax.swing.JLabel questionListLabel;
    private javax.swing.JLabel titleLabel;
    private java.awt.Choice topicFilter;
    private java.awt.Choice topicSelector;
    private javax.swing.JCheckBox unansweredQuestionsFilter;
    // End of variables declaration//GEN-END:variables
}
