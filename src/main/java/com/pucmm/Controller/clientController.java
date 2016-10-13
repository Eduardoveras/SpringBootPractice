package com.pucmm.Controller;

import com.pucmm.Entiy.Client;
import com.pucmm.Entiy.Rent;
import com.pucmm.Entiy.User;
import com.pucmm.Service.AlquiService;
import com.pucmm.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/Client")
    public ModelAndView viewClient(Model model, @RequestParam("id") String identificationNumber){

        List<Rent> rents = clientService.findRentHistoryForClient(identificationNumber);

        model.addAttribute("client", clientService.findClient(identificationNumber));
        model.addAttribute("rents", rents);
        model.addAttribute("totalR", rents.size());

        return new ModelAndView("clientview");
    }

    @Secured("ADMIN")
    @PostMapping("/addNewClient")
    public String newClientSubmit(@RequestParam("id") String id, @RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("tel") String tel, @RequestParam("add") String add){

        clientService.registerNewClient(id, first, last, tel, add);

        return "redirect:/Clients";
    }
}
