package com.gecco.firstgecco.services;

import com.gecco.firstgecco.entities.FoodLevel;

public interface FoodLevelService {

    int deleteByPrimaryKey(Integer id);

    int insert(FoodLevel record);

    int insertSelective(FoodLevel record);

    FoodLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoodLevel record);

    int updateByPrimaryKey(FoodLevel record);


    FoodLevel selectByFoodName(FoodLevel level);

}
