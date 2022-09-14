package br.ufpb.dcx.dsc.figurinhas.controller;

import br.ufpb.dcx.dsc.figurinhas.models.Figurinha;
import br.ufpb.dcx.dsc.figurinhas.services.FigurinhaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/figurinhas")
public class FigurinhaController {

    private final FigurinhaService todoService;

    public FigurinhaController(FigurinhaService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "/{userId}")
    public List<Figurinha> getFigurinhas(@PathVariable Long userId){
        return todoService.listFigurinhas(userId);
    }

    @GetMapping()
    public List<Figurinha> getAllFigurinhas(){
        return todoService.listFigurinhas();
    }
}
