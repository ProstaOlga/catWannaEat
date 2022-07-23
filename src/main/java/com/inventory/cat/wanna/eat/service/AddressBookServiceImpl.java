package com.inventory.cat.wanna.eat.service;

import com.inventory.cat.wanna.eat.dto.AddresseeDTO;
import com.inventory.cat.wanna.eat.mappers.AddresseeMapper;
import com.inventory.cat.wanna.eat.models.Addressee;
import com.inventory.cat.wanna.eat.repos.AddresseeRepo;
import com.inventory.cat.wanna.eat.service.api.AddressBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressBookServiceImpl implements AddressBookService {

    private final AddresseeRepo addresseeRepo;

    @Override
    public List<AddresseeDTO> getAddressees() {
        List<Addressee> addressees = (List<Addressee>) addresseeRepo.findAll();
        return addressees.stream()
                .map(AddresseeMapper.INSTANCE::addresseeToAddresseeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddresseeDTO getAddresseeById(Long id) {
        return AddresseeMapper.INSTANCE.addresseeToAddresseeDTO(addresseeRepo.getById(id));
    }

    @Override
    public void createAddressee(AddresseeDTO addressee) {
        addresseeRepo.save(AddresseeMapper.INSTANCE.addresseeDTOtoAddressee(addressee));
    }


    @Override
    public void removeAddressee(Long id) {
        addresseeRepo.deleteById(id);
    }

    @Override
    public void changeAddresseesEmail(AddresseeDTO addressee) {

    }
}
