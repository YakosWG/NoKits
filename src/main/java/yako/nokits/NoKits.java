package yako.nokits;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import yako.nokits.event.EventHandler;
import yako.nokits.init.NoKitsConfig;

import java.io.File;

@Mod(modid = NoKits.MODID, name = NoKits.NAME, version = NoKits.VERSION, dependencies = "required-after:tconstruct;")
public class NoKits {

    public static final String MODID = "nokits";
    public static final String NAME = "No Kits";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @Mod.Instance
    public static NoKits instance;
    public static Configuration config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "nokits.cfg"));
        NoKitsConfig.readConfig();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(EventHandler.INSTANCE);
    }

}
