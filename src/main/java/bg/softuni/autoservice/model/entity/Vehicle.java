package bg.softuni.autoservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false, unique = true)
    private String licensePlate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
}