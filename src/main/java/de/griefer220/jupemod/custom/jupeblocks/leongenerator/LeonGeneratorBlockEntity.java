package de.griefer220.jupemod.custom.jupeblocks.leongenerator;

import de.griefer220.jupemod.custom.jupeblocks.leongenerator.screen.LeonGeneratorMenu;
import de.griefer220.jupemod.init.ModBlockEntitys;
import de.griefer220.jupemod.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


//auf blockentity denn cursor/caret machen und dann ctrl+h, alle klassen wie: SculkSensor, Sign, Spawner zum rein gucken und auch stehlen
public class LeonGeneratorBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(2);

    public float energy = 0.0f;

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public LeonGeneratorBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntitys.LEON_GENERATOR_BE.get(), p_155229_, p_155230_);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> LeonGeneratorBlockEntity.this.progress;
                    case 1 -> LeonGeneratorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0 -> LeonGeneratorBlockEntity.this.progress = pValue;
                    case 1 -> LeonGeneratorBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER){
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    @Override
    public Component getDisplayName() {
        return Component.translatable("block.jupemod.leon_generator");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {

        return new LeonGeneratorMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag p_187471_) {
        p_187471_.put("inventory", itemHandler.serializeNBT());
        p_187471_.putInt("leon_grinder_station_progress", progress);

        super.saveAdditional(p_187471_);
    }

    @Override
    public void load(CompoundTag p_155245_) {
        super.load(p_155245_);
        itemHandler.deserializeNBT(p_155245_.getCompound("inventory"));
        progress = p_155245_.getInt("leon_grinder_station_progress");
    }

    private void resetProgress() {
        progress = 0;
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasFuel()){
            increaseFuelGenerationLevel();
            setChanged(pLevel, pPos, pState);
            if(hasProgressFinished()) {
                produceEnergy();
                resetProgress();
            }
        }else {
            resetProgress();
        }
    }

    private void produceEnergy() {
        energy += 0.5f;
        this.itemHandler.extractItem(INPUT_SLOT, 1, false);


    }

    private boolean hasFuel() {
        return this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == ModItems.gelencser_ingot.get();
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseFuelGenerationLevel() {
        progress++;
    }


}
