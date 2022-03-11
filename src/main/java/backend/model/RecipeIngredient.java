package backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "recipe_ingredients")

public class RecipeIngredient{
    @Id
    @Column(name = "recipe_ingredient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "recipe_id",referencedColumnName = "id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    private Ingredient ingredient;


    @Column(name="quantity")
    private String quantity;

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, String quantity){
        this.recipe=recipe;
        this.ingredient=ingredient;
        this.quantity=quantity;
    }


}
