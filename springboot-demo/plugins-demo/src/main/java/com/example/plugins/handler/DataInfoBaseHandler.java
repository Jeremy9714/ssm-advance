package com.example.plugins.handler;

import com.example.plugins.bean.DocBean;
import com.example.plugins.service.DocService;
import com.example.plugins.util.EnumConverter;
import com.example.plugins.util.SpringContextUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 10:05
 * @Version: 1.0
 */
public abstract class DataInfoBaseHandler {

    public abstract void exportDataExcel(HttpServletResponse response);

    public abstract void importDataExcel(MultipartFile file);

    /**
     * 获取excel数据
     *
     * @return
     */
    public List<List<String>> getExcelData() {
        // 通过ApplicationContextAware获取bean实例
        DocService docService = SpringContextUtils.getBean(DocService.class);
        List<DocBean> list = docService.list();

        // 表单信息 (表头 + 数据)
        List<List<String>> excelDataList = new ArrayList<>();

        // 表头
        List<String> headerList = new ArrayList<>();
        headerList.add("名称");
        headerList.add("性别");
        headerList.add("年龄");
        headerList.add("住址");
        headerList.add("职业");
        excelDataList.add(headerList);

        // 数据
        for (DocBean docBean : list) {
            List<String> dataList = new ArrayList<>();
            dataList.add(docBean.getName());
            dataList.add(EnumConverter.formatGender(docBean.getGender()));
            dataList.add(String.valueOf(docBean.getAge()));
            dataList.add(docBean.getJob());
            dataList.add(EnumConverter.formatJob(docBean.getJob()));
            excelDataList.add(dataList);
        }

        return excelDataList;
    }

}
