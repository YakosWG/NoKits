package yako.nokits.modifier;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.modifiers.IToolMod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.tools.modifiers.ModFortify;
import yako.nokits.init.NoKitsConfig;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ModNoFortify extends Modifier {

    public static final ModNoFortify instance = new ModNoFortify("nofortify");

    public ModNoFortify(String identifier) {
        super(identifier);
    }

    @Override
    public boolean canApplyTogether(IToolMod otherModifier) {
        if (otherModifier instanceof ModFortify) {
            return false;
        }
        return true;
    }

    @Override
    public String getLocalizedName() {
        int r = Math.abs(ThreadLocalRandom.current().nextInt());
        List<String> possibleNames = NoKitsConfig.JOKES;
        String name = "";
        if (possibleNames.size() != 0) {
            name = possibleNames.get(r % possibleNames.size());
        } else name = "No Sharpening Kits Modifier";
        return name;
    }

    //Method required when extending Modifier
    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {}

}
