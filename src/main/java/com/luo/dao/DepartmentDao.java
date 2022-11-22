package com.luo.dao;

import com.luo.pojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<>();//创建一个教学部
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(101,"市场部"));
        departments.put(103,new Department(101,"教研部"));
        departments.put(104,new Department(101,"运营部"));
        departments.put(105,new Department(101,"后勤部"));

    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
