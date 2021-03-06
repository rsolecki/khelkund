package com.appacitive.khelkund.model;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by sathley on 3/31/2015.
 */
@RealmClass
public class Match extends RealmObject {

    public Match()
    {}

    public Match(JSONObject jsonObject, int matchNumber)
    {
        if(jsonObject == null)
            return;

        this.MatchNumber = matchNumber;
        this.AwayTeamName = jsonObject.optString("AwayTeamName");
        this.HomeTeamName = jsonObject.optString("HomeTeamName");
        this.AwayTeamShortName = jsonObject.optString("AwayTeamShortName");
        this.HomeTeamShortName = jsonObject.optString("HomeTeamShortName");
        this.Id = jsonObject.optString("Id");
        this.MatchStatus = jsonObject.optInt("MatchStatus");
        this.Venue = jsonObject.optString("Venue");
        this.isOpen = jsonObject.optBoolean("IsOpenForPlay");
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'");
        try {
            this.StartDate = df1.parse(jsonObject.optString("StartDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @PrimaryKey
    private String Id;

    private int MatchNumber;
    private String AwayTeamName;
    private String HomeTeamName;
    private String AwayTeamShortName;
    private String HomeTeamShortName;
    private Date StartDate;
    private int MatchStatus;
    private String Venue;
    private boolean isOpen;

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        AwayTeamName = awayTeamName;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        HomeTeamName = homeTeamName;
    }

    public String getAwayTeamShortName() {
        return AwayTeamShortName;
    }

    public void setAwayTeamShortName(String awayTeamShortName) {
        AwayTeamShortName = awayTeamShortName;
    }

    public String getHomeTeamShortName() {
        return HomeTeamShortName;
    }

    public void setHomeTeamShortName(String homeTeamShortName) {
        HomeTeamShortName = homeTeamShortName;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public int getMatchStatus() {
        return MatchStatus;
    }

    public void setMatchStatus(int matchStatus) {
        MatchStatus = matchStatus;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public int getMatchNumber() {
        return MatchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        MatchNumber = matchNumber;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
