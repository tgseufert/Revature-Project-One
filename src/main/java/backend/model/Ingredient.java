package backend.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JoinColumn(name="ingredient_id")

    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private String quantity;




    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "ingredients")
    @JsonBackReference
    private Set<Recipe> recipes;



    public Ingredient(String name, String quantity) {
        this.name=name;
        this.quantity=quantity;
    }



}
