package com.pokemon.Pokemon.model;

import lombok.Data;

@Data
public class Pokemon {
    private String name;
    private int height;
    private int weight;
    private Sprites sprites;
}