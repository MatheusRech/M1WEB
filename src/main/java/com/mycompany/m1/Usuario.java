/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.m1;

/**
 *
 * @author Matheus
 */
public class Usuario {
    private String login;
    private String senha;
    
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public boolean checkUser(String user, String password){
        
        return this.login.equals(user) && this.senha.equals(password); // O java nao aceitou de geito nenhum o == e mandou eu usar essa equals ai
    }
}
