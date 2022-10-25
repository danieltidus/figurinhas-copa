package br.ufpb.dcx.dsc.figurinhas.controller;

import br.ufpb.dcx.dsc.figurinhas.dto.FigurinhaDTO;
import br.ufpb.dcx.dsc.figurinhas.models.Figurinha;
import br.ufpb.dcx.dsc.figurinhas.services.FigurinhaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api")
public class FigurinhaController {
    private ModelMapper modelMapper;
    private final FigurinhaService todoService;

    public FigurinhaController(FigurinhaService todoService, ModelMapper modelMapper) {
        this.todoService = todoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/figurinha/{figurinhaId}")
    public FigurinhaDTO getFigurinha(@PathVariable Long figurinhaId){
        Figurinha t =  todoService.getFigurinha(figurinhaId);
        return convertToDTO(t);
    }

    // Exemplo com Query strings via ResquestParam - comente o de cima caso queira usar esta rota.
    @GetMapping("/figurinha")
    public List<FigurinhaDTO> getFilteredFigurinhas(){
        List<Figurinha> figurinhas = todoService.listFigurinhas();
        return figurinhas.stream().map(task -> convertToDTO(task)).collect(Collectors.toList());
    }

    @PostMapping("/figurinha")
    public FigurinhaDTO createFigurinha(@Valid @RequestBody FigurinhaDTO taskDTO){
        Figurinha t = convertToEntity(taskDTO);
        Figurinha taskCreated = todoService.saveFigurinha(t);
        return convertToDTO(taskCreated);
    }

    @PutMapping("/figurinha/{figurinhaId}")
    public FigurinhaDTO updateFigurinha(@PathVariable Long figurinhaId, @RequestBody FigurinhaDTO taskDTO){
        Figurinha t = convertToEntity(taskDTO);
        Figurinha taskCreated = todoService.updateFigurinha(figurinhaId, t);
        return convertToDTO(taskCreated);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/figurinha/{figurinhaId}")
    public void deleteFigurinha(@PathVariable Long figurinhaId){
        todoService.deleteFigurinha(figurinhaId);
    }

    // Exemplo de conversão com Modal Mapper
    private FigurinhaDTO convertToDTO(Figurinha t) {
        return modelMapper.map(t, FigurinhaDTO.class);
    }

    private Figurinha convertToEntity(FigurinhaDTO taskDTO) {
        return modelMapper.map(taskDTO, Figurinha.class);
    }
}
