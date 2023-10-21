package com.example.meuble.Services;

import com.example.meuble.Entities.Meuble;
import com.example.meuble.Repositories.MeubleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeubleService {

    @Autowired
    private MeubleRepository meubleRepository;

    public Meuble addMeuble(Meuble meuble) {
        return meubleRepository.save(meuble);
    }

    public Meuble updateMeuble(int id, Meuble newMeuble) {
        if (meubleRepository.findById(id).isPresent()) {
            Meuble existingMeuble = meubleRepository.findById(id).get();
            existingMeuble.setNom(newMeuble.getNom());
            existingMeuble.setDescription(newMeuble.getDescription());
            return meubleRepository.save(existingMeuble);
        } else
            return null;
    }

    public String deleteMeuble(int id) {
        if (meubleRepository.findById(id).isPresent()) {
            meubleRepository.deleteById(id);
            return "meuble supprimé";
        } else
            return "meuble non supprimé";
    }
    public List<Meuble> getAllMeubles() {
        return meubleRepository.findAll();
    }
    public Meuble getMeubleById(int id) {
        return meubleRepository.findById(id).orElse(null);
    }
}
