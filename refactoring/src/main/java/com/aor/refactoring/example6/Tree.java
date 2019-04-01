package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    public Date plantedAt;
    public String locationLatitude;
    public String locationLongitude;
    public String locationName;
    private List<Date> appraisalDates;

    public Tree(Date plantedAt, String locationLatitude, String locationLongitude, String locationName){
        this.plantedAt = plantedAt;
        this.setLocation(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new ArrayList<>();
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName){
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.locationName = locationName;
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + this.locationLatitude + "," + this.locationLongitude + " (" + this.locationName + ")";
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue(){
        Date today = new Date();
        Date latestAppraisalDate = getLatestAppraisalDate(today);

        changeAppraisalDates(latestAppraisalDate);

        Calendar calendar = calculateNextApparaisalDate(latestAppraisalDate);

        return calendar.getTime().before(today);
    }

    private Calendar calculateNextApparaisalDate(Date latestAppraisalDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        int dayOfWeek = Calendar.DAY_OF_WEEK;
        int dayOfMonth = Calendar.DAY_OF_MONTH;

        if (calendar.get(dayOfWeek) == Calendar.SATURDAY)
            calendar.add(dayOfMonth, 1);
        else if (calendar.get(dayOfWeek) == Calendar.SUNDAY)
            calendar.add(dayOfMonth, 2);

        return calendar;
    }

    private void changeAppraisalDates(Date latestAppraisalDate) {
        for(Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }
    }

    private Date getLatestAppraisalDate(Date today) {

        if (this.appraisalDates.size() > 0) {
            return this.appraisalDates.get(0);
        }

        return today;
    }
}
