package cz.hanakocz.rccosmetic.events;

import cz.hanakocz.rccosmetic.entity.carts.EntityCartCouch;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;

public class CartDiscSound extends MovingSound
{
	private final EntityCartCouch cart;
	//private int time;	

	public CartDiscSound(SoundEvent sound, EntityCartCouch cart) 
	{			
		super(sound, SoundCategory.RECORDS);
		this.cart = cart;
		this.repeat = false;
		this.repeatDelay = 100;
		this.volume = 1.0F;
	}

	@Override
	public void update()
    {
        //++this.time;
        if (!this.cart.isDead && this.cart.discIn() && this.cart.hasFuel())
        {
        	if (!cart.isPlaying())
        	{
        		cart.setPlay(true);
        	}
            this.xPosF = (float)this.cart.posX;
            this.yPosF = (float)this.cart.posY;
            this.zPosF = (float)this.cart.posZ;
            /*float f = MathHelper.sqrt_double(this.cart.motionX * this.cart.motionX + this.cart.motionZ * this.cart.motionZ + this.cart.motionY * this.cart.motionY);
            float f1 = f / 2.0F;

            if ((double)f >= 0.01D)
            {
                this.volume = MathHelper.clamp_float(f1 * f1, 0.0F, 1.0F);
            }
            else
            {
                this.volume = 0.0F;
            }*/

           /* if (this.time < 20)
            {
                this.volume = 0.0F;
            }
            else if (this.time < 40)
            {
                this.volume = (float)((double)this.volume * ((double)(this.time - 20) / 20.0D));
            }*/

            //float f2 = 0.8F;

            if (this.volume > 0.8F)
            {
                this.pitch = 1.0F + (this.volume - 0.8F);
            }
            else
            {
                this.pitch = 1.0F;
            }
        }
        else
        {
        	System.out.println("End of playing.");
            this.donePlaying = true;
            cart.setPlay(false);
        }
    }

}
