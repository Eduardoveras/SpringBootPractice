package com.pucmm.Controller;

import com.pucmm.Entiy.Client;
import com.pucmm.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Eduardo veras on 06-Oct-16.
 */
@Controller
public class clientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/addClient")
    public ModelAndView index(Model model) {
        model.addAttribute("clients", clientService.findAllClients());
        return new ModelAndView("registerClientes");
    }



    @PostMapping("/")
    public String checkPersonInfo(@Valid Client client, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }




}
