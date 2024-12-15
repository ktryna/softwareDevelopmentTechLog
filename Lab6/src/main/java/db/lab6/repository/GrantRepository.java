package db.lab6.repository;

import db.lab6.entity.Grant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrantRepository extends JpaRepository<Grant, Long> {
    List<Grant> findByRoleId(Long roleId);
    List<Grant> findByPermissionId(Long permissionId);
}
