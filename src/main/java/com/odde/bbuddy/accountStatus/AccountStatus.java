package com.odde.bbuddy.accountStatus;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account_status")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class AccountStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String date;

    private String remark;

    private String amount;

    private String amount_type;

}
