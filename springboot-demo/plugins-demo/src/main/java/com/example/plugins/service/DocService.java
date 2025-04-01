package com.example.plugins.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.plugins.bean.DocBean;


/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 9:54
 * @Version: 1.0
 */
public interface DocService extends IService<DocBean> {
    
    void saveOne(DocBean bean);
    
    void updateOne(DocBean bean);
    
}
