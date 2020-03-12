package com.ittx.springcloud.service.impl;

import com.ittx.springcloud.dao.DeptDao;
import com.ittx.springcloud.entities.Dept;
import com.ittx.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    /**
     * 这里使用get作为方法名是为了尽量迎合RestFul的规则
     */
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
