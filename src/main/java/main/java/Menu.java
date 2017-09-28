package main.java;

import java.util.Scanner;

public class Menu {
    int[] choice = new int[100];
    int count=0;
    static int price = 0;
    int[] time = new int[100];
    static boolean orderType; //1 for delivery //0 for pick
    String address;
    int pickupTime;
    Scanner input = new Scanner(System.in);

    Menu(){
        count =0;
        price =0;
    }

    public void getMenu() {
        System.out.println("---------------------------WELCOME TO E-CAFE----------------------------");
        System.out.println("Select items from the menu: ");
        System.out.println("\n----------------APPETIZERS------------------");
        System.out.println("1- Buffalo Chicken Dips       -/200");
        System.out.println("2- Chicken Wings              -/250");
        System.out.println("3- Meat Balls                 -/300");
        System.out.println("4- Pepper Poppers             -/350");
        System.out.println("\n----------------SOUPS------------------");
        System.out.println("5- Chicken Soup               -/200");
        System.out.println("6- Corn Soup                  -/150");
        System.out.println("\n----------------MAIN COURSE------------------");
        System.out.println("7- Chicken karahi             -/450");
        System.out.println("8- Chicken Handi              -/500");
        System.out.println("9- Chicken Achari             -/450");
        System.out.println("10- Mutton Handi              -/600");
        System.out.println("11- BBQ                       -/500");
        System.out.println("12- Mutton Karahi             -/600");
        System.out.println("\n----------------SIDE ORDERS------------------");
        System.out.println("13- Pasta                     -/300");
        System.out.println("14- Fries                     -/100");
        System.out.println("15- Drink                     -/70");
    }

    public void Choice(){
        System.out.println("Enter your order by entering associated number and type -1 to exit\n");

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

    public void getBill(){
        System.out.println("Total Bill is: " + price);
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
            pickupTime = input.nextInt();
            System.out.println("Thank you for your order.Pick your order at " + pickupTime+ ":00");
        }
    }
}

