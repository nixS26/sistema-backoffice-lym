package com.edu.cibertec.sistema_backoffice_lym.controller;

import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDetailDto;
import com.edu.cibertec.sistema_backoffice_lym.dto.FilmDto;
import com.edu.cibertec.sistema_backoffice_lym.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){    //el model, es la calse que va apermitir transportar

        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film",filmDetailDto);
        return "maintenance_edit"; //siempre devuelve una pagina
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model){ //para decir que es un atributo de modelo.. cada que se pone object se sabe que es una
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start"; //siempre devuelve una pagina
    }


}
