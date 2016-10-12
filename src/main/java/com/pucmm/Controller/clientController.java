package com.pucmm.Controller;

import com.pucmm.Entiy.Client;
import com.pucmm.Entiy.User;
import com.pucmm.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Eduardo veras on 06-Oct-16.
 */
@Controller
public class clientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/Clients")
    public ModelAndView index(Model model) {
        model.addAttribute("position", clientService.findAllClients().size() + 1);
        model.addAttribute("clients", clientService.findAllClients());
        return new ModelAndView("registerClientes");
    }


    @Secured("ADMIN")
    @PostMapping("/addNewClient")
    public String newClientSubmit(@RequestParam("id") String id, @RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("tel") String tel, @RequestParam("add") String add){

        clientService.registerNewClient(id, first, last, tel, add);

        return "redirect:/addClient";
    }
}
