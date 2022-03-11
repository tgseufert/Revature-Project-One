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
public class Ingredient implements java.io.Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
       private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ingredient", cascade=CascadeType.ALL)
    Set<RecipeIngredient> recipeIngredients =new HashSet<RecipeIngredient>();

    public Ingredient(String name) {
        this.name=name;

    }





}
