package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customers {
    @Id
    @NotNull(message = "id is required!")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;
    @NotEmpty(message = "username is required!")
    private String username;

    @OneToOne(mappedBy = "customers")
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;

    @OneToMany(mappedBy = "customers")
    private Set<Bank> bank;
}
