package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            int n;
            boolean moreThan;
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            String[] s1 = s.split(" ");


        int operation_1=0;
        int operation_2=0;
       switch (s1[0]){
           case "-a":
               operation_1=0;
               break;
           case "-b" :
               operation_1=1;
               break;
           case "-s" :
               operation_1=3;
               break;
           case "-i" :
               operation_1=4;
               break;
            default:
                System.out.println("Ты по-моему перепутал. Нет такой настройки");
        };
        if (operation_1==1 | operation_1==2){
            switch (s1[1]){
            case "-s" :
               operation_2=1;
               break;
            case "-i" :
                operation_2=2;break;

            default :
                operation_2=0;break;

            };
        }
        if (operation_1==4  ){ //checking kind of sort
            try {
                SortInt(s1[1],s1[2],4 );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 2; i < s1.length; i++) {
                try {
                    SortInt(s1[i],"result.txt", 4);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Файла нет");
                }
            }

        }
        if (operation_1==3  ){
            try {
                SortStr(s1[1],s1[2],3 );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 2; i < s1.length; i++) {
                try {
                    SortStr(s1[i],"result.txt", 3);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Файла нет");
                }
            }

        }
        if (operation_1==0 && operation_2==2){
            try {
                SortInt(s1[1],s1[2], 0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 3; i < s1.length; i++) {
                try {
                    SortInt(s1[i],"result.txt",0 );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Файла нет");
                }
            }
        }
        if (operation_1==1 && operation_2==2){
            try {
                SortInt(s1[1],s1[2], 1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Файла нет");
            }
            for (int i = 3; i < s1.length; i++) {
                try {
                    SortInt(s1[i],"result.txt",1 );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Файла нет");
                }
            }
        }
        if (operation_1==0 && operation_2==1){
            try {
                SortStr(s1[1],s1[2], 0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 3; i < s1.length; i++) {
                try {
                    SortStr(s1[i],"result.txt",0 );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Файла нет");
                }
            }
        }
        if (operation_1==1 && operation_2==1){
            try {
                SortStr(s1[1],s1[2], 1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 3; i < s1.length; i++) {
                try {
                    SortStr(s1[i],"result.txt",1 );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println("Файла нет");
                }
            }
        }




    }
    public static void SortInt(String file1, String file2, int sort) throws FileNotFoundException { //merge sort for int
        File file11 = new File(file1);
        File file22 = new File(file2);
        Scanner scanner1 = new Scanner(file11);
        Scanner scanner2 = new Scanner(file22);
        int lines2 = 0;
        int lines1 = 0;
        while (scanner1.hasNextLine()) {
            lines1++;
        }
        while (scanner2.hasNextLine()) {
            lines2++;
        }
        Scanner scanner11 = new Scanner(file11);
        Scanner scanner12 = new Scanner(file22);

        int[] a3 = new int[lines1 + lines2];

        int i=0, j=0;
        for (int k=0; k<a3.length; k++) {

            if (i > lines1-1) {
                int a = scanner12.nextInt();
                a3[k] = a;
                j++;
            }
            else if (j > lines2-1) {
                int a = scanner11.nextInt();
                a3[k] = a;
                i++;
            }
            else if (scanner11.nextInt() < scanner12.nextInt()) {
                int a = scanner11.nextInt();
                a3[k] = a;
                i++;
            }
            else {
                int b = scanner12.nextInt();
                a3[k] = b;
                j++;
            }
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("result.txt", "UTF-8");
            if (sort==4 || sort==0) {
            for (int k=0; k<a3.length; k++){
            writer.println(a3[k]);}
            writer.close();
            }
            if (sort==1) {
                for (int k=a3.length-1; k>-1; k--){
                    writer.println(a3[k]);}
                    writer.close();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Запись сломалась");
        }

    }
    public static void SortStr(String file1, String file2, int sort) throws FileNotFoundException { //merge sort for string
        File file11 = new File(file1);
        File file22 = new File(file2);
        Scanner scanner1 = new Scanner(file11);
        Scanner scanner2 = new Scanner(file22);
        int lines2 = 0;
        int lines1 = 0;
        while (scanner1.hasNextLine()) {
            lines1++;
        }
        while (scanner2.hasNextLine()) {
            lines2++;
        }
        Scanner scanner11 = new Scanner(file11);
        Scanner scanner12 = new Scanner(file22);

        int[] a3 = new int[lines1 + lines2];

        int i=0, j=0;
        for (int k=0; k<a3.length; k++) {

            if (i > lines1-1) {
                int a = scanner12.nextInt();
                a3[k] = a;
                j++;
            }
            else if (j > lines2-1) {
                int a = scanner11.nextInt();
                a3[k] = a;
                i++;
            }
            else if (scanner11.nextLine().compareTo(scanner12.nextLine())<0) {
                int a = scanner11.nextInt();
                a3[k] = a;
                i++;
            }
            else {
                int b = scanner12.nextInt();
                a3[k] = b;
                j++;
            }
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("result.txt", "UTF-8");
            if (sort==3 || sort==0) {
                for (int k=0; k<a3.length; k++){
                    writer.println(a3[k]);}
                writer.close();
            }
            if (sort==1) {
                for (int k=a3.length-1; k>-1; k--){
                    writer.println(a3[k]);}
                writer.close();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Запись сломалась");
        }

    }
}


