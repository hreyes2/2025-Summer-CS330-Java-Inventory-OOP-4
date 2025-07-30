package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;

import java.util.Arrays;

import edu.odu.cs.cs330.items.Armour;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct()
    {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults()
    {
    	//calls default Armour constructor in Armour class.
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace the return value which will be the number of values needed to create a new Armour. this will be the same amount in Armour clone;
        return 7;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        
        // Set each attribute. Integers must parseint first, Strings can access token directly
    	//use TestArmourCreation testFromTokens to figure out how the format of the tokens are coming in
    	Armour armour = new Armour();
    	
    	armour.setName(tokens[0]);
    	armour.setMaterial(tokens[1]);
    	armour.setDurability(Integer.parseInt(tokens[2]));
    	armour.setDefense(Integer.parseInt(tokens[3]));
    	armour.setModifier(tokens[4]);
    	armour.setModifierLevel(Integer.parseInt(tokens[5]));
    	armour.setElement(tokens[6]);
    	return armour;
    }

    @Override
    public Item fromExisting(final Item original)
    {
    	//must type cast in order to access getters for original
    	Armour originalArmour = (Armour) original;
    	
    	//create a new instance of armour
        Armour armour = new Armour();
        
        armour.setName(originalArmour.getName());
        armour.setDefense(originalArmour.getDefense());
        armour.setDurability(originalArmour.getDurability());
        armour.setMaterial(originalArmour.getMaterial());
        armour.setModifier(originalArmour.getModifier());
        armour.setModifierLevel(originalArmour.getModifierLevel());
        armour.setElement(originalArmour.getElement());
        return armour;
    }
}
