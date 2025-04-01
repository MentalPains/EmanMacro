package com.yourmod;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeybindHandler {
    private final KeyBinding toggleKey = new KeyBinding("Toggle Enderman Hunt", Keyboard.KEY_G, "EmanMacro");
    private final EndermanHunter hunter;

    public KeybindHandler(EndermanHunter hunter) {
        this.hunter = hunter;
        ClientRegistry.registerKeyBinding(toggleKey);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        if (toggleKey.isPressed()) {
            hunter.toggleHunting();
            System.out.println("Enderman Hunting " + (hunter.isHunting() ? "Enabled" : "Disabled"));
        }
    }
}
