package com.washuu.s2.service.impl;

import com.washuu.s2.domain.College;
import com.washuu.s2.domain.CollegeExample;
import com.washuu.s2.mapper.CollegeMapper;
import com.washuu.s2.service.CollegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Resource
    private CollegeMapper collegeMapper;

    public College queryCollegeByCid(Integer cid) {
        return collegeMapper.selectByPrimaryKey(cid);
    }

    public College queryCollegeByCollegeName(String collegeName) {
        CollegeExample collegesExample = new CollegeExample();
        CollegeExample.Criteria criteria = collegesExample.createCriteria();
        criteria.andCollegenameEqualTo(collegeName);
        List<College> colleges = collegeMapper.selectByExample(collegesExample);
        if(colleges.size() == 1) {
            return colleges.get(0);
        }
        return null;
    }

    @Override
    public Integer queryCid(String collegeName) {
        CollegeExample collegeExample = new CollegeExample();
        CollegeExample.Criteria criteria = collegeExample.createCriteria();
        criteria.andCollegenameEqualTo(collegeName);
        List<College> colleges = collegeMapper.selectByExample(collegeExample);
        if(colleges.size() == 1) {
            return colleges.get(0).getCid();
        }
        return -1;
    }

    @Override
    public String queryCollegeName(Integer sid) {
        return collegeMapper.selectByPrimaryKey(sid).getCollegename();
    }
}
