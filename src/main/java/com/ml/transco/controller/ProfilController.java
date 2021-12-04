package com.ml.transco.controller;

import com.ml.transco.model.Profil;
import com.ml.transco.service.ProfilService;
import com.ml.transco.utils.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profil")
public class ProfilController {

    @Autowired
    private ProfilService profilService;

    @GetMapping
    public ResponseEntity getList() {
        return ResponseEntity.ok(this.profilService.getList());
    }

    @PostMapping(value = "/auth")
    public ResponseEntity login(@RequestBody Profil profil) {

        HttpResponse httpResponse = new HttpResponse();

        try {
            Profil profil1 = this.profilService.login(profil);
            if (profil1 != null) {
                httpResponse.setCode("200");
            } else {
                httpResponse.setCode("400");
                httpResponse.setMessage("Aucun profil trouve");
            }
            return ResponseEntity.ok(httpResponse);
        } catch (Exception e) {

        }
        httpResponse.setCode("500");
        return ResponseEntity.ok(this.profilService.login(profil));
    }
}
