package com.gecco.firstgecco.mappers;

import com.gecco.firstgecco.entities.DictionaryEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictionaryEntityDao {
    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryEntity record);

    int insertSelective(DictionaryEntity record);

    DictionaryEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryEntity record);

    int updateByPrimaryKey(DictionaryEntity record);

    DictionaryEntity selectByTypeAndCode(DictionaryEntity record);
}