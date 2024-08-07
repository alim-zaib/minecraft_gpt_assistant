package net.alimzaib.GPTAssistantMod;

import com.mojang.logging.LogUtils;
import net.alimzaib.GPTAssistantMod.commands.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(GPTAssistantMod.MOD_ID)
public class GPTAssistantMod {
    public static final String MOD_ID = "gpt_assistant_mod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GPTAssistantMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        SetApiKeyCommand.register(event.getDispatcher());
        CheckApiKeyCommand.register(event.getDispatcher());
        CraftingQueryCommand.register(event.getDispatcher());
        ShowInventoryCommand.register(event.getDispatcher());
        AskVisionCommand.register(event.getDispatcher());
        ScreenshotCommand.register(event.getDispatcher());
        GeneralQueryCommand.register(event.getDispatcher());
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}