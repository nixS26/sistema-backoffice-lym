package com.edu.cibertec.sistema_backoffice_lym.controller;

import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDetailDto;
import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDto;
import com.edu.cibertec.sistema_backoffice_lym.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {


    //hacemos referencia a la interfaz
    @Autowired
    MaintenanceService maintenanceService;



    @GetMapping("/start")
    public String start(Model model) {

        List<FilmDto> films= maintenanceService.findAllFilms(); //devuelve la colleccion de mi dto(en el dto esta filtrado)
        model.addAttribute("films",films); //agregar a su modelo, palabra clave y su nombre
        return "maintenance"; //debe hacer match con el nombre del html el template

    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){    //el model, es la calse que va apermitir transportar

        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film",filmDetailDto);
        return "maintenance_detail"; //siempre devuelve una pagina
    }

}
