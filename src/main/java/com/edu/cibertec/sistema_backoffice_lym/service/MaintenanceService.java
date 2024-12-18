package com.edu.cibertec.sistema_backoffice_lym.service;

//se importa como clase
import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDetailDto;
import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();
    FilmDetailDto findFilmById(int id); //buscar por el id

    Boolean updateFilm(FilmDetailDto filmDetailDto);
}
