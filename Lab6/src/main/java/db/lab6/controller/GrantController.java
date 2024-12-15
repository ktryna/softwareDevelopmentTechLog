package db.lab6.controller;

import db.lab6.dto.GrantDTO;
import db.lab6.entity.Grant;
import db.lab6.services.GrantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/grant")
public class GrantController {

    private final GrantService grantService;

    @PostMapping("/add")
    public Grant addGrant(@RequestBody GrantDTO grantDTO) {
        Grant grant = grantService.addGrant(grantDTO);
        return grant;
    }

    @GetMapping("/get/{id}")
    public Grant getGrantById(@PathVariable Long id) {
        Grant grant = grantService.getGrantById(id);
        return grant;
    }

    @GetMapping("/get/all")
    public List<Grant> getAllGrants() {
        return grantService.getAllGrants();
    }

    @GetMapping("/get/by_role/{id}")
    public List<Grant> getGrantsByRoleId(@PathVariable Long id) {
        return grantService.getGrantsByRoleId(id);
    }

    @GetMapping("/get/by_permission/{id}")
    public List<Grant> getGrantsByPermissionId(@PathVariable Long id) {
        return grantService.getGrantsByPermissionId(id);
    }

    @PutMapping("/update/{id}")
    public Grant updateGrant(@PathVariable Long id, @RequestBody GrantDTO grantDTO) {
        Grant grant = grantService.updateGrant(id, grantDTO);
        return grant;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGrant(@PathVariable Long id) {
        grantService.deleteGrant(id);
        return "Grant deleted";
    }
}
