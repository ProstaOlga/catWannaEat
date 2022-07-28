package com.inventory.cat.wanna.eat.controllers;

import com.inventory.cat.wanna.eat.dto.AddresseeDTO;
import com.inventory.cat.wanna.eat.service.api.AddressBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/email")
public class AddressBookController {
    private final AddressBookService addressBookService;

    @GetMapping()
    public HttpEntity<List<AddresseeDTO>> view() {
        return new HttpEntity<>(addressBookService.getAddressees());
    }

    @GetMapping("/{id}")
    public HttpEntity<AddresseeDTO> view(@PathVariable Long id) {
        return new HttpEntity<>(addressBookService.getAddresseeById(id));
    }

    @PostMapping()
    public void create(@RequestBody AddresseeDTO addressee) {
        addressBookService.createAddressee(addressee);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        addressBookService.removeAddressee(id);
    }

    @PutMapping()
    public void update(@RequestBody AddresseeDTO addressee) {
        addressBookService.updateAddresseesEmail(addressee);
    }
}
