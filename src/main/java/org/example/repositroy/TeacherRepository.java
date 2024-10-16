package org.example.repositroy;

import org.example.model.Student;
import org.example.repositroy.impl.TeacherRepositroyImpl;
import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepository implements TeacherRepositroyImpl {

    private Statement database(){
        Statement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/smartstart1";
            String userName = "root";
            String password = "ss04";
            Connection con = DriverManager.getConnection(url,userName,password);
            statement = con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return statement;

    }
    @Override
    public void insertSingleStudent(Student student) {
        try{
            Statement statement = database();
            statement.executeUpdate("insert into student value ('"+student.getRollNo()+"','"+student.getName()+"','"+student.getEmail()+"','"+student.getPer()+"')");
        }
        catch (Exception e){

        }

    }
    @Override
    public Student selectSingleStudent(int rollNo){
        Student student = new Student();
        try{
            Statement st = database();
            ResultSet rs = st.executeQuery("select * from student where rollNo = '"+rollNo+"'");
            while (rs.next()){
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setPer(rs.getFloat(4));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return student;
    }
    @Override
    public Student updateSingleStudent(Student student){
        try{
            Statement st = database();
            if (student.getRollNo()>0&&student.getName()!=null&&student.getEmail()!=null&&student.getPer()>0) {
                st.executeUpdate("update student set name = '"+student.getName()+"', email='"+student.getEmail()+"', per='"+student.getPer()+"' where rollNo='"+student.getRollNo()+"'");
            }
            else if (student.getRollNo()>0&&student.getName()!=null&&student.getEmail()!=null) {
                st.executeUpdate("update student set name = '"+student.getName()+"', email='"+student.getEmail()+"' where rollNo='"+student.getRollNo()+"'");
            }
            else if (student.getRollNo()>0&&student.getName()!=null&&student.getPer()>0){
                st.executeUpdate("update student set name ='"+student.getName()+"',per ='"+student.getPer()+"' where rollNo= '"+student.getRollNo()+"'");
            }
            else if (student.getRollNo()>0&&student.getEmail()!=null&&student.getPer()>0) {
                st.executeUpdate("update student set email= '"+student.getEmail()+"',per = '"+student.getPer()+"' where rollNo ='"+student.getRollNo()+"'");
            }
            else if (student.getRollNo()>0&&student.getName()!=null) {
                st.executeUpdate("update student set name = '"+student.getName()+"' where rollNo='"+student.getRollNo()+"'");
            }
            else if (student.getRollNo()>0&&student.getEmail()!=null) {
                st.executeUpdate("update student set email = '"+student.getEmail()+"' where rollNo ='"+student.getRollNo()+"'");
            }
            else if (student.getRollNo()>0&&student.getPer()>0) {
                st.executeUpdate("update student set per = '"+student.getPer()+"'");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return selectSingleStudent(student.getRollNo());
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> studentList = new ArrayList<>();

        try {
            Statement st = database();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()){
                Student student = new Student();
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setPer(rs.getFloat(4));
                studentList.add(student);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return studentList;
    }

    @Override
    public Boolean deleteSingleStudent(int rollNo) {
        Boolean result = false;
        try{
            Statement st = database();
            int count = st.executeUpdate("delete from student where rollNo = '"+rollNo+"'");
            if(count!=0){
                result = true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    @Override
    public Boolean deleteAllStudent
            () {
        Boolean result=false;
        try{
            Statement st = database();
            int count= st.executeUpdate("delete from student");
            if(count>0){
                result = true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}