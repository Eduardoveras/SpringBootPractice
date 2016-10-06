package com.pucmm.Controller;

import com.pucmm.Entiy.Client;
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

    @GetMapping("/addClient")
    public ModelAndView index(Model model) {
        model.addAttribute("position", clientService.findAllClients().size() + 1);
        model.addAttribute("clients", clientService.findAllClients());
        return new ModelAndView("registerClientes");
    }


    @Secured("ADMIN")
    @RequestMapping(name = "/add", method = RequestMethod.POST)
    public String checkPersonInfo(@RequestParam(name = "id") String id, @RequestParam(name = "first") String first, @RequestParam(name = "last") String last, @RequestParam(name = "tel") String tel, @RequestParam(name = "add") String add) {

        clientService.registerNewClient(id, first, last, tel, add);

        return "redirect:/addClient";
    }




}
