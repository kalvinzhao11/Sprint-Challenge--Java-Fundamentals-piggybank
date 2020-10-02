package com.kalvinzhao.coin.controllers;

import com.kalvinzhao.coin.models.Coin;
import com.kalvinzhao.coin.respositories.CoinRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {

    @Autowired //give the class and the name of the object, autowire handle creating the instance of that object, providing any parameter that is needed, and calling the right constructor
    CoinRepositories coinrepo;

    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> totalCoins() {
        List<Coin> myList = new ArrayList<>();
        coinrepo.findAll().iterator().forEachRemaining(myList::add); //for each remaining element in the list, add it to the arraylist
        double total = 0;
        for (Coin c: myList){
            if (c.getQuantity() > 1){
                System.out.println(c.getQuantity() + " " + c.getNameplural());
            } else {
                System.out.println(c.getQuantity() + " " + c.getName());
            }
            total += c.getValue() * c.getQuantity();
        }
        System.out.println("the piggy bank holds " + total);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    http://localhost:2019/money/{amount}
    @GetMapping(value = "/money/{amount}", produces = {"application/json"})
    public ResponseEntity<?> removeCoin(@PathVariable char amount) { //letter has to match {letter} from previous line
        List<Coin> myList = new ArrayList<>();
        coinrepo.findAll().iterator().forEachRemaining(myList::add);
        double total = 0;
        for (Coin c: myList){
            total += c.getValue() * c.getQuantity();
        }
        if (amount > total) {
            System.out.println("Money not available");;
        } else {
            while (amount != 0) {

            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
