package com.odde.bbuddy.account;

import com.odde.bbuddy.account.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by taixiaomei on 7/27/16.
 */
public interface AccountRepo extends CrudRepository<Account,Long> {

}
