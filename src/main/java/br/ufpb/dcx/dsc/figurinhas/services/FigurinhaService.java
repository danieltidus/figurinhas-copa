package br.ufpb.dcx.dsc.figurinhas.services;

import br.ufpb.dcx.dsc.figurinhas.models.Figurinha;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FigurinhaService {


    private final List<Figurinha> figurinhaList = Arrays.asList(
            new Figurinha(1L, "Neymar", "Brasil"),
            new Figurinha(1L, "Weverton", "Brasil"),
            new Figurinha(2L, "Rafinha", "Brasil"),
            new Figurinha(2L, "Pedro", "Brasil")
    );
    public List<Figurinha> listFigurinhas(Long userId){

        List<Figurinha> selected = new ArrayList<>();
        for (Figurinha figurinha: figurinhaList) {
            if(figurinha.getUserId().equals(userId)){
                selected.add(figurinha);
            }
        }
        return selected;

        //Outra forma de fazer usando streams
/*        return figurinhaList.stream()
                .filter(figurinha -> figurinha.getUserId() == userId)
                .collect(Collectors.toList());*/
    }

    public List<Figurinha> listFigurinhas() {
        return figurinhaList;
    }
}
