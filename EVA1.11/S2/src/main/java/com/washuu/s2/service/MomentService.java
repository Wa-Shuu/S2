package com.washuu.s2.service;

import com.washuu.s2.domain.Moment;

import java.util.List;

public interface MomentService {

    List<Moment> query();
    int publish(Moment moment);
}
