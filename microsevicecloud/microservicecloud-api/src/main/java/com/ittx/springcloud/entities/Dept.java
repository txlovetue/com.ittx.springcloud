package com.ittx.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Dept是实体类，根据ORM（对象关系映射）从而MySQL数据库中也有相应表和字段存储数据
 */
@AllArgsConstructor//全参构造函数
@NoArgsConstructor//空参构造函数
@Data//生产Getter和Setter参数
@Accessors(chain = true)//链式风格访问
public class Dept implements Serializable {//必须序列化
    private Long deptno;//主键
    private String dname;//部门名称
    private String db_source;//来自哪个数据库，因为微服务架构可以是一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname) {
        this.dname = dname;
    }

//    public static void main(String[] args) {
//        Dept dept = new Dept();
//        dept.setDeptno(1L).setDname("ittx").setDb_source("2");//测试链式写法   对应@Accessors
//        System.out.println(dept);
//    }
}
