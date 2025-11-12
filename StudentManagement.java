import java.util.*;
class Student{
    String name;
    String regNo;
    String email;
    String phone;
    Student(String name, String regNo, String email, String phone){
        this.name = name;
        this.regNo = regNo;
        this.email = email;
        this.phone = phone;
    }   
    public String toString(){
        return "Name: "+name+", RegNo: "+regNo+", Email: "+email+", Phone: "+phone;
    }
}

public class StudentManagement{
    
        List<Student> students = new ArrayList<>();
        public void addStudent(Student student){
            students.add(student);
        }

        public Student searchStudent(String regNo){
            for(Student s: students){
                if(s.regNo.equals(regNo)){
                    return s;
                }
            }
            return null;
        }
        public void removeStudent(String regNo){
            students.removeIf(s->s.regNo.equals(regNo));
        }
        public void displayAll(){
            for(Student s: students){
                System.out.println(s);
            }
        }
    public static void main(String[] args){
        StudentManagement sm =new StudentManagement();
        sm.addStudent(new Student("Mathan","001","mathan@gmail.com","9043343357"));
        sm.addStudent(new Student("Kavin","002","kavin@gmial.com","8080808"));
         sm.addStudent(new Student("Kavin","005","jgug@gmial.com","8080808"));
        sm.removeStudent("002");
        System.out.println(sm.searchStudent("001"));
        sm.displayAll();

}}