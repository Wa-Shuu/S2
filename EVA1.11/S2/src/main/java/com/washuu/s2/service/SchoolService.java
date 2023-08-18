package com.washuu.s2.service;

import com.washuu.s2.domain.School;

public interface SchoolService {
    School querySchoolBySid(Integer sid);
    School querySchoolBySchoolName(String schoolName);
    Integer querySid(String schoolName);
    String querySchoolName(Integer sid);
}
