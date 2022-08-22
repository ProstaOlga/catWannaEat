package com.inventory.cat.wanna.eat.models;

import io.swagger.v3.oas.annotations.media.Encoding;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity(name = "profile")
@Table(name = "profile")
public class Profile implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_cat",
            joinColumns = {@JoinColumn(name = "profile_id")},
            inverseJoinColumns = {@JoinColumn(name = "cat_id")})
    private List<Cat> cats;

    @OneToMany(mappedBy = "profile")
    private List<FoodBag> foodBags;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", updatable = false)
    private Role role;

    public Profile() {
        cats = new ArrayList<>();
        foodBags = new ArrayList<>();
    }

    @Transactional
    public Long getPresentCountFoodType(Food food) {
        List<Food> currentFoods = getPresentFoodTypes();

        return this.foodBags.stream()
                .filter(fb -> food.getFoodType().equals(fb.getFood().getFoodType()))
                .map(FoodBag::getAmount)
                .reduce(0L, Long::sum);
    }


    public List<Food> getPresentFoodTypes() {
        return this.foodBags.stream()
                .map(FoodBag::getFood).distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.role.getName()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
