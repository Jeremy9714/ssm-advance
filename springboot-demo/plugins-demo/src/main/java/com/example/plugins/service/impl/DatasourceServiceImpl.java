package com.example.plugins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.plugins.bean.DatasourceBean;
import com.example.plugins.bean.DocBean;
import com.example.plugins.dao.DatasourceDao;
import com.example.plugins.service.DatasourceService;
import com.example.plugins.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 16:53
 * @Version: 1.0
 */
@Service
public class DatasourceServiceImpl extends ServiceImpl<DatasourceDao, DatasourceBean> implements DatasourceService {

    @Autowired
    private DocService docService;

    @Autowired
    private DatasourceDao datasourceDao;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveAndDelete(DatasourceBean ds, DocBean doc) {
        datasourceDao.insert(ds);
//        int i = 1 / 0;
        docService.saveOne(doc);

        int i = 1 / 0;
    }
}
