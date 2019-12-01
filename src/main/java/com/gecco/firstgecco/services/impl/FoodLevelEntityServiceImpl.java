package com.gecco.firstgecco.services.impl;

import com.gecco.firstgecco.entities.FoodLevel;
import com.gecco.firstgecco.mappers.FoodLevelDao;
import com.gecco.firstgecco.services.FoodLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodLevelEntityServiceImpl implements FoodLevelService {

    @Autowired
    private FoodLevelDao foodLevelDao;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return foodLevelDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FoodLevel record) {
        return foodLevelDao.insert(record);
    }

    @Override
    public int insertSelective(FoodLevel record) {
        return foodLevelDao.insertSelective(record);
    }

    @Override
    public FoodLevel selectByPrimaryKey(Integer id) {
        return foodLevelDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FoodLevel record) {
        return foodLevelDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FoodLevel record) {
        return foodLevelDao.updateByPrimaryKey(record);
    }

    @Override
    public FoodLevel selectByFoodName(FoodLevel level) {
        return foodLevelDao.selectByFoodName(level);
    }
}
