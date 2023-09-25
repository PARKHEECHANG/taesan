package com.taesan.mydata.domain.bank.repository;

import com.taesan.mydata.domain.bank.api.dto.response.AccountListResponse;
import com.taesan.mydata.domain.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {



}
