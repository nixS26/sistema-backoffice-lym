package com.edu.cibertec.sistema_backoffice_lym.service.impl;

import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDetailDto;
import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDto;
import com.edu.cibertec.sistema_backoffice_lym.entity.Film;
import com.edu.cibertec.sistema_backoffice_lym.repository.FilmRepository;
import com.edu.cibertec.sistema_backoffice_lym.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
            films.add(filmDto);
        });


        return films ;
    }

    //nuevo emtodo apra poder implementar mi dto
    @Override
    public FilmDetailDto findFilmById(int id) {

        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(    //map es para manipular, fue creado para poder controlar el null//encapsulador
                film -> new FilmDetailDto(film.getFilmId(), //si esta presente se devuelve los datos
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate())
        ).orElse(null); //si no esta presencte el optional se devuelve null

    }

    @Override
    public Boolean updateFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        return optional.map(
                film -> {
                    film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(false);
    }
}
