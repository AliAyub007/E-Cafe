package main.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    static String[] timeBreak;
    static String time;

    public static void main(String[] args) {
        if(isOpen()){
            Menu menu = new Menu();
            menu.getMenu();
            menu.Choice();
            menu.orderType();
            menu.getBill();
            menu.Address();

        } else System.out.println("Cafe is closed right now. Visit between 11:00 am and 10:00 pm");

    }

    private static String getTime(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static boolean isOpen(){
        time = getTime();
        timeBreak = time.split(":");
        if(Integer.parseInt(timeBreak[0]) >= 11 && Integer.parseInt(timeBreak[0]) < 22){
            return true;
        } else return false;
    }

}
