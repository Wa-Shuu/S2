package com.washuu.s2.service.impl;

import com.washuu.s2.domain.Moment;
import com.washuu.s2.domain.MomentExample;
import com.washuu.s2.mapper.MomentMapper;
import com.washuu.s2.service.MomentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MomentServiceImpl implements MomentService {

    @Resource
    private MomentMapper momentMapper;

    @Override
    public List<Moment> query() {
        MomentExample example = new MomentExample();
        MomentExample.Criteria criteria = example.createCriteria();
        List<Moment> moments = momentMapper.selectByExampleWithBLOBs(example);
        return moments;
    }


    @Override
    @Transactional
    public int publish(Moment moment) {
        return momentMapper.insertSelective(moment);
    }

}
