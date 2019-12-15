package com.example.demo.service.impl;

import com.example.demo.service.HashService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashServiceImpl implements HashService {

    @Override
    public Map listToMap(List list) {

        Map seqMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            seqMap.put(i,list.get(i));
        }

        return seqMap;
    }
}
