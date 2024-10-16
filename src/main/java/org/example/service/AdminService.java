package org.example.service;

import org.example.model.Admin;
import org.example.model.Management;
import org.example.repositroy.AdminRepositroy;
import org.example.repositroy.impl.AdminRepositoryImpl;
import org.example.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminService implements AdminServiceImpl {
    @Autowired
    private AdminRepositoryImpl repositroy;
    @Override
    public void insertSingleManagement(Management management) {
        repositroy.insertSingleManagement(management);
    }
    @Override
    public void insertMultipleManagement(List<Management> managementsList) {
        for(int i=0;i<managementsList.size();i++){
            repositroy.insertSingleManagement(managementsList.get(i));
        }
    }

    @Override
    public Management selectSingleManagement(int id) {
        return repositroy.selectSingleManagement(id);
    }

    @Override
    public List<Management> selectMultipleManagement(List<Integer> ids) {
        List<Management> managementList = new ArrayList<>();
        for (int i=0; i<ids.size(); i++){
            managementList.add(repositroy.selectSingleManagement(ids.get(i)));
        }
        return managementList;
    }

    @Override
    public Management updateSingleManagement(Management management) {
        return repositroy.updateSingleManagement(management);
    }

    @Override
    public List<Management> updateMultipleManagement(List<Management> managementList) {
        List<Management> managementList1 = new ArrayList<>();
        for (int i=0;i<managementList.size();i++){
            managementList1.add(repositroy.updateSingleManagement(managementList.get(i)));
        }
        return managementList1;
    }

    @Override
    public List<Management> selectAllManagement() {
        return repositroy.selectAllManagement();
    }

    @Override
    public Boolean deleteSingleManagement(int id) {
        return repositroy.deleteSingleManagement(id);
    }

    @Override
    public Boolean deleteMultipleManagement(List<Integer> ids) {
        List<Boolean> resultList = new ArrayList<>();
        Boolean result = false;
        for(int i=0; i<ids.size();i++){

            resultList.add(repositroy.deleteSingleManagement(ids.get(i)));
        }
        if ( resultList.contains(true) ){
            result=true;
        }
        return result;
    }

    @Override
    public Boolean deleteAllManagement() {
        return repositroy.deleteAllManagement();
    }


    @Override
    public void insertSingleAdmin(Admin admin) {
        repositroy.insertSingleAdmin(admin);
    }
    @Override
    public void insertMultipleAdmin(List<Admin> adminsList) {
        for(int i=0;i<adminsList.size();i++){
            repositroy.insertSingleAdmin(adminsList.get(i));
        }
    }

    @Override
    public Admin selectSingleAdmin(int id) {
        return repositroy.selectSingleAdmin(id);
    }

    @Override
    public List<Admin> selectMultipleAdmin(List<Integer> ids) {
        List<Admin> adminList = new ArrayList<>();
        for (int i=0; i<ids.size(); i++){
            adminList.add(repositroy.selectSingleAdmin(ids.get(i)));
        }
        return adminList;
    }

    @Override
    public Admin updateSingleAdmin(Admin admin) {
        return repositroy.updateSingleAdmin(admin);
    }

    @Override
    public List<Admin> updateMultipleAdmin(List<Admin> adminList) {
        List<Admin> adminList1 = new ArrayList<>();
        for (int i=0;i<adminList.size();i++){
            adminList1.add(repositroy.updateSingleAdmin(adminList.get(i)));
        }
        return adminList1;
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return repositroy.selectAllAdmin();
    }

    @Override
    public Boolean deleteSingleAdmin(int id) {
        return repositroy.deleteSingleAdmin(id);
    }

    @Override
    public Boolean deleteMultipleAdmin(List<Integer> ids) {
        List<Boolean> resultList = new ArrayList<>();
        Boolean result = false;
        for(int i=0; i<ids.size();i++){

            resultList.add(repositroy.deleteSingleAdmin(ids.get(i)));
        }
        if ( resultList.contains(true) ){
            result=true;
        }
        return result;
    }

    @Override
    public Boolean deleteAllAdmin() {
        return repositroy.deleteAllAdmin();
    }
}
