package org.example.repositroy.impl;

import org.example.model.Admin;
import org.example.model.Management;

import java.util.List;

public interface AdminRepositoryImpl {
    void insertSingleManagement(Management management);
    Management selectSingleManagement(int id);

    Management updateSingleManagement(Management management);

    List<Management> selectAllManagement();

    Boolean deleteSingleManagement(int id);

    Boolean deleteAllManagement();


    //Admin;
    void insertSingleAdmin(Admin admin);
    Admin selectSingleAdmin(int id);

    Admin updateSingleAdmin(Admin admin);

    List<Admin> selectAllAdmin();

    Boolean deleteSingleAdmin(int id);

    Boolean deleteAllAdmin();
}
