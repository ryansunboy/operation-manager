package com.hundsun.operation.manager.mapper;

import com.hundsun.platform.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * @program: maintenance
 * @description:
 * @author: chuangkel
 * @create: 2019-01-16
 **/
@Mapper
public interface UserMapper {
    @Select("select * from users")
    List<Users> findAll();

    @Insert("insert into users(name,salary) values(#{name},#{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",before = false,resultType = Integer.class)
    void insert(Users users);

}
