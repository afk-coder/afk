package com.fux.afk.auth.service.impl;

import com.fux.afk.auth.entity.SysDept;
import com.fux.afk.auth.repository.DeptRepository;
import com.fux.afk.auth.service.DeptService;
import com.fux.afk.support.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by fuxj on 2019-4-19
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public List<SysDept> list() {
        return deptRepository.findAll();
    }

    @Override
    public SysDept getDeptById(BigDecimal id) {
        return deptRepository.getOne(id);
    }

    @Override
    public ResultVo delete(BigDecimal id) {
        try {
            deptRepository.deleteById(id);
            return ResultVo.successInfo("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failedInfo("删除过程中出现异常!");
        }
    }

    @Override
    public ResultVo saveOrUpdate(SysDept dept) {
        try {
            deptRepository.save(dept);
            return ResultVo.successInfo("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.failedInfo("保存过程中出现异常！");
        }
    }
}
