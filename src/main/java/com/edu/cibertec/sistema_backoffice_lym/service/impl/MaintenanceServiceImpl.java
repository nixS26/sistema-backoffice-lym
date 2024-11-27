package com.edu.cibertec.sistema_backoffice_lym.service.impl;

import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDto;
import com.edu.cibertec.sistema_backoffice_lym.entity.Film;
import com.edu.cibertec.sistema_backoffice_lym.repository.FilmRepository;
import com.edu.cibertec.sistema_backoffice_lym.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    //se entiende que es un metodo sobre escrito, de la implementacion
    //ESTAMOS INYECTANDO
     @Autowired
    FilmRepository filmRepository;
    @Override
    public List<FilmDto> findAllFilms() {

        //llamar a findrepository

        //
        List<FilmDto> films = new ArrayList<FilmDto>();
        //recuperar los elemtneos de una lista d efilms
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalDuration(),
                    film.getRentalRate());
        });


        return films ;
    }
}
