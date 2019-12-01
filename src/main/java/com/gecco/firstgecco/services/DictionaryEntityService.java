package com.gecco.firstgecco.services;

import com.gecco.firstgecco.entities.DictionaryEntity;

public interface DictionaryEntityService {

    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryEntity record);

    int insertSelective(DictionaryEntity record);

    DictionaryEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryEntity record);

    int updateByPrimaryKey(DictionaryEntity record);

    DictionaryEntity selectByTypeAndCode(DictionaryEntity record);
}
