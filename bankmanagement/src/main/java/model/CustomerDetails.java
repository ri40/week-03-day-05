package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer_details")
@Entity
public class CustomerDetails {
    @Id
    @NotNull(message = "id is required!")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_details_id")
    private Integer id;
    @NotNull(message = "age is required!")
    private Integer age;
    @NotNull
    private Integer balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customers customers;

}
