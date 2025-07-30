package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one Consumable Item--as found in most video games.
 * This includes food.
 *
 * Consumable Items must be stackable.
 */
@SuppressWarnings({
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.BeanMembersShouldSerialize"
})
public class Consumable implements Item {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Eft: %s%n",
        "  Use: %d%n"
    );

    /**
     * The name...
     */
    protected String name;

    /**
     * The effect "buff" or "debuff" that is received when using this item.
     */
    protected String effect;

    /**
     * The number of times this item can be used.
     */
    protected int uses;

    /**
     * Default to a Consumable Item with an empty name, no effect and zero
     * uses.
     */
    public Consumable()
    {
        this.name = "[Placeholder]";
        this.effect = "[Placeholder]";
        this.uses = 0;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void setName(final String nme)
    {
        this.name = nme;
    }

    /**
     * Retrieve the effect.
     *
     * @return the set effect (i.e., buff or debuff)
     */
    public String getEffect()
    {
        return this.effect;
    }

    /**
     * Set a new buff or debuff.
     *
     * @param newEff replacement effect
     */
    public void setEffect(String newEff)
    {
        this.effect = newEff;
    }

    /**
     * Retrieve permitted number of uses.
     *
     * @return number of total uses
     */
    public int getNumberOfUses()
    {
        return this.uses;
    }

    /**
     * Set the number of permitted uses.
     *
     * @param allowed number of allowed uses
     */
    public void setNumberOfUses(int allowed)
    {
        this.uses = allowed;
    }

    @Override
    public boolean isStackable()
    {
        return true;
    }

    /**
     * Clone--i.e., copy--this Consumable Item.
     */
    @Override
    public Item clone()
    {
        Consumable cpy = new Consumable();
        cpy.setName(this.getName());
        cpy.setNumberOfUses(this.getNumberOfUses());
        cpy.setEffect(this.getEffect());
        //once all fields collected, return cpy
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name and effect.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    
    //clone and hashcode must be completed before equals can be used to compare
    public boolean equals(Object rhs)
    {
    	//if at same same memory location, return true
    	if (this == rhs) {
    		return true;
    	}
        if (!(rhs instanceof Consumable)) {
            return false;
        }
        
        //if not at same memory location cast type to Consumable and use Consumable getters
        Consumable rhsItem = (Consumable) rhs;
        return Objects.equals(this.getName(), rhsItem.getName())
        		&& Objects.equals(this.getEffect(), rhsItem.getEffect())
        		;
    }

    /**
     * Generate a hash code based on name and effect.
     *
     * Add <code>name.hashCode()</code> and <code>effect.hashCode</code>, then
     * return the result.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(
        		getName(), 
        		getEffect()
        		);
        	
    }

    /**
     * *Print* the Consumable Item.
     */
    @Override
    //simply call String.format and use the FMT_STR specified above
    public String toString()
    {
        return String.format(
        		FMT_STR, 
        		getName(),
        		getEffect(),
        		getNumberOfUses());
    }
}
