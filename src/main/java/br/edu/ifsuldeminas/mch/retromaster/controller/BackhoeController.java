package br.edu.ifsuldeminas.mch.retromaster.controller;

import br.edu.ifsuldeminas.mch.retromaster.model.entity.Backhoe;
import br.edu.ifsuldeminas.mch.retromaster.model.entity.Manufacturer;
import br.edu.ifsuldeminas.mch.retromaster.model.repository.BackhoeRepository;
import br.edu.ifsuldeminas.mch.retromaster.model.repository.ManufacturerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/backhoes")
public class BackhoeController {

    @Autowired
    private BackhoeRepository backhoeRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;
    private void loadManufacturers(Model model) {
        List<Manufacturer> allManufacturers = manufacturerRepository.findAll();
        model.addAttribute("allManufacturers", allManufacturers);
    }

    @GetMapping
    public String listBackhoes(Model model) {
        List<Backhoe> backhoes = backhoeRepository.findAll();
        model.addAttribute("backhoes", backhoes);
        return "backhoes/list";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("backhoe", new Backhoe());
        loadManufacturers(model);
        return "backhoes/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Backhoe> backhoe = backhoeRepository.findById(id);
        if (backhoe.isPresent()) {
            model.addAttribute("backhoe", backhoe.get());
            loadManufacturers(model);
            return "backhoes/form";
        }
        return "redirect:/backhoes";
    }

    @PostMapping("/save")
    public String saveBackhoe(@Valid @ModelAttribute("backhoe") Backhoe backhoe, BindingResult result, Model model) {
        if (result.hasErrors()) {
            loadManufacturers(model);
            return "backhoes/form";
        }
        backhoeRepository.save(backhoe);
        return "redirect:/backhoes";
    }

    @GetMapping("/delete/{id}")
    public String deleteBackhoe(@PathVariable("id") Integer id) {
        if (!backhoeRepository.existsById(id)) {
        } else {
           backhoeRepository.deleteById(id);
        }
        return "redirect:/backhoes";
    }
}