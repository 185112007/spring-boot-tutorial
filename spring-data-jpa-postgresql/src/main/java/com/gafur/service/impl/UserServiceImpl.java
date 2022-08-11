package com.gafur.service.impl;

import com.gafur.dto.UserDto;
import com.gafur.entity.Address;
import com.gafur.entity.AddressType;
import com.gafur.entity.User;
import com.gafur.repo.AddressRepo;
import com.gafur.repo.UserRepo;
import com.gafur.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final AddressRepo addressRepo;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        //Assert.isNull(userDto.getName(), "Name should not be null");

        User user = new User();
        user.setName(userDto.getName());
        user.setSurName(userDto.getSurName());

        List<Address> addressList = new ArrayList<>();

        userDto.getUserAddresses().forEach(addressStr ->{
            Address address = new Address();
            address.setUser(user);
            address.setAddress(addressStr);
            address.setActive(true);
            address.setAddressType(AddressType.OTHER);
            addressList.add(address);
        });

        User returnedUser = userRepo.save(user);
        addressRepo.saveAll(addressList);
        userDto.setId(returnedUser.getId());

        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> {
            UserDto userDto = UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .surName(user.getSurName())
                    .userAddresses(user.getUserAddresses().stream()
                            .map(Address::getAddress)
                            .collect(Collectors.toList()))
                    .build();
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
