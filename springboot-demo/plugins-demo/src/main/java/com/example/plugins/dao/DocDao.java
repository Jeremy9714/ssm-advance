package com.example.plugins.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.plugins.bean.DocBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 9:54
 * @Version: 1.0
 */
@Mapper
public interface DocDao extends BaseMapper<DocBean> {
}
