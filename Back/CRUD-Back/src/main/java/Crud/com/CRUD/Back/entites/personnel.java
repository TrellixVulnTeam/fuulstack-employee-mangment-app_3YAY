package Crud.com.CRUD.Back.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personnel")
@Getter
@Setter
public class personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="specialite")
    private  String specialite;
    @Column(name="diplome")
    private  String diplome;
    @Column(name="dateDeNaissance")
    private Date dateDeNaissance;
    @Column(name="numeroCin")
    private  Long numeroCin;
}
