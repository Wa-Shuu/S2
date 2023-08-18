package com.washuu.s2.service;

import com.washuu.s2.domain.College;

public interface CollegeService {
    College queryCollegeByCid(Integer cid);
    College queryCollegeByCollegeName(String CollegeName);
    Integer queryCid(String schoolName);
    String queryCollegeName(Integer sid);
}
