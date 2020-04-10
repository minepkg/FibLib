package dev.hephaestus.fiblib.mixin.packets;

import dev.hephaestus.fiblib.FibLib;
import dev.hephaestus.fiblib.Fibber;
import net.minecraft.block.Block;
import net.minecraft.network.packet.s2c.play.BlockActionS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockActionS2CPacket.class)
public class BlockActionFibber<T> implements Fibber {
    private ServerPlayerEntity player;
    @Shadow
    private Block block;
    @Override
    public void fix(ServerPlayerEntity player) {
        this.block = FibLib.get(block.getDefaultState(), player).getBlock();
        this.player = player;
    }
}