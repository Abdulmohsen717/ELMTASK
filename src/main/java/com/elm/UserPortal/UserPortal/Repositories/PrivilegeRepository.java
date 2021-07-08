package com.elm.UserPortal.UserPortal.Repositories;

import com.elm.UserPortal.UserPortal.Models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
}
