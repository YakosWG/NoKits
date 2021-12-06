package yako.nokits.init;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import yako.nokits.NoKits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoKitsConfig {

    private static final String CATEGORY_GENERAL = "general";
    public static List<String> JOKES = new ArrayList<>();

    public static void readConfig() {
        Configuration cfg = NoKits.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch (Exception e1) {
            NoKits.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "Configure NoKits");
        JOKES = Arrays.asList(cfg.getStringList("Jokes", CATEGORY_GENERAL, new String[]{"No Sharpening Kits Modifier"}, "When trying to apply a sharpening kit to a tool, " +
                "a random message from this list will be chosen. \n " +
                "Format: \"Modifier X is not compatible with {Your Text}\" "));
    }


}
