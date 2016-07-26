package com.odde.bbuddy.accountStatus;

import java.util.Date;

public class SystemTimeImpl implements SystemTime {
    @Override
    public Date getNow() {
        return new Date();
    }
}
