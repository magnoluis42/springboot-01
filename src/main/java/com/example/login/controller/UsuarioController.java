package com.example.login.controller;

import com.example.login.model.Usuario;
import com.example.login.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioRepository repository;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("msgIndex", "Teste de Index");
        return "publica-index";
    }

    @GetMapping("/novo")
    public String adicionarNovoUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/form-novo-usuario";
    }

    @PostMapping("/salvar")
    public String salvarNovoUsuario(@Valid Usuario usuario,
                                    BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "/form-novo-usuario";
        }
        repository.save(usuario);
        attributes.addAttribute("mensagem", "Usuário salvo com sucesso");
    }

}
