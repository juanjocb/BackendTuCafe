package com.BackendTc.TuCafe.controller;

import com.BackendTc.TuCafe.controller.response.TokenResponse;
import com.BackendTc.TuCafe.model.Business;
import com.BackendTc.TuCafe.model.Client;
import com.BackendTc.TuCafe.model.request.ChangePasswordRequest;
import com.BackendTc.TuCafe.model.request.LoginRequest;
import com.BackendTc.TuCafe.model.request.RegisterRequest;
import com.BackendTc.TuCafe.model.request.UpdateClientRequest;
import com.BackendTc.TuCafe.repository.BusinessRepository;
import com.BackendTc.TuCafe.repository.ClientRepository;
import com.BackendTc.TuCafe.service.ClientService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tuCafe/v1/client")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;
    private final BusinessRepository businessRepository;
    private final ClientRepository clientRepository;

    //Controlador finalizado para DESPLEGAR Y PRESENTAR
    @PostMapping(value = "register")
    public ResponseEntity<String> registerClient(@RequestBody RegisterRequest request) throws MessagingException {
        return clientService.registerCliente(request);
    }

    //Controlador finalizado para DESPLEGAR Y PRESENTAR
    @PostMapping(value = "login")
    public ResponseEntity<TokenResponse> loginUser(@RequestBody LoginRequest request) {
        Client client = clientRepository.findByEmail(request.getEmail());
        if(!client.getPassword().equals(request.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(clientService.loginCliente(request, client));
    }

    @PutMapping("put/{id_client}")
    public Client updateClientProfile(@PathVariable Long id_client, @RequestBody UpdateClientRequest request) {
        return clientService.updateProfClient(id_client, request);
    }

    @PutMapping(value = "{idClient}/changePassword")
    public ResponseEntity<String> changeClientPassword(@PathVariable Long idClient, @RequestBody ChangePasswordRequest request) {
        System.out.println(request.getCurrentPassword() + " " + request.getNewPassword());
        return clientService.changeClientPassword(idClient, request);
    }

    @GetMapping("{idClient}")
    public ResponseEntity<Client> getBusinessById(@PathVariable Long idClient) {
        Client client = clientService.findClientById(idClient);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listBusiness")
    public List<Business>getBusiness(){
        return businessRepository.findAll();
    }
}