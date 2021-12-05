package yako.nokits.event;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.events.TinkerToolEvent;
import yako.nokits.modifier.ModNoFortify;

public class EventHandler {
    public static EventHandler INSTANCE = new EventHandler();

    @SubscribeEvent
    public void onToolBuild(TinkerToolEvent.OnItemBuilding event) {
        ModNoFortify.instance.apply(event.tag);
    }
}
