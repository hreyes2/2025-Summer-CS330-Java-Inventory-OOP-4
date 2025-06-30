package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
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
        // Return a **Default** Armour
        return null;
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace the return value;
        return 0;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        Armour armour = new Armour();

        // Set each attribute

        return armour;
    }

    @Override
    public Item fromExisting(final Item original)
    {
        // Return a clone of original
        return null;
    }
}
