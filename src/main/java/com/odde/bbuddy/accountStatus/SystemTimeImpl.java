package com.odde.bbuddy.accountStatus;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SystemTimeImpl implements SystemTime {
    @Override
    public Date getNow() {
        return new Date();
    }
}
