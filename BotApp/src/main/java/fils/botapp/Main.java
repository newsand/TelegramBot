/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fils.botapp;

import webclient.WebClient;

/**
 *
 * @author FCapo
 */
public class Main {
    public static void main(String []args)
    {
        System.out.print("HELLO MODAFOKA");
        WebClient client = new WebClient();
        System.out.println(client.requestJson());
        
    }
}
