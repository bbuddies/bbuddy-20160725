package com.odde.bbuddy.account.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by taixiaomei on 7/27/16.
 */
@RequiredArgsConstructor
public class Account {
    @NonNull
    private String accountName;
    @NonNull
    private int balance;
}
