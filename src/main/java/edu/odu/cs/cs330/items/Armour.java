package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable implements Item
{
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %s%n",
        "  Def: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n",
        "  Emt: %s%n"
    );

    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour()
    {
        super();

        this.name = "[Placeholder]";
        this.defense = 0;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement getDefense()
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();
        //copy the fields that we have by way of extending equippable class
        cpy.setName(this.getName());
        cpy.setDurability(this.getDurability());
        cpy.setMaterial(this.getMaterial());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
        cpy.setElement(this.getElement());
        //defense is a unique field to the armour class but we need it to make a copy
        //could have used cpy.defense = this.defense; but instead we will use the setter and getter for defense
        cpy.setDefense(this.getDefense());
        
        //return cpy once we have all fields
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier,
     * modifierLevel, element, and defense.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
    	//see if point to same location in memory, if so return true
    	//this points to current object and rhs will be provided as an argument
    	if (this == rhs) {
    		return true;
    	}
    	
    	//return false because we know instantly the comparison will fail
        if (!(rhs instanceof Armour)) {
            return false;
        }
        
        //need to find 2 objects that are equal that ARE NOT at the same memory location
        //since we confirmed that rhs is of type Armour, we can cast Armour to rhs so that we can access the armour fields 
        //if we do not type cast to Armour it will be casted as "Object" by default
        Armour rhsItem = (Armour) rhs;

        return Objects.equals(this.name, rhsItem.name)
        		&& Objects.equals(this.getMaterial(), rhsItem.getMaterial())
        		&& Objects.equals(this.getModifier(), rhsItem.getModifier())
        		&& Objects.equals(this.getModifierLevel(), rhsItem.getModifierLevel())
        		&& Objects.equals(this.getElement(), rhsItem.getElement())
        		&& Objects.equals(this.getDefense(), rhsItem.getDefense());
    }

    /**
     * Compute hashCode based on name, material, modifier, modifierLevel,
     * element, and defense.
     */
    @Override
    public int hashCode()
    {
    		//simply call Objects.hash
        return Objects.hash(
        		name,
        		getMaterial(),
        		getModifier(),
        		getModifierLevel(),
        		getElement(),
        		getDefense()
        		
        		);
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
    	//call String.format using format provided above
        return String.format(
        		FMT_STR, 
        		name, 
        		getDurability(), 
        		getDefense(),
        		getMaterial(), 
        		getModifier(),
        		getModifierLevel(), 
        		getElement());
    }
}




