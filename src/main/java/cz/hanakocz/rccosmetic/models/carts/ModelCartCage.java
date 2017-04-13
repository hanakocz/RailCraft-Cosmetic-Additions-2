package cz.hanakocz.rccosmetic.models.carts;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCartCage extends ModelCartBase
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
	    ModelRenderer columnFrontLeft;
	    ModelRenderer columnFrontRight;
	    ModelRenderer columnRearLeft;
	    ModelRenderer columnRearRight;
	    ModelRenderer cageLeftBot;
	    ModelRenderer cageRightBot;
	    ModelRenderer cageRearBot;
	    ModelRenderer cageFrontBot;
	    ModelRenderer cageRightMid;
	    ModelRenderer cageRightUp;
	    ModelRenderer cageLeftMid;
	    ModelRenderer cageLeftUp;
	    ModelRenderer cageRearMid;
	    ModelRenderer cageRearUp;
	    ModelRenderer cageFrontMid;
	    ModelRenderer cageFrontUp;
	  
	  public ModelCartCage()
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
	      columnFrontLeft = new ModelRenderer(this, 0, 34);
	      columnFrontLeft.addBox(0F, 0F, 0F, 1, 8, 1);
	      columnFrontLeft.setRotationPoint(-7F, -6F, -12F);
	      columnFrontLeft.setTextureSize(128, 64);
	      columnFrontLeft.mirror = true;
	      setRotation(columnFrontLeft, 0F, 0F, 0F);
	      columnFrontRight = new ModelRenderer(this, 5, 34);
	      columnFrontRight.addBox(0F, 0F, 0F, 1, 8, 1);
	      columnFrontRight.setRotationPoint(6F, -6F, -12F);
	      columnFrontRight.setTextureSize(128, 64);
	      columnFrontRight.mirror = true;
	      setRotation(columnFrontRight, 0F, 0F, 0F);
	      columnRearLeft = new ModelRenderer(this, 0, 44);
	      columnRearLeft.addBox(0F, 0F, 0F, 1, 8, 1);
	      columnRearLeft.setRotationPoint(-7F, -6F, 11F);
	      columnRearLeft.setTextureSize(128, 64);
	      columnRearLeft.mirror = true;
	      setRotation(columnRearLeft, 0F, 0F, 0F);
	      columnRearRight = new ModelRenderer(this, 5, 44);
	      columnRearRight.addBox(0F, 0F, 0F, 1, 8, 1);
	      columnRearRight.setRotationPoint(6F, -6F, 11F);
	      columnRearRight.setTextureSize(128, 64);
	      columnRearRight.mirror = true;
	      setRotation(columnRearRight, 0F, 0F, 0F);
	      cageLeftBot = new ModelRenderer(this, 0, 34);
	      cageLeftBot.addBox(0F, 0F, 0F, 1, 1, 22);
	      cageLeftBot.setRotationPoint(-7F, 1F, -11F);
	      cageLeftBot.setTextureSize(128, 64);
	      cageLeftBot.mirror = true;
	      setRotation(cageLeftBot, 0F, 0F, 0F);
	      cageRightBot = new ModelRenderer(this, 0, 34);
	      cageRightBot.addBox(0F, 0F, 1F, 1, 1, 22);
	      cageRightBot.setRotationPoint(6F, 1F, -12F);
	      cageRightBot.setTextureSize(128, 64);
	      cageRightBot.mirror = true;
	      setRotation(cageRightBot, 0F, 0F, 0F);
	      cageRearBot = new ModelRenderer(this, 25, 50);
	      cageRearBot.addBox(0F, 0F, 0F, 12, 1, 1);
	      cageRearBot.setRotationPoint(-6F, 1F, 11F);
	      cageRearBot.setTextureSize(128, 64);
	      cageRearBot.mirror = true;
	      setRotation(cageRearBot, 0F, 0F, 0F);
	      cageFrontBot = new ModelRenderer(this, 25, 47);
	      cageFrontBot.addBox(0F, 0F, 0F, 12, 1, 1);
	      cageFrontBot.setRotationPoint(-6F, 1F, -12F);
	      cageFrontBot.setTextureSize(128, 64);
	      cageFrontBot.mirror = true;
	      setRotation(cageFrontBot, 0F, 0F, 0F);
	      cageRightMid = new ModelRenderer(this, 46, 34);
	      cageRightMid.addBox(0F, 0F, 0F, 1, 1, 22);
	      cageRightMid.setRotationPoint(6F, -2F, -11F);
	      cageRightMid.setTextureSize(128, 64);
	      cageRightMid.mirror = true;
	      setRotation(cageRightMid, 0F, 0F, 0F);
	      cageRightUp = new ModelRenderer(this, 76, 0);
	      cageRightUp.addBox(0F, 0F, 0F, 1, 1, 22);
	      cageRightUp.setRotationPoint(6F, -5F, -11F);
	      cageRightUp.setTextureSize(128, 64);
	      cageRightUp.mirror = true;
	      setRotation(cageRightUp, 0F, 0F, 0F);
	      cageLeftMid = new ModelRenderer(this, 46, 34);
	      cageLeftMid.addBox(0F, 0F, 0F, 1, 1, 22);
	      cageLeftMid.setRotationPoint(-7F, -2F, -11F);
	      cageLeftMid.setTextureSize(128, 64);
	      cageLeftMid.mirror = true;
	      setRotation(cageLeftMid, 0F, 0F, 0F);
	      cageLeftUp = new ModelRenderer(this, 76, 0);
	      cageLeftUp.addBox(0F, 0F, 0F, 1, 1, 22);
	      cageLeftUp.setRotationPoint(-7F, -5F, -11F);
	      cageLeftUp.setTextureSize(128, 64);
	      cageLeftUp.mirror = true;
	      setRotation(cageLeftUp, 0F, 0F, 0F);
	      cageRearMid = new ModelRenderer(this, 25, 44);
	      cageRearMid.addBox(0F, 0F, 0F, 12, 1, 1);
	      cageRearMid.setRotationPoint(-6F, -2F, 11F);
	      cageRearMid.setTextureSize(128, 64);
	      cageRearMid.mirror = true;
	      setRotation(cageRearMid, 0F, 0F, 0F);
	      cageRearUp = new ModelRenderer(this, 25, 38);
	      cageRearUp.addBox(0F, 0F, 0F, 12, 1, 1);
	      cageRearUp.setRotationPoint(-6F, -5F, 11F);
	      cageRearUp.setTextureSize(128, 64);
	      cageRearUp.mirror = true;
	      setRotation(cageRearUp, 0F, 0F, 0F);
	      cageFrontMid = new ModelRenderer(this, 25, 41);
	      cageFrontMid.addBox(0F, 0F, 0F, 12, 1, 1);
	      cageFrontMid.setRotationPoint(-6F, -2F, -12F);
	      cageFrontMid.setTextureSize(128, 64);
	      cageFrontMid.mirror = true;
	      setRotation(cageFrontMid, 0F, 0F, 0F);
	      cageFrontUp = new ModelRenderer(this, 25, 35);
	      cageFrontUp.addBox(0F, 0F, 0F, 12, 1, 1);
	      cageFrontUp.setRotationPoint(-6F, -5F, -12F);
	      cageFrontUp.setTextureSize(128, 64);
	      cageFrontUp.mirror = true;
	      setRotation(cageFrontUp, 0F, 0F, 0F);
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
	    columnFrontLeft.render(f5);
	    columnFrontRight.render(f5);
	    columnRearLeft.render(f5);
	    columnRearRight.render(f5);
	    cageLeftBot.render(f5);
	    cageRightBot.render(f5);
	    cageRearBot.render(f5);
	    cageFrontBot.render(f5);
	    cageRightMid.render(f5);
	    cageRightUp.render(f5);
	    cageLeftMid.render(f5);
	    cageLeftUp.render(f5);
	    cageRearMid.render(f5);
	    cageRearUp.render(f5);
	    cageFrontMid.render(f5);
	    cageFrontUp.render(f5);
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
