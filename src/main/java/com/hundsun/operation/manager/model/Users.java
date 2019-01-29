package com.hundsun.operation.manager.model;

/**
 * @program: maintenance
 * @description: 用户类
 * @author: chuangkel
 * @create: 2019-01-16
 **/
public class Users {
    private String name;
    private Long salary;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
