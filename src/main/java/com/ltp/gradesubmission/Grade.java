package com.ltp.gradesubmission;

import java.util.UUID;

public class Grade {
    /* enum Score{
        A_PLUS("A+"), A("A"), A_MINUS("A-"),
        B_PLUS("B+"), B("B"), B_MINUS("B-"),
        C_PLUS("C+"), C("C"), D("D"),
        F("F");

        public final String label;

        private Score(String label) {
            this.label = label;
        }
    }
    */

    private String name;
    private String subject;
    private String score;   
    private String id;

    


    public Grade(){
        this.id = UUID.randomUUID().toString();
    }

     public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

   