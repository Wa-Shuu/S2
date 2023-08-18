package com.washuu.s2.service.impl;

import com.washuu.s2.domain.School;
import com.washuu.s2.domain.SchoolExample;
import com.washuu.s2.mapper.SchoolMapper;
import com.washuu.s2.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;

    @Override
    public School querySchoolBySid(Integer sid) {
        return schoolMapper.selectByPrimaryKey(sid);
    }

    @Override
    public School querySchoolBySchoolName(String schoolName) {
        SchoolExample schoolExample = new SchoolExample();
        SchoolExample.Criteria criteria = schoolExample.createCriteria();
        criteria.andSchoolnameEqualTo(schoolName);
        List<School> schools = schoolMapper.selectByExample(schoolExample);
        if(schools.size() == 1) {
            return schools.get(0);
        }
        return null;
    }

    @Override
    public Integer querySid(String schoolName) {
        SchoolExample schoolExample = new SchoolExample();
        SchoolExample.Criteria criteria = schoolExample.createCriteria();
        criteria.andSchoolnameEqualTo(schoolName);
        List<School> schools = schoolMapper.selectByExample(schoolExample);
        if(schools.size() == 1) {
            return schools.get(0).getSid();
        }
        return -1;
    }

    @Override
    public String querySchoolName(Integer sid) {
        return schoolMapper.selectByPrimaryKey(sid).getSchoolname();
    }
}
