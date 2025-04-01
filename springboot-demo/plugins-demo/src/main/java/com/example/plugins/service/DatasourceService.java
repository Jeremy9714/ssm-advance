package com.example.plugins.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.plugins.bean.DatasourceBean;
import com.example.plugins.bean.DocBean;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 16:53
 * @Version: 1.0
 */
public interface DatasourceService extends IService<DatasourceBean> {
    
    void saveAndDelete(DatasourceBean ds, DocBean doc);
}
