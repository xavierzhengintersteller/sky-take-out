package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category" +
            "(id, type, name, sort, status, create_time, update_time, create_user, update_user)" +
            "VALUES" +
            "(#{id}, #{type}, #{name}, #{sort}, #{status}, #{createTime},#{updateTime}," +
            "#{createUser}, #{updateUser})")
    public void insert(Category category);

    Page<Category> categoryQuery(CategoryPageQueryDTO CategoryPageQueryDTO);

    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    void update(Category category);

    List<Category> list(Integer type);
}
