package com.example.v.plants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ficus {
    private String name;

    private Date birthday;
    private Date dateLastWatering;
    private Date dateNextWatering;
    Ficus(String n, Date bday, Date Last){
        Watering();
        name=n;
        birthday=bday;
        dateLastWatering=Last;
    }
    public void Watering(){

        Date t=new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(t);
        dateLastWatering=t;
        c.add(Calendar.DATE,3);
        dateNextWatering=c.getTime();
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getDateLastWatering() {
        SimpleDateFormat form=new SimpleDateFormat("dd.MM.yyyy");
        return form.format(dateLastWatering);
    }

    public String getDateNextWatering() {
        SimpleDateFormat form=new SimpleDateFormat("dd.MM.yyyy");
        return form.format(dateNextWatering);
    }
}
