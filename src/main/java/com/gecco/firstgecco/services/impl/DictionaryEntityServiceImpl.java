package com.gecco.firstgecco.services.impl;

import com.gecco.firstgecco.entities.DictionaryEntity;
import com.gecco.firstgecco.mappers.DictionaryEntityDao;
import com.gecco.firstgecco.services.DictionaryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryEntityServiceImpl implements DictionaryEntityService {

    @Autowired
    private DictionaryEntityDao entityDao;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return entityDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DictionaryEntity record) {
        return entityDao.insert(record);
    }

    @Override
    public int insertSelective(DictionaryEntity record) {
        return entityDao.insertSelective(record);
    }

    @Override
    public DictionaryEntity selectByPrimaryKey(Integer id) {
        return entityDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DictionaryEntity record) {
        return entityDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DictionaryEntity record) {
        return entityDao.updateByPrimaryKey(record);
    }

    @Override
    public DictionaryEntity selectByTypeAndCode(DictionaryEntity record) {
        return entityDao.selectByTypeAndCode(record);
    }
}
