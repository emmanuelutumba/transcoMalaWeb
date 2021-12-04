package com.ml.transco.service;

import com.ml.transco.model.Profil;

import java.util.List;

public interface ProfilService {

    public List<Profil> getList();

    public Profil login(Profil profil);

    public boolean delete(long id);
}
