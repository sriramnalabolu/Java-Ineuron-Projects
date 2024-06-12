package in.ineuron.test;

import in.ineuron.beans.Student;

public class StudentApp {
    public static void main(String[] args) {
        Student s1 = new Student(10, "sachin", "MI", 49);
        System.out.println(s1.hashCode());

        Student s2 = new Student(10, "sachin", "MI", 49);
        System.out.println(s2.hashCode());

        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(s1.equals(s2));
        
        System.out.println("JVM maintained hash code for s1 is: " + System.identityHashCode(s1));
        System.out.println("JVM maintained hash code for s2 is: " + System.identityHashCode(s2));
        System.out.println(s1 == s2);

    }
}

