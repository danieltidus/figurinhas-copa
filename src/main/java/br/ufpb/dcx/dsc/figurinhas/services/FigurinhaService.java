package br.ufpb.dcx.dsc.figurinhas.services;

import br.ufpb.dcx.dsc.figurinhas.models.Figurinha;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FigurinhaService {
    
    private final ArrayList<Figurinha> figurinhaList= new ArrayList<>();

    FigurinhaService(){
        figurinhaList.add(new Figurinha(1L, "Neymar", "Brasil"));
        figurinhaList.add(new Figurinha(1L, "Weverton", "Brasil"));
        figurinhaList.add(new Figurinha(2L, "Rafinha", "Brasil"));
        figurinhaList.add(new Figurinha(2L, "Pedro", "Brasil"));
    }
    public Figurinha getFigurinha(Long taskId){
        int index = this.getFigurinhaIndexById(taskId);
        return figurinhaList.get(index);
    }

    public List<Figurinha> listFigurinhas(Long userId){

        List<Figurinha> selected = new ArrayList<>();
        if(userId != null){
            for (Figurinha task: figurinhaList) {
                if(task.getUserId().equals(userId)){
                    selected.add(task);
                }
            }
            return selected;
        }
        return figurinhaList;

        //Outra forma de fazer usando streams
/*        return figurinhaList.stream()
                .filter(task -> task.getUserId() == userId)
                .collect(Collectors.toList());*/
    }

    public List<Figurinha> listFigurinhas() {
        return figurinhaList;
    }

    public Figurinha saveFigurinha(Figurinha t) {
        figurinhaList.add(t);
        return t;
    }

    public void deleteFigurinha(Long taskId) {
        int index = this.getFigurinhaIndexById(taskId);
        if(index == -1)
            return;
        figurinhaList.remove(index);
    }

    public Figurinha updateFigurinha(Long id, Figurinha f) {
        int index = this.getFigurinhaIndexById(id);
        Figurinha toUpdate = figurinhaList.get(index);
        toUpdate.setSelecao(f.getSelecao());
        toUpdate.setNome(f.getNome());
        return toUpdate;
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
