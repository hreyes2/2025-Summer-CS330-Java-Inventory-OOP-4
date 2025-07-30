package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Tool;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ToolCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "create" since "new" is a reserved keyword in Java.
     */
    public static ToolCreation construct()
    {
        return new ToolCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Return a **Default** Tool
        return new Tool();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // Replace the return value;
        return 6;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        Tool tool = new Tool();
        
     // Set the remaining attributes
        tool.setName(tokens[0]);
        tool.setMaterial(tokens[1]);
        tool.setDurability(Integer.parseInt(tokens[2]));
        tool.setSpeed(Integer.parseInt(tokens[3]));
        tool.setModifier(tokens[4]);
        tool.setModifierLevel(Integer.parseInt(tokens[5]));
        return tool;
    }

    @Override
    public Item fromExisting(final Item original)
    {
    	//cast original to type tool so that we can use the getters from tool
    	Tool originalTool =(Tool) original;
    	
    	//create new instance of tool
    	Tool tool = new Tool();
    	
        // Return a clone of original
        tool.setName(originalTool.getName());
        tool.setDurability(originalTool.getDurability());
        tool.setSpeed(originalTool.getSpeed());
        tool.setMaterial(originalTool.getMaterial());
        tool.setModifier(originalTool.getModifier());
        tool.setModifierLevel(originalTool.getModifierLevel());
        return tool;
    }
}
