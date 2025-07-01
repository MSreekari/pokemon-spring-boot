package com.pokemon.Pokemon.Controller;

import com.pokemon.Pokemon.model.Pokemon;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/view/{name}")
    public String showPokemonCard(@PathVariable String name, Model model){
        String url = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();
        Pokemon pokemon = restTemplate.getForObject(url, Pokemon.class);
        model.addAttribute("pokemon", pokemon);
        return "pokemon";
    }
}
