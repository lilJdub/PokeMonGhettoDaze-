package com.example.pokemongettodaze;

class PokeMon {
    public String name;
    public int healthpoint;
    PokeMon(String nm,int hp){
        name=nm;
        healthpoint=hp;
    }
    public void setName(String nm){
        name=nm;
    }
    public String getName(){
        return name;
    }
    public void setHP(int hp){
        healthpoint=hp;
    }
    public int getHP(){
        return healthpoint;
    }
}
