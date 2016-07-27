package com.odde.bbuddy.account.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by taixiaomei on 7/27/16.
 */
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String accountName;

    @NonNull
    private int balance;
}
