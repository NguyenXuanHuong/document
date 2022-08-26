package com.example.TestSQLQuery.CriteriaQuery;


import com.example.TestSQLQuery.CriteriaQuery.Repository.CQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CQController {
    @Autowired
    CQRepository cqRepository;
    @GetMapping("/where")
    public void testWhere(){
        cqRepository.whereCriteria();
        cqRepository.selectEntityAttr();
        cqRepository.selectMultipleAttrObjectArray();
        cqRepository.selectMultipleAttrDtoMapping();
        cqRepository.selectMultipleAttrTuple();
        cqRepository.selectMultipleAttrByMultipleRoot();
        cqRepository.join();
        cqRepository.param();
        cqRepository.aggregationFunc();
    }
}
