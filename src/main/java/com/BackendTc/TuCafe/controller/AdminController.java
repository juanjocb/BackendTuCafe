package com.BackendTc.TuCafe.controller;

import com.BackendTc.TuCafe.controller.response.TokenResponse;
import com.BackendTc.TuCafe.model.Admin;
import com.BackendTc.TuCafe.model.request.*;
import com.BackendTc.TuCafe.repository.AdminRepository;
import com.BackendTc.TuCafe.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tuCafe/v1/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {

    private final AdminService adminService;
    private final AdminRepository adminRepository;

    //Controlador finalizado para DESPLEGAR Y PRESENTAR
    @PostMapping(value = "login")
    public ResponseEntity<TokenResponse> loginBusiness(@RequestBody LoginRequest request) {
        Admin admin = adminRepository.findByEmail(request.getEmail());
        if(!admin.getPassword().equals(request.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(adminService.loginAdmin(request, admin));
    }

    @GetMapping("/getAdmin")
    public List<Admin>getAdmin(){
        return adminRepository.findAll();
    }


    @PutMapping(value = "changeStatus/{idBusiness}")
    public ResponseEntity<String> changeBusinessStatus(@PathVariable Long idBusiness, @RequestBody ChangeStatusRequest request) {
        boolean statusChanged = adminService.changeBusinessStatus(idBusiness, request.getStatus());
        if (statusChanged) {
            return ResponseEntity.ok("Estado del establecimiento cambiado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("No se pudo cambiar el estado del establecimiento");
        }
    }
}

