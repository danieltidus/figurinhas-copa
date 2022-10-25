package br.ufpb.dcx.dsc.figurinhas.controller;

import br.ufpb.dcx.dsc.figurinhas.dto.AlbumDTO;
import br.ufpb.dcx.dsc.figurinhas.models.Album;
import br.ufpb.dcx.dsc.figurinhas.services.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api")
public class AlbumController {
    private ModelMapper modelMapper;
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/album/{albumId}")
    public AlbumDTO getAlbum(@PathVariable Long albumId){
        Album a =  albumService.getAlbum(albumId);
        return convertToDTO(a);
    }

    // Exemplo com Query strings via ResquestParam - comente o de cima caso queira usar esta rota.
    @GetMapping("/album")
    public List<AlbumDTO> getFilteredAlbuns(){
        List<Album> albuns = albumService.listAlbuns();
        return albuns.stream().map(album -> convertToDTO(album)).collect(Collectors.toList());
    }

    @PostMapping("/user/{userId}/album")
    public AlbumDTO createAlbum(@PathVariable Long userId, @Valid @RequestBody AlbumDTO albumDTO){
        Album a = convertToEntity(albumDTO);
        Album albumCreated = albumService.saveAlbum(a, userId);
        return convertToDTO(albumCreated);
    }

    @PutMapping("/album/{albumId}")
    public AlbumDTO updateAlbum(@PathVariable Long albumaId, @RequestBody AlbumDTO albumDTO){
        Album a = convertToEntity(albumDTO);
        Album albumCreated = albumService.updateAlbum(albumaId, a);
        return convertToDTO(albumCreated);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/album/{albumId}")
    public void deleteAlbum(@PathVariable Long albumId){
        albumService.deleteAlbum(albumId);
    }

    private AlbumDTO convertToDTO(Album a) {
        return modelMapper.map(a, AlbumDTO.class);
    }

    private Album convertToEntity(AlbumDTO albumDTO) {
        return modelMapper.map(albumDTO, Album.class);
    }
}
