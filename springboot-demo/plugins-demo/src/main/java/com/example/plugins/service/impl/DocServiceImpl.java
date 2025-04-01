package com.example.plugins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.plugins.bean.DocBean;
import com.example.plugins.dao.DocDao;
import com.example.plugins.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 9:55
 * @Version: 1.0
 */
@Service
public class DocServiceImpl extends ServiceImpl<DocDao, DocBean> implements DocService {

    @Autowired
    private DocDao docDao;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void saveOne(DocBean bean) {
        docDao.insert(bean);
        int i = 1 / 0;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void updateOne(DocBean bean) {
        docDao.updateById(bean);
    }
}
