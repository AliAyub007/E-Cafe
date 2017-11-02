package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    private int[] choice = new int[100];
    private int count=0;
    static int price = 0;
    int[] time = new int[100];
    private static boolean orderType; //1 for delivery //0 for pick
    private String address;
    private Scanner input = new Scanner(System.in);

    Menu(){
        count =0;
        price =0;
    }

    public void getMenu() {
        System.out.println("---------------------------WELCOME TO E-CAFE----------------------------");
        System.out.println("Select items from the menu: ");
        System.out.println("\n----------------APPETIZERS------------------");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost/E-Cafe","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select Number,Name,Price from Appetizers");
            while(rs.next())
                System.out.println(rs.getInt(1) +"- "+ rs.getString(2)+"       -/"+rs.getInt(3));

            System.out.println("\n----------------SOUPS------------------");
            ResultSet rs1=stmt.executeQuery("select Number,Name,Price from Soups");
            while(rs1.next())
                System.out.println(rs1.getInt(1) +"- "+ rs1.getString(2)+"       -/"+rs1.getInt(3));

            System.out.println("\n----------------MAIN COURSE------------------");
            ResultSet rs2=stmt.executeQuery("select Number,Name,Price from MainCourse");
            while(rs2.next())
                System.out.println(rs2.getInt(1) +"- "+ rs2.getString(2)+"       -/"+rs2.getInt(3));

            System.out.println("\n----------------SIDE ORDERS------------------");
            ResultSet rs3=stmt.executeQuery("select Number,Name,Price from SideOrders");
            while(rs3.next())
                System.out.println(rs3.getInt(1) +"- "+ rs3.getString(2)+"       -/"+rs3.getInt(3));

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }


    public void Choice(){
        System.out.println("\nEnter your order by entering associated number and type -1 to exit\n");

        for(;;){
            choice[count] = input.nextInt();

            if(choice[count] > 0 && choice[count] <= 15){
                switch (choice[count]){
                    case 1:
                        buffaloChickenDips buffaloChickenDips = new buffaloChickenDips();
                        price += buffaloChickenDips.price;
                        time[count] = buffaloChickenDips.time;
                        count++;
                        break;
                    case 2:
                        chickenWings chickenWings = new chickenWings();
                        price += chickenWings.price;
                        time[count] = chickenWings.time;
                        count++;
                        break;
                    case 3:
                        meatBalls meatBalls = new meatBalls();
                        price += meatBalls.price;
                        time[count] = meatBalls.time;
                        count++;
                        break;
                    case 4:
                        pepperPoppers pepperPoppers = new pepperPoppers();
                        price += pepperPoppers.price;
                        time[count] = pepperPoppers.time;
                        count++;
                        break;
                    case 5:
                        chickenSoup chickenSoup = new chickenSoup();
                        price += chickenSoup.price;
                        time[count] = chickenSoup.time;
                        count++;
                        break;
                    case 6:
                        cornSoup cornSoup = new cornSoup();
                        price += cornSoup.price;
                        time[count] = cornSoup.time;
                        count++;
                        break;
                    case 7:
                        chickenKarahi chickenKarahi = new chickenKarahi();
                        price += chickenKarahi.price;
                        time[count] = chickenKarahi.time;
                        count++;
                        break;
                    case 8:
                        chickenHandi chickenHandi = new chickenHandi();
                        price += chickenHandi.price;
                        time[count] = chickenHandi.time;
                        count++;
                        break;
                    case 9:
                        chickenAchari chickenAchari = new chickenAchari();
                        price += chickenAchari.price;
                        time[count] = chickenAchari.time;
                        count++;
                        break;
                    case 10:
                        muttonHandi muttonHandi = new muttonHandi();
                        price += muttonHandi.price;
                        time[count] = muttonHandi.time;
                        count++;
                        break;
                    case 11:
                        muttonKarahi muttonKarahi = new muttonKarahi();
                        price += muttonKarahi.price;
                        time[count] = muttonKarahi.time;
                        count++;
                        break;
                    case 12:
                        BBQ bbq = new BBQ();
                        price += bbq.price;
                        time[count] = bbq.time;
                        count++;
                        break;
                    case 13:
                        pasta pasta = new pasta();
                        price += pasta.price;
                        time[count] = pasta.time;
                        count++;
                        break;
                    case 14:
                        fries fries = new fries();
                        price += fries.price;
                        time[count] = fries.time;
                        count++;
                        break;
                    case 15:
                        drink drink = new drink();
                        price += drink.price;
                        time[count] = drink.time;
                        count++;
                        break;
                }
            } else if(choice[count] == -1){
                count--;
                break;
            } else if (choice[count] < 0 && choice[count] > 15){
                System.out.println("Enter Valid Choice");
                count--;
                break;
            }
        }

    }

    public void sendData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost/E-Cafe","root","");
            Statement stmt=con.createStatement();
            boolean rs=stmt.execute("INSERT INTO `Data`(`Address`,`Bill`) VALUES (\""+address+"\","+price+")");

        }catch(Exception e){ System.out.println(e);}
    }

    public void getBill(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost/E-Cafe","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Data");

            while(rs.next())
                System.out.println("Address is: "+rs.getString(1)+"\nTotal Price is: "+rs.getInt(2));

        }catch(Exception e){ System.out.println(e);}
    }

    public void getTime(){

    }

    public void orderType(){
        System.out.println("Select your order type: \n 1- Delivery \n 2- Pickup");
        int type;
        type = input.nextInt();

        if(type == 1){
            orderType = true;
        } else orderType = false;
    }

    public void Address(){
        if(orderType){
            System.out.println("Enter your Address: ");
            address = input.nextLine();
            address = input.nextLine();
            System.out.println("Thank you for your order.Your order will be delivered with in 30 minutes");
        } else {
            System.out.println("Enter your pickup time: ");
            int pickupTime = input.nextInt();
            System.out.println("Thank you for your order.Pick your order at " + pickupTime + ":00");
        }
    }
}

