package gory_moon.moarsigns.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import gory_moon.moarsigns.client.renderers.MoarSignRenderer;
import gory_moon.moarsigns.tileentites.TileEntityMoarSign;

public class ClientProxy extends CommonProxy {

    @Override
    public void initRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMoarSign.class, new MoarSignRenderer());
    }

    /*
    @Override
    public void readSigns() {
        ResourceLocation location = new ResourceLocation("moarsigns", "info/signs.items");
        IResource resource = null;
        try {
            resource = Minecraft.getMinecraft().getResourceManager().getResource(location);
        } catch (IOException e) {}

        if (resource != null) {
            MoarSigns.instance.loadFile(resource.getInputStream());
        }
    }*/
}
