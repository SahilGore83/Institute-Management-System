package org.example.service.impl;

import org.example.model.Admin;
import org.example.model.Management;

import java.util.List;

public interface AdminServiceImpl {
    void insertSingleManagement(Management management);
    void insertMultipleManagement(List<Management> managementsList);
    Management selectSingleManagement(int id);
    List<Management> selectMultipleManagement(List<Integer> ids);

    Management updateSingleManagement(Management management);

    List<Management> updateMultipleManagement(List<Management> managementList);

    List<Management> selectAllManagement();

    Boolean deleteSingleManagement(int id);

    Boolean deleteMultipleManagement( List<Integer> ids);

    Boolean deleteAllManagement();

    //Admin

    void insertSingleAdmin(Admin admin);
    void insertMultipleAdmin(List<Admin> adminsList);
    Admin selectSingleAdmin(int id);
    List<Admin> selectMultipleAdmin(List<Integer> ids);

    Admin updateSingleAdmin(Admin admin);

    List<Admin> updateMultipleAdmin(List<Admin> adminList);

    List<Admin> selectAllAdmin();

    Boolean deleteSingleAdmin(int id);

    Boolean deleteMultipleAdmin( List<Integer> ids);

    Boolean deleteAllAdmin();
}
