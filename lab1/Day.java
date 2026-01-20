import java.util.*;
class Day{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter day of month: ");
        int day=in.nextInt();
        String dayName;
        int d=day%7;
        if(day>31){
            System.out.print("Invalid day");
            return;
        }
        switch (d) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }
        System.out.println("Day " + day + " is " + dayName); 
    }
    }
