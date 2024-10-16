package org.example.repositroy;

import org.example.model.Admin;
import org.example.model.Management;
import org.example.repositroy.impl.AdminRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminRepositroy implements AdminRepositoryImpl {
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
        catch (Exception e){
            System.out.println(e);
        }
        return statement;
    }


    @Override
    public void insertSingleManagement(Management management) {
        try{
            Statement statement = database();
            statement.executeUpdate("insert into management value('"+management.getId()+"','"+management.getName()+"','"+management.getEmail()+"','"+management.getSalary()+"')");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Management selectSingleManagement(int id) {
        Management management = new Management();
        try {
            Statement st = database();
            ResultSet rs = st.executeQuery("select * from management where id = '"+id+"'");
            while(rs.next()){
                management.setId(rs.getInt(1));
                management.setName(rs.getString(2));
                management.setEmail(rs.getString(3));
                management.setSalary(rs.getInt(4));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return management;
    }

    @Override
    public Management updateSingleManagement(Management management) {
        try {
            Statement st = database();
            if (management.getId()>0&&management.getName()!=null&&management.getEmail()!=null&&management.getSalary()>0) {
                st.executeUpdate("update management set name = '"+management.getName()+"', email='"+management.getEmail()+"', salary='"+management.getSalary()+"' where id='"+management.getId()+"'");
            }
            else if (management.getId()>0&&management.getName()!=null&&management.getEmail()!=null) {
                st.executeUpdate("update management set name = '"+management.getName()+"', email='"+management.getEmail()+"' where id ='"+management.getId()+"'");
            }
            else if (management.getId()>0&&management.getName()!=null&&management.getSalary()>0){
                st.executeUpdate("update management set name ='"+management.getName()+"', salary ='"+management.getSalary()+"' where id= '"+management.getId()+"'");
            }
            else if (management.getId()>0&&management.getEmail()!=null&&management.getSalary()>0) {
                st.executeUpdate("update management set email= '"+management.getEmail()+"',salary = '"+management.getSalary()+"' where id ='"+management.getId()+"'");
            }
            else if (management.getId()>0&&management.getName()!=null) {
                st.executeUpdate("update management set name = '"+management.getName()+"' where id='"+management.getId()+"'");
            }
            else if (management.getId()>0&&management.getEmail()!=null) {
                st.executeUpdate("update management set email = '"+management.getEmail()+"' where id ='"+management.getId()+"'");
            }
            else if (management.getId()>0&&management.getSalary()>0) {
                st.executeUpdate("update management set per = '"+management.getSalary()+"'");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return selectSingleManagement(management.getId());
    }

    @Override
    public List<Management> selectAllManagement() {
        List<Management> managementList = new ArrayList<>();
        try {
            Statement st = database();
            ResultSet rs = st.executeQuery("select * from management");
            while (rs.next()){
                Management management = new Management();
                management.setId(rs.getInt(1));
                management.setName(rs.getString(2));
                management.setEmail(rs.getString(3));
                management.setSalary(rs.getInt(4));
                managementList.add(management);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return managementList;
    }

    @Override
    public Boolean deleteSingleManagement(int id) {
        Boolean result = false;
        try{
        Statement st = database();
        int count = st.executeUpdate("delete from management where id = '"+id+"'");
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
    public Boolean deleteAllManagement() {
        Boolean result=false;
        try{
            Statement st = database();
            int count= st.executeUpdate("delete from management");
            if(count>0){
                result = true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }


    @Override
    public void insertSingleAdmin(Admin admin) {
        try{
            Statement statement = database();
            statement.executeUpdate("insert into admin value('"+admin.getId()+"','"+admin.getName()+"','"+admin.getEmail()+"','"+admin.getSalary()+"')");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Admin selectSingleAdmin(int id) {
        Admin admin = new Admin();
        try {
            Statement st = database();
            ResultSet rs = st.executeQuery("select * from admin where id = '"+id+"'");
            while(rs.next()){
                admin.setId(rs.getInt(1));
                admin.setName(rs.getString(2));
                admin.setEmail(rs.getString(3));
                admin.setSalary(rs.getInt(4));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return admin;
    }

    @Override
    public Admin updateSingleAdmin(Admin admin) {
        try {
            Statement st = database();
            if (admin.getId()>0&&admin.getName()!=null&&admin.getEmail()!=null&&admin.getSalary()>0) {
                st.executeUpdate("update admin set name = '"+admin.getName()+"', email='"+admin.getEmail()+"', salary='"+admin.getSalary()+"' where id='"+admin.getId()+"'");
            }
            else if (admin.getId()>0&&admin.getName()!=null&&admin.getEmail()!=null) {
                st.executeUpdate("update admin set name = '"+admin.getName()+"', email='"+admin.getEmail()+"' where id ='"+admin.getId()+"'");
            }
            else if (admin.getId()>0&&admin.getName()!=null&&admin.getSalary()>0){
                st.executeUpdate("update admin set name ='"+admin.getName()+"', salary ='"+admin.getSalary()+"' where id= '"+admin.getId()+"'");
            }
            else if (admin.getId()>0&&admin.getEmail()!=null&&admin.getSalary()>0) {
                st.executeUpdate("update admin set email= '"+admin.getEmail()+"',salary = '"+admin.getSalary()+"' where id ='"+admin.getId()+"'");
            }
            else if (admin.getId()>0&&admin.getName()!=null) {
                st.executeUpdate("update admin set name = '"+admin.getName()+"' where id='"+admin.getId()+"'");
            }
            else if (admin.getId()>0&&admin.getEmail()!=null) {
                st.executeUpdate("update admin set email = '"+admin.getEmail()+"' where id ='"+admin.getId()+"'");
            }
            else if (admin.getId()>0&&admin.getSalary()>0) {
                st.executeUpdate("update admin set per = '"+admin.getSalary()+"'");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return selectSingleAdmin(admin.getId());
    }

    @Override
    public List<Admin> selectAllAdmin() {
        List<Admin> adminList = new ArrayList<>();
        try {
            Statement st = database();
            ResultSet rs = st.executeQuery("select * from admin");
            while (rs.next()){
                Admin admin = new Admin();
                admin.setId(rs.getInt(1));
                admin.setName(rs.getString(2));
                admin.setEmail(rs.getString(3));
                admin.setSalary(rs.getInt(4));
                adminList.add(admin);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return adminList;
    }

    @Override
    public Boolean deleteSingleAdmin(int id) {
        Boolean result = false;
        try{
            Statement st = database();
            int count = st.executeUpdate("delete from admin where id = '"+id+"'");
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
    public Boolean deleteAllAdmin() {
        Boolean result=false;
        try{
            Statement st = database();
            int count= st.executeUpdate("delete from admin");
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
