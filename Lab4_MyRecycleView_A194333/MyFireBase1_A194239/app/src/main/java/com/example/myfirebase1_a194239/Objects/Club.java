package com.example.myfirebase1_a194239.Objects;

public class Club {
    private String clubID;
    private String clubCode;
    private String clubName;

    public Club() {
    }

    public Club(String clubID, String clubCode, String clubName) {
        this.clubID = clubID;
        this.clubCode = clubCode;
        this.clubName = clubName;


    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public String getClubCode() {
        return clubCode;
    }

    public void setClubCode(String clubCode) {
        this.clubCode = clubCode;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
