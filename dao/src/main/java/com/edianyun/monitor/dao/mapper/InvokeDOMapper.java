package com.edianyun.monitor.dao.mapper;

import com.edianyun.monitor.bean.entity.InvokeDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvokeDOMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(InvokeDO record);

    InvokeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InvokeDO record);

    List<InvokeDO> selectByInvokeDO(InvokeDO searchDO);

    int deleteByDate(@Param(value = "date") String minDate);

}