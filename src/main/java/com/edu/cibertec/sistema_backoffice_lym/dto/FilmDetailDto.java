package com.edu.cibertec.sistema_backoffice_lym.dto;

import java.util.Date;

public record FilmDetailDto(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer languageId,
                            String languageName,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replaceCost,
                            String rating,
                            String specialFeatures,
                            Date lastUpdate) {

}
