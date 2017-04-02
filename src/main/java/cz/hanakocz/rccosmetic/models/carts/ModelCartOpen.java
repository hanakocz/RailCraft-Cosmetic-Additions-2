package cz.hanakocz.rccosmetic.models.carts;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCartOpen extends ModelCartBase

{
	//fields
	 ModelRenderer wheelRearRightRear;
	 ModelRenderer wheelRearLeftRear;
	 ModelRenderer wheelRearLeftFront;
	 ModelRenderer wheelRearRightFront;
	 ModelRenderer wheelRear;
	 ModelRenderer wheelFrontRightRear;
	 ModelRenderer wheelFrontLeftFront;
	 ModelRenderer wheelFront;
	 ModelRenderer wheelFrontLeftRear;
	 ModelRenderer wheelFrontRightFront;
	 ModelRenderer cartBottom;
	 ModelRenderer sideFront;
	 ModelRenderer sideRear;
	 ModelRenderer sideLeft;
	 ModelRenderer sideRight;
	 ModelRenderer pile11;
	 ModelRenderer pile12;
	 ModelRenderer pile13;
	 ModelRenderer pile14;
	 ModelRenderer pile21;
	 ModelRenderer pile22;
	 ModelRenderer pile23;
	 ModelRenderer pile24;

	 public ModelCartOpen()
	 {
		 textureWidth = 128;
		 textureHeight = 64;
	 
		 wheelRearRightRear = new ModelRenderer(this, 14, 0);
		 wheelRearRightRear.addBox(5F, 5F, 9F, 1, 2, 3);
		 wheelRearRightRear.setRotationPoint(0F, 0F, 0F);
		 wheelRearRightRear.setTextureSize(128, 64);
		 wheelRearRightRear.mirror = true;
		 setRotation(wheelRearRightRear, 0F, 0F, 0F);
		 wheelRearLeftRear = new ModelRenderer(this, 0, 0);
		 wheelRearLeftRear.addBox(-6F, 5F, 9F, 1, 2, 3);
		 wheelRearLeftRear.setRotationPoint(0F, 0F, 0F);
		 wheelRearLeftRear.setTextureSize(128, 64);
		 wheelRearLeftRear.mirror = true;
		 setRotation(wheelRearLeftRear, 0F, 0F, 0F);
		 wheelRearLeftFront = new ModelRenderer(this, 0, 6);
		 wheelRearLeftFront.addBox(-6F, 5F, 5F, 1, 2, 3);
		 wheelRearLeftFront.setRotationPoint(0F, 0F, 0F);
		 wheelRearLeftFront.setTextureSize(128, 64);
		 wheelRearLeftFront.mirror = true;
		 setRotation(wheelRearLeftFront, 0F, 0F, 0F);
		 wheelRearRightFront = new ModelRenderer(this, 14, 6);
		 wheelRearRightFront.addBox(5F, 5F, 5F, 1, 2, 3);
		 wheelRearRightFront.setRotationPoint(0F, 0F, 0F);
		 wheelRearRightFront.setTextureSize(128, 64);
		 wheelRearRightFront.mirror = true;
		 setRotation(wheelRearRightFront, 0F, 0F, 0F);
		 wheelRear = new ModelRenderer(this, 0, 25);
		 wheelRear.addBox(-7F, 3F, 5F, 14, 2, 7);
		 wheelRear.setRotationPoint(0F, 0F, 0F);
		 wheelRear.setTextureSize(128, 64);
		 wheelRear.mirror = true;
		 setRotation(wheelRear, 0F, 0F, 0F);
		 wheelFrontRightRear = new ModelRenderer(this, 14, 12);
		 wheelFrontRightRear.addBox(5F, 5F, -8F, 1, 2, 3);
		 wheelFrontRightRear.setRotationPoint(0F, 0F, 0F);
		 wheelFrontRightRear.setTextureSize(128, 64);
		 wheelFrontRightRear.mirror = true;
		 setRotation(wheelFrontRightRear, 0F, 0F, 0F);
		 wheelFrontLeftFront = new ModelRenderer(this, 0, 18);
		 wheelFrontLeftFront.addBox(-6F, 5F, -12F, 1, 2, 3);
		 wheelFrontLeftFront.setRotationPoint(0F, 0F, 0F);
		 wheelFrontLeftFront.setTextureSize(128, 64);
		 wheelFrontLeftFront.mirror = true;
		 setRotation(wheelFrontLeftFront, 0F, 0F, 0F);
		 wheelFront = new ModelRenderer(this, 42, 25);
		 wheelFront.addBox(-7F, 3F, -12F, 14, 2, 7);
		 wheelFront.setRotationPoint(0F, 0F, 0F);
		 wheelFront.setTextureSize(128, 64);
		 wheelFront.mirror = true;
		 setRotation(wheelFront, 0F, 0F, 0F);
		 wheelFrontLeftRear = new ModelRenderer(this, 0, 12);
		 wheelFrontLeftRear.addBox(-6F, 5F, -8F, 1, 2, 3);
		 wheelFrontLeftRear.setRotationPoint(0F, 0F, 0F);
		 wheelFrontLeftRear.setTextureSize(128, 64);
		 wheelFrontLeftRear.mirror = true;
		 setRotation(wheelFrontLeftRear, 0F, 0F, 0F);
		 wheelFrontRightFront = new ModelRenderer(this, 14, 18);
		 wheelFrontRightFront.addBox(5F, 5F, -12F, 1, 2, 3);
		 wheelFrontRightFront.setRotationPoint(0F, 0F, 0F);
		 wheelFrontRightFront.setTextureSize(128, 64);
		 wheelFrontRightFront.mirror = true;
		 setRotation(wheelFrontRightFront, 0F, 0F, 0F);
		 cartBottom = new ModelRenderer(this, 0, 0);
		 cartBottom.addBox(-7F, 2F, -12F, 14, 1, 24);
		 cartBottom.setRotationPoint(0F, 0F, 0F);
		 cartBottom.setTextureSize(128, 64);
		 cartBottom.mirror = true;
		 setRotation(cartBottom, 0F, 0F, 0F);
		 sideFront = new ModelRenderer(this, 53, 0);
		 sideFront.addBox(0F, 0F, 0F, 14, 8, 1);
		 sideFront.setRotationPoint(-7F, -6F, -12F);
		 sideFront.setTextureSize(128, 64);
		 sideFront.mirror = true;
		 setRotation(sideFront, 0F, 0F, 0F);
		 sideRear = new ModelRenderer(this, 53, 10);
		 sideRear.addBox(0F, 0F, 0F, 14, 8, 1);
		 sideRear.setRotationPoint(-7F, -6F, 11F);
		 sideRear.setTextureSize(128, 64);
		 sideRear.mirror = true;
		 setRotation(sideRear, 0F, 0F, 0F);
		 sideLeft = new ModelRenderer(this, 0, 34);
		 sideLeft.addBox(0F, 0F, 0F, 1, 8, 22);
		 sideLeft.setRotationPoint(6F, -6F, -11F);
		 sideLeft.setTextureSize(128, 64);
		 sideLeft.mirror = true;
		 setRotation(sideLeft, 0F, 0F, 0F);
		 sideRight = new ModelRenderer(this, 47, 34);
		 sideRight.addBox(0F, 0F, 0F, 1, 8, 22);
		 sideRight.setRotationPoint(-7F, -6F, -11F);
		 sideRight.setTextureSize(128, 64);
		 sideRight.mirror = true;
		 setRotation(sideRight, 0F, 0F, 0F);
		 pile11 = new ModelRenderer(this, 83, 0);
		 pile11.addBox(0F, 0F, 0F, 12, 5, 10);
		 pile11.setRotationPoint(-6F, -3F, 1F);
		 pile11.setTextureSize(128, 64);
		 pile11.mirror = true;
		 setRotation(pile11, 0F, 0F, 0F);
		 pile12 = new ModelRenderer(this, 84, 16);
		 pile12.addBox(0F, 0F, 0F, 12, 1, 9);
		 pile12.setRotationPoint(-6F, -4F, 2F);
		 pile12.setTextureSize(128, 64);
		 pile12.mirror = true;
		 setRotation(pile12, 0F, 0F, 0F);
		 pile13 = new ModelRenderer(this, 94, 56);
		 pile13.addBox(0F, 0F, 0F, 10, 1, 7);
		 pile13.setRotationPoint(-5F, -5F, 3F);
		 pile13.setTextureSize(128, 64);
		 pile13.mirror = true;
		 setRotation(pile13, 0F, 0F, 0F);
		 pile14 = new ModelRenderer(this, 45, 45);
		 pile14.addBox(0F, 0F, 0F, 8, 1, 3);
		 pile14.setRotationPoint(-4F, -6F, 5F);
		 pile14.setTextureSize(128, 64);
		 pile14.mirror = true;
		 setRotation(pile14, 0F, 0F, 0F);
		 pile21 = new ModelRenderer(this, 80, 40);
		 pile21.addBox(0F, 0F, 0F, 12, 3, 12);
		 pile21.setRotationPoint(-6F, -2F, -11F);
		 pile21.setTextureSize(128, 64);
		 pile21.mirror = true;
		 setRotation(pile21, 0F, 0F, 0F);
		 pile22 = new ModelRenderer(this, 84, 29);
		 pile22.addBox(0F, 0F, 0F, 12, 2, 9);
		 pile22.setRotationPoint(-6F, -4F, -9F);
		 pile22.setTextureSize(128, 64);
		 pile22.mirror = true;
		 setRotation(pile22, 0F, 0F, 0F);
		 pile23 = new ModelRenderer(this, 32, 36);
		 pile23.addBox(0F, 0F, 0F, 8, 1, 6);
		 pile23.setRotationPoint(-4F, -5F, -7F);
		 pile23.setTextureSize(128, 64);
		 pile23.mirror = true;
		 setRotation(pile23, 0F, 0F, 0F);
		 pile24 = new ModelRenderer(this, 48, 50);
		 pile24.addBox(0F, 0F, 0F, 5, 1, 4);
		 pile24.setRotationPoint(-2F, -6F, -6F);
		 pile24.setTextureSize(128, 64);
		 pile24.mirror = true;
		 setRotation(pile24, 0F, 0F, 0F);
	}

	 public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int items)
	 {
		 super.render(entity, f, f1, f2, f3, f4, f5);
		 setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		 GL11.glRotatef(90, 0, 1, 0);
		 wheelRearRightRear.render(f5);
		 wheelRearLeftRear.render(f5);
		 wheelRearLeftFront.render(f5);
		 wheelRearRightFront.render(f5);
		 wheelRear.render(f5);
		 wheelFrontRightRear.render(f5);
		 wheelFrontLeftFront.render(f5);
		 wheelFront.render(f5);
		 wheelFrontLeftRear.render(f5);
		 wheelFrontRightFront.render(f5);
		 cartBottom.render(f5);
		 sideFront.render(f5);
		 sideRear.render(f5);
		 sideLeft.render(f5);
		 sideRight.render(f5);
		 if (items > 0) pile11.render(f5);
		 if (items > 1) pile12.render(f5);
		 if (items > 2) pile13.render(f5);
		 if (items > 3) pile14.render(f5);
		 if (items > 4) pile21.render(f5);
		 if (items > 5) pile22.render(f5);
		 if (items > 6) pile23.render(f5);
		 if (items > 7) pile24.render(f5);
	 }

	 private void setRotation(ModelRenderer model, float x, float y, float z)
	 {
		 model.rotateAngleX = x;
		 model.rotateAngleY = y;
		 model.rotateAngleZ = z;
	 }

	 public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	 {
		 super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	 }

}
