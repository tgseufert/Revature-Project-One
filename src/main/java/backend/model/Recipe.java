package backend.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JoinColumn(name="recipe_id")

    private int id;

    @Column(name="name")
    private String name;

    @Column(name="instructions")
    private String instructions;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(
            name="recipe_ingredients",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name="ingredient_id")}
    )
    @JsonBackReference
    private Set<Ingredient> ingredients;



//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "recipes")
//    @JsonBackReference
//    private Set<Ingredient> ingredients;

//    @ManyToMany(mappedBy = "recipeSet")




}
