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
public class Recipe implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    //@JoinColumn(name="recipe_id")

    private int id;

    @Column(name="name")
    private String name;

    @Column(name="instructions")
    private String instructions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade=CascadeType.ALL)
    Set<RecipeIngredient> recipeIngredients =new HashSet<RecipeIngredient>();


    public Recipe(String name, String instructions) {
        this.name=name;
        this.instructions=instructions;

    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        this.recipeIngredients.add(recipeIngredient);
    }

}
