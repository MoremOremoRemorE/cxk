package cxk.cxk.service.impl;

import cxk.cxk.service.RandomCodeService;
import cxk.cxk.util.randomcode;
import org.springframework.stereotype.Service;

@Service
public class RandomCodeServiceImpl implements RandomCodeService {

    @Override
    public String getrandomcode() {
        return randomcode.getrandomcode();
    }
}
