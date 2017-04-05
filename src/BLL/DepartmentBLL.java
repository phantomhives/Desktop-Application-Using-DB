/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.Department;
import DLL.DepartmentDLL;
import java.util.ArrayList;

/**
 *
 * @author shusa
 */
public class DepartmentBLL {
    
    private final DepartmentDLL departmentDLL;

    public DepartmentBLL() {
        this.departmentDLL = new DepartmentDLL();
    }

    
    public ArrayList<Department> getAllDepartment(){
        return departmentDLL.getAllDepartment();
    }
  
    public String saveDepartment(Department aDepartment){
        if(this.departmentDLL.saveDepartment(aDepartment)){
            return "Department insert successfully";
        }
        return "something wrong";
    }
    
}
