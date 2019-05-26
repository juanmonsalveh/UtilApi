package com.utilapi.core.facade.impl;

import com.utilapi.core.facade.ICoreBank;
import org.springframework.stereotype.Service;

@Service
public class CoreBankImpl implements ICoreBank {

    @Override
    public boolean generateAccount(String sharedkey) {
        return false;
    }
}
