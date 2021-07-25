package com.feywild.feywild.screens;

import com.feywild.feywild.FeywildMod;
import com.feywild.feywild.network.FeywildPacketHandler;
import com.feywild.feywild.network.ItemEntityMessage;
import com.feywild.feywild.network.QuestMessage;
import com.feywild.feywild.network.RequestOpenQuestScreen;
import com.feywild.feywild.quest.MessageQuest;
import com.feywild.feywild.screens.widget.BookWidget;
import com.feywild.feywild.screens.widget.LookingGlassWidget;
import com.feywild.feywild.screens.widget.QuestWidget;
import com.feywild.feywild.util.ClientUtil;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nonnull;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// Ancient's note : good luck reading this and I am sorry >.<
// Tried my best to add comments
public class LibrarianScreen extends Screen {

    private final ResourceLocation GUI = new ResourceLocation(FeywildMod.MOD_ID, "textures/gui/pixie_quest_gui.png");
    StringTextComponent title = new StringTextComponent("-Available Books-");
    List<ItemStack> stacks;


    public LibrarianScreen(ITextComponent name, List<ItemStack> stacks) {
        super(name);
        this.stacks = stacks;
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);

        renderBackground(matrixStack);
        drawTextLines(matrixStack, mouseX, mouseY);
        // render quest icons
        for(Widget child : this.buttons){
            child.render(matrixStack, mouseX, mouseY, partialTicks);
            if(child instanceof BookWidget && ((BookWidget) child).isClose()){
                onClose();
            }
        }

    }

    @Override
    protected void init() {
        super.init();
        this.buttons.clear();
        int widgetSize = 24;
        int columns = 0, rows = 0;
        for(int i = 0; i < stacks.size(); i++){
            addButton(new BookWidget(this.width/6 + widgetSize * rows, this.height / 6 + widgetSize * columns, widgetSize,widgetSize,new StringTextComponent(""), stacks.get(i)));
            columns = (i % 10 == 0  && i > 0 )? columns + 1 : columns;
            rows = (i % 10 == 0  && i > 0 )? 0 : rows + 1;
            columns = this.width/6 + widgetSize * i + widgetSize + widgetSize >= this.width ? columns + 1 : columns;
            rows = this.height / 6 + widgetSize * i + widgetSize + widgetSize >= height ? 0 : rows;
        }
    }

    @Override
    public void onClose() {
        super.onClose();
        ClientUtil.resetBooks();
    }

    @Override
    public void renderBackground(@Nonnull MatrixStack matrixStack) {
        super.renderBackground(matrixStack);
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(GUI);
        this.blit(matrixStack, 0, 0, 0, 0, 256, 256);
    }


    private void drawTextLines(MatrixStack matrixStack, int x , int y) {
            drawString(matrixStack,minecraft.font,title,this.width / 2 - (minecraft.font.width(title) / 2),this.height / 8,0xFFFFFF);
    }
}