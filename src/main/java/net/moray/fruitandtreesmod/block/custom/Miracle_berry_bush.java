package net.moray.fruitandtreesmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.moray.fruitandtreesmod.Item.ModItems;
import net.moray.fruitandtreesmod.effect.Modeffects;


public class Miracle_berry_bush extends SweetBerryBushBlock {


    public Miracle_berry_bush(Properties p_51021_) {
        super(p_51021_);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }



   @Override
    public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
        return new ItemStack(ModItems.Miracle_seed.get());
    }



  @Override
    public void entityInside(BlockState p_57270_, Level p_57271_, BlockPos p_57272_, Entity p_57273_) {

        if(p_57273_ instanceof LivingEntity&&p_57273_.getType()== EntityType.PLAYER){

            ((LivingEntity) p_57273_).addEffect(new MobEffectInstance(Modeffects.Miraculin.get(),1,0));
        }

  }




    @Override
    public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
        int i = p_57275_.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        }
        else if (i==2){
            return InteractionResult.FAIL;
        }
        else if (i > 2) {
            int j = 1 + p_57276_.random.nextInt(2);
            popResource(p_57276_, p_57277_, new ItemStack(ModItems.Miracle_berry.get(), j + (flag ? 1 : 0)));
            p_57276_.playSound((Player)null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
            BlockState blockstate = p_57275_.setValue(AGE, 1);
            p_57276_.setBlock(p_57277_, blockstate, 3);
            p_57276_.gameEvent(GameEvent.BLOCK_CHANGE, p_57277_, GameEvent.Context.of(p_57278_, blockstate));
            return InteractionResult.sidedSuccess(p_57276_.isClientSide);
        }


        else {
            return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
        }
    }




}

