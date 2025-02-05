package com.example.gerryeka.aplikasiscoreboard1.Model;

/**
 * Created by gerry eka on 12/11/2019.
 */

public class Model_admintourmatch {

    String matchid, name1, name2, set_score1, set_score2, tournament_id, round;

    public Model_admintourmatch() {
    }

    public Model_admintourmatch(String matchid, String name1, String name2, String set_score1, String set_score2, String tournament_id, String round) {
        this.matchid = matchid;
        this.name1 = name1;
        this.name2 = name2;
        this.set_score1 = set_score1;
        this.set_score2 = set_score2;
        this.tournament_id = tournament_id;
        this.round = round;
    }

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getSet_score1() {
        return set_score1;
    }

    public void setSet_score1(String set_score1) {
        this.set_score1 = set_score1;
    }

    public String getSet_score2() {
        return set_score2;
    }

    public void setSet_score2(String set_score2) {
        this.set_score2 = set_score2;
    }

    public String getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(String tournament_id) {
        this.tournament_id = tournament_id;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
