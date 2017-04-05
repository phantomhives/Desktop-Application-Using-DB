/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAO.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author shusa
 */
public class DepartmentDLL extends DB{
    
    public ArrayList<Department> getAllDepartment(){
        
        ArrayList<Department> departments = new ArrayList<>();
        try {
            this.setConnection();
            
            String qurey = "SELECT * FROM department";
            this.statement = this.connection.prepareStatement(qurey);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next()){
                Department aDepartment = new Department();
                aDepartment.setDepartment_id(this.resultSet.getInt(1));
                aDepartment.setDepartment_name(this.resultSet.getString(2));
                aDepartment.setDepartment_code(this.resultSet.getString(3));
                departments.add(aDepartment);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          
        }finally {
            this.DisconnectFromDb();
        }
        return departments;
    }
    
    public boolean saveDepartment(Department aDepartment){
        this.setConnection();
        int count = 0 ;
        try {
            String qurey = "INSERT INTO department(department_name,department_code) VALUES(?,?)";
            this.statement = this.connection.prepareStatement(qurey);
            this.statement.setString(1, aDepartment.getDepartment_name());
            this.statement.setString(2, aDepartment.getDepartment_code());
            count = this.statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            this.DisconnectFromDb();
        }
        if(count>0){
            return true;
        }
        return false;
    }
}
