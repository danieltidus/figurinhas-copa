package br.ufpb.dcx.dsc.figurinhas.services;

import br.ufpb.dcx.dsc.figurinhas.models.Figurinha;
import br.ufpb.dcx.dsc.figurinhas.repository.FigurinhaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FigurinhaService {
    
    private final ArrayList<Figurinha> figurinhaList= new ArrayList<>();
private FigurinhaRepository figurinhaRepository;
    public FigurinhaService(FigurinhaRepository figurinhaRepository){
        this.figurinhaRepository = figurinhaRepository;
    }
    public Figurinha getFigurinha(Long id){
        return figurinhaRepository.getReferenceById(id);
    }

    public List<Figurinha> listFigurinhas(Long userId){

        if(userId != null){
            return figurinhaRepository.findAllByUserId(userId);
        }
        return figurinhaRepository.findAll();
    }

    public List<Figurinha> listFigurinhas() {
        return figurinhaRepository.findAll();
    }

    public Figurinha saveFigurinha(Figurinha f) {
        return figurinhaRepository.save(f);
    }

    public void deleteFigurinha(Long id) {
        figurinhaRepository.deleteById(id);
    }

    public Figurinha updateFigurinha(Long id, Figurinha f) {
        Optional<Figurinha> figOpt = figurinhaRepository.findById(id);
        if(figOpt.isPresent()){
            Figurinha toUpdate = figOpt.get();
            toUpdate.setSelecao(f.getSelecao());
            toUpdate.setNome(f.getNome());
            return toUpdate;
        }
        return null;
    }

    private int getFigurinhaIndexById(Long taskId){
        for( int i = 0; i < figurinhaList.size(); i++){
            Figurinha t = figurinhaList.get(i);
            if(figurinhaList.get(i).getId().equals(taskId))
                return i;
        }
        throw new NoSuchElementException("Figurinha not found!");
    }
}
