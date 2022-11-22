package com.luo.dao;

import com.luo.pojo.Department;
import com.luo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//员工dao
public class EmployeeDao {
    private static Map<Integer,Employee> employees=null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();//创建一个教学部
        employees.put(101,new Employee(1001,"AAA","A123@qq.com",1,new Department(101,"教学部")));
        employees.put(102,new Employee(1002,"BBB","B123@qq.com",0,new Department(102,"市场部")));
        employees.put(103,new Employee(1003,"CCC","C123@qq.com",3,new Department(103,"教研部")));
        employees.put(104,new Employee(1004,"DDD","D123@qq.com",2,new Department(104,"运营部")));
        employees.put(105,new Employee(1005,"EEE","E123@qq.com",1,new Department(105,"后勤部")));

    }
    //主键自增
    private static Integer intId=10086;
    //增加员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(intId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工通过id
    public void delete(Integer id){
        employees.remove(id);
    }
}
