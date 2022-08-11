package com.gafur.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jc_user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {
    @Id
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name = "name")
    private String name;

    @Column(length = 100, name = "sur_name")
    private String surName;

    @OneToMany
    @JoinColumn(name = "user_address_id")
    private List<Address> userAddresses;
}
