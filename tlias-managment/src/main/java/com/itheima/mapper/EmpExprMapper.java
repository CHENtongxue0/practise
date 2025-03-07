package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

    @Mapper
    public interface EmpExprMapper {
        /**
         * 批量插入员工工作经历数据
         * @param exprList
         */
        void batchInsert(List<EmpExpr> exprList);
    }

