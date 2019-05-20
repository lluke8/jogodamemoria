package com.example.jogodamemoria

class Partida {
    var id:Int
    var tentativa : Int

    constructor(tentativa:Int){
        this.id = -1
        this.tentativa = tentativa
    }

    constructor(id:Int, tentativa: Int){
        this.id = id
        this.tentativa = tentativa
    }

    override fun toString(): String {
        return "Partida(id=$id, tentativa=$tentativa)"
    }


}