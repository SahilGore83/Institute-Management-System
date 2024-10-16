package org.example.repositroy;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repositroy.impl.MangementRepositroyImpl;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ManagementRepositroy implements MangementRepositroyImpl {

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
    public void insertSingleTeacher(Teacher teacher) {
        try{
            Statement statement = database();
            statement.executeUpdate("insert into teacher value ('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getEmail()+"','"+teacher.getSalary()+"')");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public Teacher selectSingleTeacher(int id){
        Teacher teacher = new Teacher();
        try{
            Statement st = database();
            ResultSet rs = st.executeQuery("select * from teacher where id = '"+id+"'");
            while (rs.next()){
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setEmail(rs.getString(3));
                teacher.setSalary(rs.getInt(4));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return teacher;
    }
    @Override
    public Teacher updateSingleTeacher(Teacher teacher){
        try{
            Statement st = database();
            if (teacher.getId()>0&&teacher.getName()!=null&&teacher.getEmail()!=null&&teacher.getSalary()>0) {
                st.executeUpdate("update teacher set name = '"+teacher.getName()+"', email='"+teacher.getEmail()+"', salary='"+teacher.getSalary()+"' where id='"+teacher.getId()+"'");
            }
            else if (teacher.getId()>0&&teacher.getName()!=null&&teacher.getEmail()!=null) {
                st.executeUpdate("update teacher set name = '"+teacher.getName()+"', email='"+teacher.getEmail()+"' where id ='"+teacher.getId()+"'");
            }
            else if (teacher.getId()>0&&teacher.getName()!=null&&teacher.getSalary()>0){
                st.executeUpdate("update teacher set name ='"+teacher.getName()+"', salary ='"+teacher.getSalary()+"' where id= '"+teacher.getId()+"'");
            }
            else if (teacher.getId()>0&&teacher.getEmail()!=null&&teacher.getSalary()>0) {
                st.executeUpdate("update teacher set email= '"+teacher.getEmail()+"',salary = '"+teacher.getSalary()+"' where id ='"+teacher.getId()+"'");
            }
            else if (teacher.getId()>0&&teacher.getName()!=null) {
                st.executeUpdate("update teacher set name = '"+teacher.getName()+"' where id='"+teacher.getId()+"'");
            }
            else if (teacher.getId()>0&&teacher.getEmail()!=null) {
                st.executeUpdate("update teacher set email = '"+teacher.getEmail()+"' where id ='"+teacher.getId()+"'");
            }
            else if (teacher.getId()>0&&teacher.getSalary()>0) {
                st.executeUpdate("update teacher set per = '"+teacher.getSalary()+"'");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return selectSingleTeacher(teacher.getId());
    }

    @Override
    public List<Teacher> selectAllTeacher() {
        List<Teacher> teacherList = new ArrayList<>();

        try {
            Statement st = database();
            ResultSet rs = st.executeQuery("select * from teacher");
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setEmail(rs.getString(3));
                teacher.setSalary(rs.getInt(4));
                teacherList.add(teacher);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return teacherList;
    }

    @Override
    public Boolean deleteSingleTeacher(int id) {
        Boolean result = false;
        try{
            Statement st = database();
            int count = st.executeUpdate("delete from teacher where id = '"+id+"'");
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
    public Boolean deleteAllTeacher() {
        Boolean result=false;
        try{
            Statement st = database();
            int count= st.executeUpdate("delete from teacher");
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
