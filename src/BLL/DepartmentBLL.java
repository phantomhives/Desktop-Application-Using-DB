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
        if(this.checkNameAllreadyExists(aDepartment) || this.checkCodeAllreadyExists(aDepartment)){
            String msg = "";
            if(this.checkNameAllreadyExists(aDepartment)){
                msg+= "Departname already in system\n";
            }
            if(this.checkCodeAllreadyExists(aDepartment)){
                msg+= "Departcode already in system";
            }
            return msg;
        }else if(this.departmentDLL.saveDepartment(aDepartment)){
            return "Department insert successfully";
        }
        
        return "something wrong";
    }
    
    public  boolean checkNameAllreadyExists(Department aDepartment){
        return this.departmentDLL.checkNameAllreadyExists(aDepartment);
    }
    
     public  boolean checkCodeAllreadyExists(Department aDepartment){
        return this.departmentDLL.checkCodeAllreadyExists(aDepartment);
    }
    
}
