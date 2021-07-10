package com.feywild.feywild.network;

import com.feywild.feywild.quest.QuestMap;
import com.feywild.feywild.screens.PixieScreen;
import com.feywild.feywild.setup.ClientProxy;
import com.feywild.feywild.util.ClientUtil;
import com.feywild.feywild.util.ModUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.scoreboard.Score;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class OpenQuestScreen {

    int lines, quest, entity;
    boolean canSkip;
    //Read msg from buf
    public OpenQuestScreen(PacketBuffer buf) {
        lines = buf.readInt();
        quest = buf.readInt();
         canSkip = buf.readBoolean();
         entity = buf.readInt();
    }

    //constructor
    public OpenQuestScreen(int quest, int lines, boolean canSkip, int entity) {

        this.lines = lines;
        this.quest = quest;
        this.canSkip = canSkip;
        this.entity = entity;
    }

    //Save msg to buf
    public void toBytes(PacketBuffer buf) {
        buf.writeInt(lines);
        buf.writeInt(quest);
        buf.writeBoolean(canSkip);
        buf.writeInt(entity);
    }

    //handle package data
    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork( () -> {
            try{
                if(ctx.get().getDirection().getReceptionSide().isClient()){
                    World world = new ClientProxy().getClientWorld();
                    ClientUtil.openQuestScreen(quest, lines, canSkip, (LivingEntity) world.getEntity(entity));
                    ctx.get().setPacketHandled(true);
                }
            }catch (Exception e) {
                ctx.get().setPacketHandled(false);
                e.printStackTrace();
            }
        });

        ctx.get().setPacketHandled(true);
    }
}
