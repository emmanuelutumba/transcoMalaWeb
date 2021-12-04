package com.ml.transco.service;

import com.ml.transco.model.Profil;
import com.ml.transco.repo.ProfilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilServiceImpl implements ProfilService {

    @Autowired
    private ProfilRepo profilRepo;

    @Override
    public List<Profil> getList() {
        return this.profilRepo.findAll();
    }

    @Override
    public Profil login(Profil profil) {

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("username", matcher -> {
                    matcher.exact();
                }).withMatcher("password", matcher -> {
                    matcher.exact();
                }).withIgnorePaths("id", "faq.id", "faq.description");

        try {
            Example<Profil> profilExample = Example.of(profil, exampleMatcher);
            Optional<Profil> profilFound = this.profilRepo.findOne(profilExample);
            if (profilFound.isPresent()) {
                Profil profil1 = profilFound.get();
                profil1.setPassword("");
                return profil1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Optional<Profil> optionalProfil = this.profilRepo.findOne(Example.of(new Profil(id)));
        if (optionalProfil.isPresent())
            return true;
        return false;
    }
}
