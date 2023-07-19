package net.moray.fruitandtreesmod.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class Miraculin extends MobEffect {


    public Miraculin(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity p_19467_, int p_19468_) {

        if(p_19467_.hasEffect(MobEffects.POISON)){

        p_19467_.removeEffect(MobEffects.POISON);
        p_19467_.addEffect(new MobEffectInstance(MobEffects.REGENERATION,200,p_19468_));}



    super.applyEffectTick(p_19467_,p_19468_);
    }
       @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }


}
