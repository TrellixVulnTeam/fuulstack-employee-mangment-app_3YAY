package Crud.com.CRUD.Back.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name="employee")
@Data
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String Name;

    @Column(name="email")
    private String email;

    @Column(name="salaire")
    private String salaire;
}
