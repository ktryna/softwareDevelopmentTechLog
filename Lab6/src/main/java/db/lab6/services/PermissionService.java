package db.lab6.services;

import db.lab6.dto.PermissionDTO;
import db.lab6.entity.Permission;
import db.lab6.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public Permission addPermission(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setAction(permissionDTO.getAction());
        permission.setDescription(permissionDTO.getDescription());
        return permissionRepository.save(permission);
    }

    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Permission not found"));
    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission updatePermission(Long id, PermissionDTO permissionDTO) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Permission not found"));
        permission.setAction(permissionDTO.getAction());
        permission.setDescription(permissionDTO.getDescription());
        return permissionRepository.save(permission);
    }

    public void deletePermission(Long id) {
        if (permissionRepository.existsById(id)) {
            permissionRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Permission not found");
        }
    }
}
