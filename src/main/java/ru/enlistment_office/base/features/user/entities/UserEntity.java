package ru.enlistment_office.base.features.user.entities;

import jakarta.persistence.*;
import lombok.Data;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

import java.util.Set;

@Data
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String password;

    @ElementCollection(targetClass = UserRole.class)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private UserAccountingEntity accounting;
}
