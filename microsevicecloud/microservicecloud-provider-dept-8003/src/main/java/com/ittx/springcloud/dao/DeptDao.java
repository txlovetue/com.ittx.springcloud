package com.ittx.springcloud.dao;

import com.ittx.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@EnableCaching
//@Mapper//如果在主线程类中指定注解可以省略
public interface DeptDao {

    @Insert("INSERT INTO dept(dname,db_source) VALUES (#{dname}, DATABASE());")
    public boolean addDept(Dept dept);

    @Select("SELECT deptno,dname,db_source FROM dept WHERE deptno = #{dpetno};")
    public Dept findById(Long id);

    @Select("SELECT deptno,dname,db_source FROM dept;")
    public List<Dept> findAll();

}
