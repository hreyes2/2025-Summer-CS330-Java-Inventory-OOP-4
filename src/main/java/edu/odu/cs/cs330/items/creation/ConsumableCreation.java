package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Consumable;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ConsumableCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ConsumableCreation construct()
    {
        return new ConsumableCreation();
    }

    @Override
    public Item fromDefaults()
    {
        return new Consumable();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace the return value;
        return 3;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
    	//create new consumable 
    	Consumable item = new Consumable();
    	
    	//must make sure the correct index from the token correlates to assignment. 
    	//reference testFromTokens to ensure format
    	item.setName(tokens[0]);
    	item.setEffect(tokens[1]);
    	item.setNumberOfUses(Integer.parseInt(tokens[2]));
    	
        return item;
    }

    @Override
    public Item fromExisting(final Item original)
    {
        // cast Consumable on to original so that we can access getters
    	Consumable originalItem = (Consumable) original;
    	
    	//create new instance
    	Consumable item = new Consumable();
    	item.setEffect(originalItem.getEffect());
    	item.setName(originalItem.getName());
    	item.setNumberOfUses(originalItem.getNumberOfUses());
    	
    	return item;
    }
}
