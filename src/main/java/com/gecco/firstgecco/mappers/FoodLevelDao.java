package com.gecco.firstgecco.mappers;

import com.gecco.firstgecco.entities.FoodLevel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodLevelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(FoodLevel record);

    int insertSelective(FoodLevel record);

    FoodLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoodLevel record);

    int updateByPrimaryKey(FoodLevel record);

    FoodLevel selectByFoodName(FoodLevel level);
}