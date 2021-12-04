package com.ml.transco.service;

import com.ml.transco.model.Faq;
import com.ml.transco.repo.FaqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqServiceImpl implements FaqService {

    @Autowired
    private FaqRepo faqRepo;

    @Override
    public List<Faq> getList() {
        return this.faqRepo.findAll();
    }
}
