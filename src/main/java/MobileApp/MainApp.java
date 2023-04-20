package MobileApp;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
   static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        boolean status=true;

        while(status) {
            System.out.println("Select Mode ");
            System.out.println("1.Add New Mobile");
            System.out.println("2.Search Mobile");
            System.out.println("3.Delete Mobile");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addMobileInfo();
                    break;

                    case 2:
                    searchMobile();
                    break;

                case 3:
                    deleteMobile();
                    break;
                default:
                    status=false;
                    break;
            }

        }

    }

    private static void addMobileInfo() {
        System.out.println("Enter the Model No");
        int id=sc.nextInt();
        System.out.println("Enter the Model Name");
        String mname=sc.next();
        System.out.println("Enter the Mobile Company ");
        String cname=sc.next();
        System.out.println("Enter the RAM");
        int ram=sc.nextInt();
        System.out.println("Enter the Camera Size");
        int cameraMp=sc.nextInt();
        System.out.println("Enter the Mobile Price ");
        double mprice=sc.nextDouble();

        MobileDTO md1=new MobileDTO();
        md1.setMobileNo(id);
        md1.setModelName(mname);
        md1.setCompany(cname);
        md1.setRam(ram);
        md1.setCamera(cameraMp);
        md1.setPrice(mprice);
        MobileDAO m1=new MobileDAO();
        int count=m1.insertMobileRecord(md1);
        System.out.println(count+"insert record successfully");

    }
    private static void searchMobile() {

        Boolean status=true;

            System.out.println("select Mode ");
            System.out.println("1.Mobile By Company");
            System.out.println("2.Mobile By Price");
            System.out.println("3.Mobile By Ram");
            System.out.println("4.Mobile By Camera");
            int choice= sc.nextInt();
            switch (choice)
            {
                case 1:
                    company();
                    break;
                case 2:
                    price();
                    break;
                case 3:
                    ram();
                    break;
                case 4:
                    camera();
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }

        }



    private static void camera() {
        System.out.println("Enter the star  camera");
        int starCam1= sc.nextInt();
        System.out.println("Enter the end  camera");
        int endCam2=sc.nextInt();
        MobileDAO m1=new MobileDAO();
        ArrayList<MobileDTO> data1= m1.desplayDetailsByCameraBet(starCam1,endCam2);
        for (MobileDTO data:data1
        ) {
            System.out.println(data);
        }



    }

    private static void ram() {
        System.out.println("Enter the Ram");
        int ram= sc.nextInt();
        MobileDAO m=new MobileDAO();
        ArrayList<MobileDTO> data1=m.displayDetailsByRam(ram);
        for ( MobileDTO data:data1
             ) {
            System.out.println(data);
        }

    }

    private static void price() {
        System.out.println("Enter the Start Price");
        double price1= sc.nextDouble();
        System.out.println("Enter the End Price");
        double price2=sc.nextDouble();
        MobileDAO m1=new MobileDAO();
       ArrayList<MobileDTO> data1= m1.desplayDetailsByPrice(price1,price2);
        for (MobileDTO data:data1
             ) {
            System.out.println(data);
        }

    }

    private static void company() {
        System.out.println("Enter the Company name");
        String name= sc.next();
        MobileDTO m=new MobileDTO();
        m.setCompany(name);
        MobileDAO m1=new MobileDAO();
        ArrayList<MobileDTO> data=m1.diasplayModelName(m);
        System.out.println("Model Name");
        for (MobileDTO data1:data
        ) {
            System.out.println(data1.getModelName());
        }
    }

    private static void deleteMobile() {
        System.out.println("Enter Model No");
        int id=sc.nextInt();
        MobileDTO m=new MobileDTO();
        m.setMobileNo(id);
        MobileDAO m1=new MobileDAO();
        int count= m1.deleteMobileRecord(m);
        System.out.println(count+"delete Record Successfully");

    }

}