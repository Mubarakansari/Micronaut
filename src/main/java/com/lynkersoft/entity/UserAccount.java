package com.lynkersoft.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {

    @Id
    @GeneratedValue(generator = "user_account_id")
    @GenericGenerator(name = "user_account_id", strategy = "uuid2")
    private String userAccountId;

    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(unique = true)
    private String userName;

    private String password;

    @Email
    @Lob
    @NotBlank
    @Size(max = 400)
    @Column(unique = true)
    private String emailAddress;

    @NotBlank
    @Size(min = 10, max = 10)
    @Column(unique = true)
    private String mobileNumber;

}
