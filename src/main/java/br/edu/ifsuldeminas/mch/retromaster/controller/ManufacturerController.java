package br.edu.ifsuldeminas.mch.retromaster.controller;

import br.edu.ifsuldeminas.mch.retromaster.model.entity.Manufacturer;
import br.edu.ifsuldeminas.mch.retromaster.model.repository.ManufacturerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ManufacturerController {

	    @Autowired
	    private ManufacturerRepository manufacturerRepository;

	    @GetMapping("/manufacturers")
	    public String listManufacturers(Model model) {
	        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
	        model.addAttribute("manufacturers", manufacturers);
	        return "manufacturer/list";
	    }
	    @GetMapping("/manufacturers/form")
	    public String showManufacturerForm(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
	        return "manufacturer/form";
	    }
	    @PostMapping("/manufacturers/save")
	    public String saveManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer, BindingResult validationResult) {
	        if (validationResult.hasErrors()) {
	            return "manufacturer/form";
	        }
	        manufacturerRepository.save(manufacturer);
	        return "redirect:/manufacturers";
	    }

	    @GetMapping("/manufacturers/update/{id}")
	    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
	        Manufacturer manufacturer = manufacturerRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("ID de Fabricante inválido:" + id));
	        model.addAttribute("manufacturer", manufacturer);
	        return "manufacturer/form";
	    }

	    @GetMapping("/manufacturers/delete/{id}")
	    public String deleteManufacturer(@PathVariable("id") Integer id) {
	        Manufacturer manufacturer = manufacturerRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("ID de Fabricante inválido:" + id));
	        manufacturerRepository.delete(manufacturer);
	        return "redirect:/manufacturers";
	    }
	}