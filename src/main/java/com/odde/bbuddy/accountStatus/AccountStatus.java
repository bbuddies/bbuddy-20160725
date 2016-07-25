package com.odde.bbuddy.accountStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "account_status")
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class AccountStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String date;

    private String remark;

    private String amount;

    @Column(name = "amount_type")
    private String amountType;

}
