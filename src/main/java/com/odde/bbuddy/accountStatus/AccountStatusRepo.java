package com.odde.bbuddy.accountStatus;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface AccountStatusRepo extends CrudRepository<AccountStatus, Long> {
}
