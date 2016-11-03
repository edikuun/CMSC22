/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author localuser
 */
package studentdb2;

import java.io.*;
import java.util.*;

public class Menu {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        List<Student> students = null;
        
        BufferedReader br = null;

        try {
            fis = new FileInputStream("C:/Documents and Settings/localuser/My Documents/NetBeansProjects/Database/src/studentdb2/database.txt");
            ois = new ObjectInputStream(fis);

            students = (List<Student>) ois.readObject();
        } catch (IOException e) {
            // standard file handling exception
            e.printStackTrace();
        } catch (ClassNotFoundException ce) {
            // this might be thrown by ois.readObject()
            ce.printStackTrace();
        } finally {
            // make sure to close the files!
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\t\t\tMENU");
        System.out.println("1. Add a student\n2. Remove a student\n3. View data\n4. Save data\n5. Exit");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        s.nextLine();

        boolean flag = true;

        do {
            if (choice == 1) {
                System.out.print("Enter Student Number: ");
                String sn = s.nextLine();

                for (Student toCheck : students) {
                    if ((toCheck.getStudentNumber()).equals(sn)) {
                        System.out.println("A Student with the same student number already exist");
                        flag = false;
                    }
                }
                if (!flag) {
                    break;
                }
                System.out.print("Enter First Name: ");
                String fn = s.nextLine();
                System.out.print("Enter Middle Initial: ");
                String mi = s.nextLine();
                System.out.print("Enter Last Name: ");
                String ln = s.nextLine();
                System.out.print("Enter favorite course: ");
                String faveCourse = s.nextLine();
                System.out.println("Enter course Description: ");
                String courseDes = s.nextLine();
                System.out.println("Enter crush name: ");
                String cName = s.nextLine();
                System.out.print("Enter year level: ");
                int yl = s.nextInt();

                Student newStudent = new Student(sn, fn, mi.charAt(0), ln, new Course(faveCourse, courseDes), cName, yl);
                students.add(newStudent);
                System.out.println("Done");
            } else if (choice == 2) {
                System.out.println("Enter Student Number of the Student you want to remove: ");
                String snRemoved = s.next();
                for (Student toBeRemoved : students) {
                    if (toBeRemoved.getStudentNumber().equals(snRemoved)) {
                        students.remove(toBeRemoved);
                        break;
                    }
                }
                System.out.println("Done");
            } else if (choice == 3) {
                boolean flagger = true;
                System.out.println("Enter Student Number of the Student you want to view: ");
                String snToView = s.next();
                for (Student toView : students) {
                    if ((toView.getStudentNumber()).equals(snToView)) {
                        System.out.println(String.format("Student Number: %s\nFirst Name: %s\nMiddle Initial: %c\nLast Name: %s\ncourse: %s\nYear Level: %d\n", toView.getStudentNumber(), toView.getFirstName(), toView.getMiddleInitial(), toView.getLastName(), toView.getCourse(), toView.getYearLevel()));
                        flagger = false;
                    }
                }
                if (flagger) {
                    System.out.println("Student is not enrolled or has been removed");
                }
                System.out.println("Done");
            } else if (choice == 4) {

                try {
                    fos = new FileOutputStream("C:/Documents and Settings/localuser/My Documents/NetBeansProjects/Database/src/studentdb2/database.txt");
                    oos = new ObjectOutputStream(fos);

                    oos.writeObject(students);
                    System.out.println("Updated");

                    oos.close();
                } catch (IOException e) {
                    // standard file handling exception
                    e.printStackTrace();
                } // this might be thrown by ois.readObject()
                finally {

                    // make sure to close the files!
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            System.out.println("Would you like to choose again?\n1. Add a student\n2. Remove a student\n3. View data\n4. Save data\n5. Exit");
            choice = s.nextInt();
        } while (choice != 5);

    }
}
